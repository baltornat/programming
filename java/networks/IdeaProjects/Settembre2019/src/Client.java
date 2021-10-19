import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        int porta_webserver = Integer.parseInt(args[0]), letti, dim = 100, porta_udp;
        byte[] buf = new byte[dim];
        Scanner in = new Scanner(System.in);
        String output, input;
        OutputStream os;
        InputStream is;
        DatagramPacket dpReceive = null;
        try{
            //Socket TCP
            InetAddress ia = InetAddress.getLocalHost();
            InetSocketAddress isa = new InetSocketAddress(ia, porta_webserver);
            Socket client = new Socket();
            //Socket UDP
            DatagramSocket stream = new DatagramSocket();
            client.connect(isa);
            System.out.println("Porta TCP: " + client.getLocalPort() + "; Porta UDP: " + stream.getLocalPort());
            int porta_tcp = client.getLocalPort();
            do{
                porta_udp = stream.getLocalPort();
                //Invio porta UDP al server con TCP
                os = client.getOutputStream();
                os.write(Integer.toString(porta_udp).getBytes(), 0, Integer.toString(porta_udp).length());
                //Leggo ACK
                is = client.getInputStream();
                letti = is.read(buf);
                output = new String(buf, 0, letti);
            }while(!output.equals("ACK"));
            client.close();
            while(true) {
                output = "";
                System.out.println("Scegli tra questi brani o ascolta quello che c'è attualmente in riproduzione: ");
                System.out.println("1) Ernia - Dal QT al QT");
                System.out.println("2) DJ Nochi vs Nepi - Dal TCP al UDP");
                System.out.println("3) Malchiodi - Pallozzi");
                System.out.println("4) GPRed feat. Violetta Lonati - Bocchini gratis");
                System.out.println("5) Danilo Mauro Bruschi - Repetita Iuvant");
                System.out.println("6) Ascolta il brano che è in esecuzione in questo momento");
                input = in.nextLine();
                switch(input){
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                        //Ricreo il socket sulla stessa porta usata prima
                        ia = InetAddress.getLocalHost();
                        isa = new InetSocketAddress(ia, porta_webserver);
                        client = new Socket(ia, porta_webserver, ia, porta_tcp);
                        client.connect(isa);
                        //Invio porta UDP per controllo utente registrato sul server
                        os = client.getOutputStream();
                        os.write(Integer.toString(porta_udp).getBytes(), 0, Integer.toString(porta_udp).length());
                        //Invio canzone scelta
                        os = client.getOutputStream();
                        os.write(input.getBytes(), 0, input.length());
                        //Attendo ACK
                        is = client.getInputStream();
                        letti = is.read(buf);
                        output = new String(buf, 0, letti);
                        System.out.println("Ricevuto: " + output);
                        if(!output.equals("ACK")){
                            break;
                        }
                        client.close();
                        dpReceive = new DatagramPacket(buf, dim);
                        stream.receive(dpReceive);
                        break;
                    case "6":
                        dpReceive = new DatagramPacket(buf, dim);
                        stream.receive(dpReceive);
                        output = "ACK";
                        break;
                    default:
                        System.out.println("Input non valido!");
                }
                if(output.equals("ACK")){
                    output = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    System.out.println("In riproduzione: " + output);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
