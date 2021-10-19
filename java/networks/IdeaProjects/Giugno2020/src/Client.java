import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        int dim = 20, letti;
        byte[] buf = new byte[dim];
        int porta = Integer.parseInt(args[0]);
        String invio, ricezione, nick;
        OutputStream os;
        InputStream is;
        Scanner in = new Scanner(System.in);
        try{
            Socket client = new Socket();
            //Connessione al server
            InetAddress ia = InetAddress.getLocalHost();
            InetSocketAddress isa = new InetSocketAddress(ia, porta);
            client.connect(isa);
            System.out.println("Indirizzo client: " + client.getInetAddress() + "; Porta: " + client.getLocalPort());
            while(true){
                //Invio username al server
                System.out.println("Inserisci lo username: ");
                nick = in.nextLine();
                os = client.getOutputStream();
                os.write(nick.getBytes(),0, nick.length());
                //Leggo ACK_1 / NACK_1
                is = client.getInputStream();
                letti = is.read(buf);
                ricezione = new String(buf, 0, letti);
                if(ricezione.equals("ACK_1")){
                    System.out.println(ricezione);
                    break;
                }else{
                    System.out.println(ricezione);
                }
            }
            while(true){
                //Inizio conversazione
                System.out.println("Premi un tasto per iniziare la conversazione: ");
                invio = in.nextLine();
                os.write(invio.getBytes(), 0, invio.length());
                //Attesa ACK/NACK
                System.out.println("Attendo che il server mi comunichi se inviare o ricevere...");
                letti = is.read(buf);
                ricezione = new String(buf, 0, letti);
                //ACK = Invia o ACK = Ricevi
                switch(ricezione){
                    case "Invia":
                        System.out.println("Tocca a te inviare");
                        while(true){
                            System.out.println("Inserisci il testo del messaggio (max 20 char): ");
                            invio = in.nextLine();
                            if(invio.equals(".")){
                                os.write("Termino".getBytes(), 0, "Termino".length());
                                //Attesa ACK/NACK
                                System.out.println("In attesa dell'ACK_TERMINE del server...");
                                letti = is.read(buf);
                                ricezione = new String(buf, 0, letti);
                                System.out.println("Ricevuto: " + ricezione);
                                break;
                            }
                            //Se diverso da "." invio il testo al server
                            os.write(invio.getBytes(), 0, invio.length());
                            //Attesa ACK/NACK
                            System.out.println("In attesa dell'ACK_3 del server...");
                            letti = is.read(buf);
                            ricezione = new String(buf, 0, letti);
                            System.out.println("Ricevuto: " + ricezione);
                            //Attesa della risposta del client B
                            System.out.println("In attesa della risposta dell'altro host...");
                            letti = is.read(buf);
                            ricezione = new String(buf, 0, letti);
                            //Se ricevuto "TERMINE" termina
                            if(ricezione.equals("TERMINE")){
                                os.write("Termino".getBytes(), 0, "Termino".length());
                                break;
                            }
                            System.out.println("Risposta: " + ricezione);
                        }
                        break;
                    case "Ricevi":
                        System.out.println("Tocca a te ricevere");
                        while(true){
                            System.out.println("In attesa del testo dell'altro host...");
                            letti = is.read(buf);
                            ricezione = new String(buf, 0, letti);
                            //Se ricevuto "TERMINE" termina
                            if(ricezione.equals("TERMINE")){
                                os.write("Termino".getBytes(), 0, "Termino".length());
                                break;
                            }
                            System.out.println(ricezione);
                            //Invio ACK al server
                            os.write("Ricevuto!".getBytes(), 0, "Ricevuto!".length());
                        }
                        break;
                    default:
                        System.out.println("Errore");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
