import java.net.InetAddress;
import java.net.UnknownHostException;

// codice gestione indirizzi IP / nomi simbolici

public class indirizzi_home2{
  public static void main(String[] args){

    try{
      InetAddress ia = InetAddress.getLocalHost();
      byte[] ndp = ia.getAddress();
      System.out.println("Indirizzo: " + (ndp[0] & 0xff) + "," +
                        (ndp[1] & 0xff) + "," + (ndp[2] & 0xff) +
                        "," + (ndp[3] & 0xff));
    }
    catch(UnknownHostException uhe){
      uhe.printStackTrace();
    }
  }
}
