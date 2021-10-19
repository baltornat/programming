import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ServerConcorrente {
    public static void main(String[] args){
        int max_conn = 4, counter = 0, i = 0, timerServer = 10000, timerClient = 5000, dim = 100, letti;
        byte[] buf = new byte[dim];
        String input, output;
        String[] parole;
        InputStream is;
        OutputStream os;
        ServerSocket serv;
        try{
            serv = new ServerSocket(0);
            System.out.println("Indirizzo server: " + serv.getInetAddress() + "; Porta: " + serv.getLocalPort());
            ArrayList<Socket> toClient = new ArrayList<Socket>(max_conn);
            while(true){
                //Accetto nuove connessioni
                System.out.println("Attendo nuove connessioni...");
                try{
                    while(counter < max_conn){
                        serv.setSoTimeout(timerServer);
                        toClient.add(serv.accept());
                        counter++;
                        System.out.println("Client connesso: " + toClient.get(counter-1).getInetAddress() + "; Porta client: " + toClient.get(counter-1).getPort());
                    }
                }catch(SocketTimeoutException ste){
                    //Nel caso il timer interrupt scatti esattamente tra accept() e counter++ (SITUAZIONE PERICOLOSA)
                    if(counter != toClient.size())
                        counter++;
                    System.out.println("Timer accept() scaduto!");
                }
                //Mando in esecuzione un client
                while(counter > 0){
                    System.out.println("In esecuzione client(" + i + "): " + toClient.get(i).getInetAddress() + "; Porta client: " + toClient.get(i).getPort());
                    try{
                        toClient.get(i).setSoTimeout(timerClient);
                        //Leggo la stringa che mi invia il client
                        is = toClient.get(i).getInputStream();
                        os = toClient.get(i).getOutputStream();
                        while(true){
                            letti = is.read(buf);
                            output = new String(buf, 0, letti);
                            System.out.println("Ricevuto: " + output);
                            if (output.equals("."))
                                break;
                            //Estraggo le parole dalla stringa ricevuta
                            parole = output.split(" ");
                            for(int j=0; j< parole.length; j++){
                                os.write(parole[j].getBytes(), 0, parole[j].length());
                                letti = is.read(buf);
                                output = new String(buf, 0, letti);
                                System.out.println("Ricevuto: " + output);
                            }
                        }
                        toClient.get(i).close();
                        toClient.remove(i);
                        counter--;
                    }catch(SocketTimeoutException ste){
                        if(counter != toClient.size())
                            counter--;
                        System.out.println("Timer client scaduto!");
                    }
                    i = counter !=0 ? (i+1)%counter : 0;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
