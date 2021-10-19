import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;

public class WebServer {
    public static void main(String[] args){
        ArrayList<String> utenti = new ArrayList<String>();
        int dim = 100, letti, porta_stream = Integer.parseInt(args[0]);
        byte[] buf = new byte[dim];
        String output, input;
        OutputStream os;
        InputStream is;
        Socket toClient;
        DatagramPacket dpSend;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            ServerSocket serv = new ServerSocket(0);
            System.out.println("Indirizzo server: " + serv.getInetAddress() + "; Porta server: " + serv.getLocalPort());
            do {
                toClient = serv.accept();
                System.out.println("Client connesso: " + toClient.getInetAddress() + "; Porta: " + toClient.getPort());
                is = toClient.getInputStream();
                letti = is.read(buf);
                output = new String(buf, 0, letti);
                System.out.println("Ricevuto: " + output);
                //Indirizzo:portaTCP:portaUDP
                input = toClient.getInetAddress().getHostAddress() + "-" + Integer.toString(toClient.getPort()) + "-" + output;
                if (!utenti.contains(input)) {
                    utenti.add(input);
                }
                os = toClient.getOutputStream();
                os.write("ACK".getBytes(), 0, "ACK".length());
                //Chiusura connessione
                toClient.close();
            } while (utenti.size() <= 2);
            //Il server si rimette in ascolto
            dpSend = new DatagramPacket("START".getBytes(), "START".length(), ia, porta_stream);
            ds.send(dpSend);
            for (int i = 0; i < utenti.size(); i++) {
                dpSend = new DatagramPacket(utenti.get(i).getBytes(), utenti.get(i).length(), ia, porta_stream);
                ds.send(dpSend);
            }
            while (true) {
                input = "";
                //Controllo se l'utente che si riconnette è registrato
                do {
                    toClient = serv.accept();
                    is = toClient.getInputStream();
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    System.out.println("Ricevuto: " + output);
                    input = toClient.getInetAddress().getHostAddress() + "-" + Integer.toString(toClient.getPort()) + "-" + output;
                    if (!utenti.contains(input)) {
                        System.out.println("Client connesso non registrato");
                        toClient.close();
                    }
                } while (utenti.contains(input));
                is = toClient.getInputStream();
                letti = is.read(buf);
                output = new String(buf, 0, letti);
                System.out.println("Ricevuto: " + output);
                os = toClient.getOutputStream();
                os.write("ACK".getBytes(), 0, "ACK".length());
                toClient.close();
                //Invio allo stream server la canzone ricevuta
                dpSend = new DatagramPacket(output.getBytes(), output.length(), ia, porta_stream);
                ds.send(dpSend);
            }
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Wrong argument number");
        }catch(NumberFormatException n){
            System.out.println(args[0] + " is not a number!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
