import java.net.ServerSocket;
import java.net.Socket;

public class serverMultithread{
  public static void main(String[] args){
    ServerSocket sSrv;
    Socket toClient;
    try{
      sSrv = new ServerSocket(0);
      System.out.println("Indirizzo: " + sSrv.getInetAddress() + "; porta: " + sSrv.getLocalPort());
      while(true){
        toClient = sSrv.accept();
        System.out.println("Ind Client: " + toClient.getInetAddress() + "; porta: " + toClient.getPort());
        Thread t = new erogaServizio(toClient);
        t.start();
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
