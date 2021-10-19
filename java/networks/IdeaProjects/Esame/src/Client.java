import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.Random;

public class Client {
    public static void main(String[] args){
        Random rand;
        Scanner in;
        int porta_server, min = 1, max = 100, dim = 100;
        byte[] buffer = new byte[dim];
        double m;
        String nickname, alpha, beta, invio, ricevuto;
        String[] parametri;
        InetAddress ia;
        DatagramSocket ds;
        DatagramPacket dpReceive, dpSend;
        try{
            in = new Scanner(System.in);
            porta_server = Integer.parseInt(args[0]);
            ia = InetAddress.getLocalHost();
            ds = new DatagramSocket();
            System.out.println("Porta client: " + ds.getLocalPort());
            System.out.println("Inserisci il nickname: ");
            nickname = in.nextLine();
            System.out.println("Inserisci il parametro alpha: ");
            alpha = in.nextLine();
            System.out.println("Inserisci il beta: ");
            beta = in.nextLine();
            //Costruisco il pacchetto e lo invio
            invio = ds.getLocalAddress() + "!" + nickname + "!" + alpha + "!" + beta;
            dpSend = new DatagramPacket(invio.getBytes(), invio.length(), ia, porta_server);
            ds.send(dpSend);
            while(true){
                System.out.println("Inserisci un carattere (. per terminare): ");
                invio = in.nextLine();
                //Se != da "." genero il random M
                if(!invio.equals(".")){
                    rand = new Random();
                    m = min + (max - min) * rand.nextDouble();
                    System.out.println("Generato M = " + m);
                    invio = nickname + "!" + m;
                    dpSend = new DatagramPacket(invio.getBytes(), invio.length(), ia, porta_server);
                    ds.send(dpSend);
                }else{
                    dpSend = new DatagramPacket((nickname + "!" + ".").getBytes(), (nickname + "!" + ".").length(), ia, porta_server);
                    ds.send(dpSend);
                    break;
                }
                //Ricevo risposta dal server
                dpReceive = new DatagramPacket(buffer, dim);
                ds.receive(dpReceive);
                ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                parametri = ricevuto.split("!");
                System.out.println("Nuovo RTT: " + parametri[0] + " - Nuovo D: " + parametri[1] + " - Nuovo RTO: " + parametri[2]);
            }
            ds.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
