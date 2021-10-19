import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    public static void main(String[] args){
        int max_conn = 2, counter = 0, dim = 100, letti;
        byte[] buf = new byte[dim];
        String nick, invio, ricezione;
        ArrayList<Socket> toClient = new ArrayList<Socket>(max_conn);
        HashMap<String, String> stato = new HashMap<String, String>();
        OutputStream os;
        InputStream is;
        try{
            ServerSocket serv = new ServerSocket(0);
            System.out.println("Indirizzo: " + serv.getInetAddress() + "; Porta: " + serv.getLocalPort());
            while(counter < max_conn) {
                toClient.add(serv.accept());
                counter++;
            }
            //Lo fai 2 volte in attesa che entrambi vengano registrati
            for(int j=0; j<max_conn; j++){
                System.out.println("Ind. Client: " + toClient.get(j).getInetAddress() + " Connesso su porta: " + toClient.get(j).getPort());
                System.out.println("In attesa di username...");
                //Lettura Username
                is = toClient.get(j).getInputStream();
                letti = is.read(buf);
                nick = new String(buf, 0, letti);
                System.out.println("Ricevuto: " + nick);
                if(stato.containsKey(nick)){
                    os = toClient.get(j).getOutputStream();
                    os.write("NACK_1".getBytes(), 0, "NACK_1".length());
                }else{
                    String indirizzo = toClient.get(j).getInetAddress().getHostAddress();
                    stato.put(nick, indirizzo);
                    os = toClient.get(j).getOutputStream();
                    os.write("ACK_1".getBytes(), 0, "ACK_1".length());
                }
            }
            //Faccio partire a inviare il primo che si è connesso
            for(int j=0; j<max_conn; j++){
                is = toClient.get(j).getInputStream();
                letti = is.read(buf);
                ricezione = new String(buf, 0, letti);
                System.out.println("Ind. Client " + j + ": " + toClient.get(j).getInetAddress() + " Connesso su porta: " + toClient.get(j).getPort());
                //Comunico al primo che può inviare
                if(j == 0){
                    os = toClient.get(j).getOutputStream();
                    os.write("Invia".getBytes(), 0, "Invia".length());
                }else{
                    os = toClient.get(j).getOutputStream();
                    os.write("Ricevi".getBytes(), 0, "Ricevi".length());
                }
            }
            while(true){
                //Attendo il testo che devo mandare dal primo al secondo host
                is = toClient.get(0).getInputStream();
                letti = is.read(buf);
                ricezione = new String(buf, 0, letti);
                System.out.println("Ricevuto: " + ricezione);
                if(ricezione.equals("Termino")){
                    os = toClient.get(0).getOutputStream();
                    os.write("TERMINE".getBytes(), 0, "TERMINE".length());
                    os = toClient.get(1).getOutputStream();
                    os.write("TERMINE".getBytes(), 0, "TERMINE".length());
                    break;
                }else{
                    //Ho ricevuto del testo non terminatore, mando ACK a chi manda e testo a chi riceve
                    os = toClient.get(0).getOutputStream();
                    os.write("ACK_3".getBytes(), 0, "ACK_3".length());
                    os = toClient.get(1).getOutputStream();
                    os.write(ricezione.getBytes(), 0, ricezione.length());
                    //Attendo l'ACK del secondo client
                    is = toClient.get(1).getInputStream();
                    letti = is.read(buf);
                    ricezione = new String(buf, 0, letti);
                    System.out.println("Ricevuto: " + ricezione);
                    //Invio l'ACK al primo client
                    os = toClient.get(0).getOutputStream();
                    os.write(ricezione.getBytes(), 0, ricezione.length());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
