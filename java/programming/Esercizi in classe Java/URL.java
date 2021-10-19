import java.util.*;

public classe URL{
  private String protocol;
  private String host;
  private String path;

  public URL(String url){
    int pos=URL.indexOf(':');
    protocol=URL.substring(0,pos);
    int barra=URL.indexOf('/',pos+3);
    host=URL.substring(pos+3,barra);
    path=URL.substring(barra);
  }

  public boolean sameHost(URL u){
    return host.equals(u.host);
  }
}
