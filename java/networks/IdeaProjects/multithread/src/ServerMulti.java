import java.net.ServerSocket;
import java.net.Socket;

public class ServerMulti {
    public static void main(String[] args){
        ServerSocket server;
        Socket toClient;
        try{
            server = new ServerSocket(0);
            System.out.println("Indirizzo: " + server.getInetAddress() + "; Porta: " + server.getLocalPort());
            while(true){
                toClient = server.accept();
                System.out.println("Ind. client: " + toClient.getInetAddress() + "; Porta: " + toClient.getPort());
                Thread t = new erogaServizio(toClient);
                t.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
