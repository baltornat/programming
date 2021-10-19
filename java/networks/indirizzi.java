import java.net.InetAddress;
import java.net.UnknownHostException;

// codice gestione indirizzi IP / nomi simbolici

public class indirizzi{
  public static void main(String[] args){
    String nome = "www.youtube.it"; // da convertire in indirizzo IP

    try{
      InetAddress ia = InetAddress.getByName(nome);
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
