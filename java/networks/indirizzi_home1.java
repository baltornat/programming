import java.net.InetAddress;
import java.net.UnknownHostException;

// codice gestione indirizzi IP / nomi simbolici

public class indirizzi_home1{
  public static void main(String[] args){
    String nome = "www.google.com"; // da convertire in indirizzo IP

    try{
      InetAddress ia = InetAddress.getAllByName(nome);
      byte[] ndp = ia.getAddress();
      for(int i=0; i<ia.length; i+=1){
      	System.out.println("Indirizzo " + ia[i].getHostName() + " ---> " + ia[i].getHostAddress()); 
      }
    }
    catch(UnknownHostException uhe){
      uhe.printStackTrace();
    }
  }
}
