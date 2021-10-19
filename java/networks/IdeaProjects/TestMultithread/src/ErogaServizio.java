import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ErogaServizio extends Thread{
    public Socket socket;

    public ErogaServizio(Socket toClient){
        this.socket = toClient;
    }

    public void run(){
        int dim = 100, letti;
        byte[] buf = new byte[dim];
        String output;
        String[] parole;
        InputStream is;
        OutputStream os;
        try{
            //Leggo la stringa che mi invia il client
            is = socket.getInputStream();
            os = socket.getOutputStream();
            while(true){
                letti = is.read(buf);
                output = new String(buf, 0, letti);
                System.out.println("Ricevuto: " + output);
                if (output.equals("."))
                    break;
                //Estraggo le parole dalla stringa ricevuta
                parole = output.split(" ");
                for(int j=0; j< parole.length; j++){
                    os.write(parole[j].getBytes(), 0, parole[j].length());
                    letti = is.read(buf);
                    output = new String(buf, 0, letti);
                    System.out.println("Ricevuto: " + output);
                }
            }
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
