/*
 * INVIO AL SERVER UNA STRINGA, PER ESEMPIO (CIAO COME STAI?)
 * IL SERVER MI INVIA UNA RISPOSTA PER OGNI PAROLA RICEVUTA, QUINDI;
 * 1) CIAO
 * 2) COME
 * 3) STAI?
 * */


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMultithread {
    public static void main(String[] args){
        String input, output;
        String[] parole;
        Scanner in;
        int porta, letti, dim = 100;
        byte[] buf = new byte[dim];
        InetAddress ia;
        InetSocketAddress isa;
        OutputStream os;
        InputStream is;
        try{
            in = new Scanner(System.in);
            //Leggo la porta da args
            porta = Integer.parseInt(args[0]);
            //Costruisco la socket
            ia = InetAddress.getLocalHost();
            isa = new InetSocketAddress(ia, porta);
            Socket client = new Socket();
            //Mi collego al server
            client.connect(isa);
            System.out.println("Porta client: " + client.getLocalPort());
            while(true){
                //Termina con "."
                System.out.println("Inserisci una stringa: ");
                input = in.nextLine();
                //Invio la stringa al server
                os = client.getOutputStream();
                os.write(input.getBytes(), 0, input.length());
                if(input.equals(".")){
                    break;
                }
                //Faccio un for lungo quante sono le parole nella stringa che ho inviato
                parole = input.split(" ");
                is = client.getInputStream();
                System.out.println("Ricezione...");
                for(int i=0; i<parole.length; i++){
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    System.out.println(i + ") " + output);
                    os.write(("ACK" + i).getBytes(), 0, ("ACK" + i).length());
                }
            }
            client.close();
        }catch(NumberFormatException nfe){
            System.out.println("Non hai inserito un numero!");
        }catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("Non hai inserito abbastanza argomenti!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

