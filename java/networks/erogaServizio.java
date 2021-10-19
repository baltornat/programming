import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class erogaServizio extends Thread{
  private Socket sock2Cl;

  public erogaServizio(Socket socket){
    this.sock2Cl = socket;
  }

  public void run(){
    int dim_buffer = 100;
    byte buffer[] = new byte[dim_buffer];
    int letti;
    String stampa = new String();

    while(true){
      try{
        do{
					InputStream fromCl = sock2Cl.getInputStream();
					letti = fromCl.read(buffer);
					if(letti > 0){
						stampa = new String(buffer, 0, letti);
						System.out.println("Ricevuta stringa: " + stampa + " di " + letti + " byte da " + sock2Cl.getInetAddress() + "; " + sock2Cl.getPort());
						if(stampa.equals(".")==false){ // se non ho ricevuto la stringa terminatrice reinvio la stringa che ho ricevoto alla sorgente
							OutputStream client = sock2Cl.getOutputStream();
							client.write(stampa.getBytes(), 0, stampa.length()); // Conversione
						}
					}
				}while(stampa.equals(".")==false);
          sock2Cl.close();
          return;
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
