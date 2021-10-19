import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    public static void main(String[] args){
        double rto, rttnew, dnew, alpha, beta, d, m, rtt;
        int dim = 100, counter = 0;
        byte[] buffer = new byte[dim];
        String ricevuto, invio;
        String[] parametri, splitted1, splitted2;
        DatagramSocket server;
        DatagramPacket dpSend, dpReceive;
        try{
            HashMap<String, ArrayList<String>> utenti = new HashMap<String, ArrayList<String>>();
            HashMap<String, String> round_devia = new HashMap<String, String>();
            server = new DatagramSocket();
            System.out.println("IP Server: " + server.getLocalAddress() + "; Porta: " + server.getLocalPort());
            while(true) {
                System.out.println("In attesa di ricevere un messaggio di presentazione... ");
                dpReceive = new DatagramPacket(buffer, dim);
                server.receive(dpReceive);
                ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                parametri = ricevuto.split("!");
                //Se nickname sconosciuto lo inserisco
                if (!utenti.containsKey(parametri[1])) {
                    ArrayList<String> valori = new ArrayList<String>();
                    //valori.get(0) = indirizzo
                    //valori.get(1) = alpha
                    //valori.get(2) = beta
                    valori.add(parametri[0]);
                    valori.add(parametri[2]);
                    valori.add(parametri[3]);
                    utenti.put(parametri[1], valori);
                    //Inserisco RTT = 0 e D = 0
                    round_devia.put(parametri[1], "0!0");
                }
                while(true){
                    //Attendo messaggio dal client
                    dpReceive = new DatagramPacket(buffer, dim);
                    server.receive(dpReceive);
                    ricevuto = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    parametri = ricevuto.split("!");
                    //Incremento contatore messaggi ricevuto dal client
                    counter++;
                    //Se M = "."
                    if (parametri[1].equals(".")) {
                        //Elimino dalle strutture il nickname e i relativi dati
                        utenti.remove(parametri[0]);
                        round_devia.remove(parametri[0]);
                        counter = 0;
                        break;
                    }else{
                        //Se è la prima misura ricevuta
                        if(counter == 1){
                            //D = M/2
                            d = Double.parseDouble(parametri[1])/2;
                            round_devia.put(parametri[0], parametri[1] + "!" + d);
                            rto = 3*Double.parseDouble(parametri[1]);
                            //Invio risposta al client RTT!D!RTO
                            invio = round_devia.get(parametri[0]) + "!" + rto;
                            dpSend = new DatagramPacket(invio.getBytes(), invio.length(), dpReceive.getAddress(), dpReceive.getPort());
                            server.send(dpSend);
                        }else{
                            //COMMENTO PER NON PERDERE PEZZI
                            //Dnew = beta*D + (1-beta)|RTT-M|
                            //RTTnew = alpha*RTT + (1-alpha)M
                            //RTO = RTTnew + 4Dnew
                            //splitted1[0] = RTT
                            //splitted1[1] = D
                            //valori.get(0) = indirizzo
                            //valori.get(1) = alpha
                            //valori.get(2) = beta
                            //parametri[1] = m
                            ArrayList<String> valori = new ArrayList<String>();
                            valori = utenti.get(parametri[0]);
                            alpha = Double.parseDouble(valori.get(1));
                            beta = Double.parseDouble(valori.get(2));
                            splitted1 = round_devia.get(parametri[0]).split("!");
                            m = Double.parseDouble(parametri[1]);
                            d = Double.parseDouble(splitted1[1]);
                            rtt = Double.parseDouble((splitted1[0]));
                            dnew = beta * d + (1 - beta) * Math.abs(rtt-m);
                            rttnew = alpha * rtt + (1 - alpha) * m;
                            rto = rttnew + 4 * dnew;
                            //Invio risposta al client RTT!D!RTO
                            invio = rttnew + "!" + dnew + "!" + rto;
                            dpSend = new DatagramPacket(invio.getBytes(), invio.length(), dpReceive.getAddress(), dpReceive.getPort());
                            server.send(dpSend);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
