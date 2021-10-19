import java.util.*;

public class QuanteVolteIn{
  public static void main(String[] args){
    int tot = quanteVolteIn(args[0],args[1]);
    System.out.println(tot);
  }

  public static int quanteVolteIn(String a, String b){
    String sottob = b.substring(1);
    if(a.length()>b.length())
      return 0;
    if(b.startsWith(a)){
      return quanteVolteIn(a, sottob)+1;
    }else{
      return quanteVolteIn(a, sottob);
    }
  }
}
