import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Utente {
    public static void main(String[] args){
        int porta = Integer.parseInt(args[0]), dim = 100;
        byte[] buf = new byte[dim];
        Scanner in = new Scanner(System.in);
        DatagramPacket dpSend, dpReceive;
        String output;
        try{
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            System.out.println("Porta: " + ds.getLocalPort());
            while(true) {
                System.out.println("Inserisci il codice del treno di cui vuoi sapere il ritardo: ");
                output = in.nextLine();
                if (output.equals(".")) {
                    dpSend = new DatagramPacket(".".getBytes(), ".".length(), ia, porta);
                    ds.send(dpSend);
                    break;
                }
                //Invio stringhe lette
                dpSend = new DatagramPacket(output.getBytes(), output.length(), ia, porta);
                ds.send(dpSend);
                //Ricezione ACK
                dpReceive = new DatagramPacket(buf, dim);
                ds.receive(dpReceive);
                output = new String(dpReceive.getData(), 0, dpReceive.getLength());
                System.out.println("Ricevuto: " + output);
            }
            ds.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
