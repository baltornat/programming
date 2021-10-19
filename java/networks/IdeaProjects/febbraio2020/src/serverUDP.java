import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.util.Arrays;
import java.util.HashMap;

public class serverUDP {
    public static void main(String[] args){
        int dim = 20;
        byte[] buffer = new byte[dim];
        String nick, ricezione;
        String[] nomi = new String[] {"A", "B", "C", "D", "E", "F"};
        String[] contenuto = new String[] {"", "", ""};
        HashMap<String, String> utenti = new HashMap<String, String>();
        DatagramPacket dpSend, dpReceive;
        try{
            DatagramSocket ds = new DatagramSocket();
            System.out.println("IP Server: " + ds.getLocalAddress() + "; Porta: " + ds.getLocalPort());
            while(true){
                dpReceive = new DatagramPacket(buffer, dim);
                while(true) {
                    ds.receive(dpReceive);
                    nick = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    if(Arrays.asList(nomi).contains(nick)){
                        System.out.println("Ricevuto nickname: " + nick);
                        if(utenti.containsKey(nick)){
                            dpSend = new DatagramPacket("NACK".getBytes(), "NACK".length(), dpReceive.getAddress(), dpReceive.getPort());
                            ds.send(dpSend);
                        }else{
                            utenti.put(nick, dpReceive.getAddress().getHostAddress());
                            dpSend = new DatagramPacket("ACK".getBytes(), "ACK".length(), dpReceive.getAddress(), dpReceive.getPort());
                            ds.send(dpSend);
                            break;
                        }
                    }else{
                        dpSend = new DatagramPacket("NACK".getBytes(), "NACK".length(), dpReceive.getAddress(), dpReceive.getPort());
                        ds.send(dpSend);
                    }
                }
                while(true){
                    ds.receive(dpReceive);
                    ricezione = new String(dpReceive.getData(), 0, dpReceive.getLength());
                    if(ricezione.equals(".")){
                        break;
                    }
                    switch(nick){
                        case "A":
                        case "B":
                            if(contenuto[0].equals("")){
                                dpSend = new DatagramPacket("NIL".getBytes(), "NIL".length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }else{
                                dpSend = new DatagramPacket(contenuto[0].getBytes(), contenuto[0].length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }
                            ds.receive(dpReceive);
                            ricezione = new String(dpReceive.getData(), 0, dpReceive.getLength());
                            System.out.println("Ricevuto: " + ricezione);
                            contenuto[0] = nick + ":" + ricezione;
                            dpSend = new DatagramPacket(contenuto[0].getBytes(), contenuto[0].length(), dpReceive.getAddress(), dpReceive.getPort());
                            ds.send(dpSend);
                            break;
                        case "C":
                        case "D":
                            if(contenuto[1].equals("")){
                                dpSend = new DatagramPacket("NIL".getBytes(), "NIL".length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }else{
                                dpSend = new DatagramPacket(contenuto[1].getBytes(), contenuto[1].length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }
                            ds.receive(dpReceive);
                            ricezione = new String(dpReceive.getData(), 0, dpReceive.getLength());
                            System.out.println("Ricevuto: " + ricezione);
                            contenuto[1] = nick + ":" + ricezione;
                            dpSend = new DatagramPacket(contenuto[1].getBytes(), contenuto[1].length(), dpReceive.getAddress(), dpReceive.getPort());
                            ds.send(dpSend);
                            break;
                        case "E":
                        case "F":
                            if(contenuto[2].equals("")){
                                dpSend = new DatagramPacket("NIL".getBytes(), "NIL".length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }else{
                                dpSend = new DatagramPacket(contenuto[2].getBytes(), contenuto[2].length(), dpReceive.getAddress(), dpReceive.getPort());
                                ds.send(dpSend);
                            }
                            ds.receive(dpReceive);
                            ricezione = new String(dpReceive.getData(), 0, dpReceive.getLength());
                            System.out.println("Ricevuto: " + ricezione);
                            contenuto[2] = nick + ":" + ricezione;
                            dpSend = new DatagramPacket(contenuto[2].getBytes(), contenuto[2].length(), dpReceive.getAddress(), dpReceive.getPort());
                            ds.send(dpSend);
                            break;
                        default:
                            System.out.println("Errore switch!");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
