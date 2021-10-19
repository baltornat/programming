import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class StreamingServer {
    public static void main(String[] args){
        int dim = 100;
        byte[] buf = new byte[dim];
        String output;
        String[] tupla;
        ArrayList<String> utenti = new ArrayList<String>();
        try {
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dpSend, dpReceive;
            System.out.println("Indirizzo server: " + ds.getLocalAddress() + "; Porta: " + ds.getLocalPort());
            dpReceive = new DatagramPacket(buf, dim);
            ds.receive(dpReceive);
            output = new String(dpReceive.getData(),0, dpReceive.getLength());
            System.out.println("Ricevuto: " + output);
            //Ricevo gli utenti registrati
            for(int i=0; i<2; i++){
                ds.receive(dpReceive);
                output = new String(dpReceive.getData(),0, dpReceive.getLength());
                System.out.println("Ricevuto: " + output);
                utenti.add(output);
            }
            while(true) {
                ds.receive(dpReceive);
                output = new String(dpReceive.getData(), 0, dpReceive.getLength());
                System.out.println("Brano richiesto: " + output);
                for (int i = 0; i < 2; i++) {
                    tupla = utenti.get(i).split("-");
                    dpSend = new DatagramPacket(output.getBytes(), output.length(), InetAddress.getByName(tupla[0]), Integer.parseInt(tupla[2]));
                    ds.send(dpSend);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
