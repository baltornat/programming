import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultithread {
    public static void main(String[] args){
        ServerSocket serv;
        Socket toClient;
        Thread t;
        try{
            serv = new ServerSocket(0);
            System.out.println("Indirizzo server: " + serv.getInetAddress() + "; Porta server: " + serv.getLocalPort());
            while(true){
                toClient = serv.accept();
                System.out.println("Ind. client: " + toClient.getInetAddress() + "; Porta: " + toClient.getPort());
                t = new ErogaServizio(toClient);
                t.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
