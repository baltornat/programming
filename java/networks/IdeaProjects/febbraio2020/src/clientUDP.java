import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clientUDP {
    public static void main(String[] args){
        int dim = 20;
        byte[] buffer = new byte[dim];
        String username, ricevuto, invio;
        int porta = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        try{
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dpReceive, dpSend;
            System.out.println("Indirizzo client: " + ds.getLocalAddress() + "; Porta client: " + ds.getLocalPort());
            dpReceive = new DatagramPacket(buffer, dim);
            while(true){
                do{
                    System.out.println("Inserisci lo username: ");
                    username = in.nextLine();
                    dpSend = new DatagramPacket(username.getBytes(), username.length(), ia, porta);
                    ds.send(dpSend);
                    ds.receive(dpReceive);
                    ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    if(!ricevuto.equals("ACK"))
                        System.out.println("Username non valido");
                }while(!ricevuto.equals("ACK"));
                while(true){
                    System.out.println("Inserisci qualcosa per modificare il contenuto: ");
                    invio = in.nextLine();
                    if(invio.equals(".")){
                        dpSend = new DatagramPacket(invio.getBytes(), invio.length(), ia, porta);
                        ds.send(dpSend);
                        break;
                    }
                    dpSend = new DatagramPacket(invio.getBytes(), invio.length(), ia, porta);
                    ds.send(dpSend);
                    //Leggo la risposta
                    ds.receive(dpReceive);
                    ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    System.out.println("Ricevuto: " + ricevuto);
                    System.out.println("Inserisci il nuovo contenuto: ");
                    invio = in.nextLine();
                    dpSend = new DatagramPacket(invio.getBytes(), invio.length(), ia, porta);
                    ds.send(dpSend);
                    //Attendo la risposta del server
                    ds.receive(dpReceive);
                    ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    System.out.println("Ricevuto: " + ricevuto);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
