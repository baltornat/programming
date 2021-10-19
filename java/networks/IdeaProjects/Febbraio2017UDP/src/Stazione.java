import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Stazione {
    public static void main(String[] args){
        int dim = 100;
        byte[] buf = new byte[dim];
        DatagramPacket dpSend, dpReceive;
        Scanner in = new Scanner(System.in);
        String treno, ritardo, output, input;
        try{
            int porta = Integer.parseInt(args[0]);
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            System.out.println("Porta client: " + ds.getLocalPort());
            while(true) {
                System.out.println("Inserisci il codice del treno appena transitato: ");
                treno = in.nextLine();
                if(treno.equals(".")){
                    dpSend = new DatagramPacket(".".getBytes(), ".".length(), ia, porta);
                    ds.send(dpSend);
                    break;
                }
                System.out.println("Inserisci i minuti di ritardo: ");
                ritardo = in.nextLine();
                if(ritardo.equals(".")){
                    dpSend = new DatagramPacket(".".getBytes(), ".".length(), ia, porta);
                    ds.send(dpSend);
                    break;
                }
                //Invio stringhe lette
                output = treno + ":" + ritardo;
                dpSend = new DatagramPacket(output.getBytes(), output.length(), ia, porta);
                ds.send(dpSend);
                //Ricezione ACK
                dpReceive = new DatagramPacket(buf, dim);
                ds.receive(dpReceive);
                input = new String(dpReceive.getData(), 0, dpReceive.getLength());
                System.out.println("Ricevuto: " + input);
            }
            ds.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
