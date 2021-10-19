import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

// Codice server per servizio connection-oriented (TCP) iterativo

public class serverIterativo{
	public static void main(String[] args){
		ServerSocket sSrv;
		Socket toClient;
		int dim_buffer = 100;
		int letti;
		String stampa = new String();

		try{
			sSrv = new ServerSocket(0);

			// getInetAddress() visualizza l'indirizzo (di trasporto) locale
			// che e' stato associato alla socket
			System.out.println("Indirizzo: " + sSrv.getInetAddress()
					+ "; porta: " + sSrv.getLocalPort());

			while(true){
				toClient = sSrv.accept();
				// getPort() visualizza l'indirizzo (di trasporto) del client
				System.out.println("Ind Client: " + toClient.getInetAddress()
						+ "; porta: " + toClient.getPort());
				do{
					byte buffer[] = new byte[dim_buffer];
					InputStream fromCl = toClient.getInputStream();
					letti = fromCl.read(buffer);
					if(letti > 0){
						stampa = new String(buffer, 0, letti);
						System.out.println("Ricevuta stringa: " + stampa + " di " + letti + " byte da " + toClient.getInetAddress() + "; " + toClient.getPort());
						if(stampa.equals(".")==false){ // se non ho ricevuto la stringa terminatrice reinvio la stringa che ho ricevoto alla sorgente
							OutputStream client = toClient.getOutputStream();
							client.write(stampa.getBytes(), 0, stampa.length()); // Conversione
						}
					}
				}while(stampa.equals(".")==false);
				toClient.close();	// Chiudo la socket con il client attivo
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
