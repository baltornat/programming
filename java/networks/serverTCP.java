import java.net.ServerSocket;
import java.net.Socket;

import java.io.InputStream;

// Codice server per servizio connection-oriented (TCP)

public class serverTCP{
	public static void main(String[] args){
		ServerSocket sSrv;
		Socket toClient;
		int dim_buffer = 100;
		int letti;
		String stampa;

		try{
			sSrv = new ServerSocket(0);

			// getInetAddress() visualizza l'indirizzo (di trasporto) locale
			// che e' stato associato alla socket
			System.out.println("Indirizzo: " + sSrv.getInetAddress()
					+ "; porta: " + sSrv.getLocalPort());

			toClient = sSrv.accept();

			// getPort() visualizza l'indirizzo (di trasporto) del client
			System.out.println("Ind Client: " + toClient.getInetAddress()
					+ "; porta: " + toClient.getPort());

			byte buffer[] = new byte[dim_buffer];
			InputStream fromCl = toClient.getInputStream();
			letti = fromCl.read(buffer);
			if(letti > 0){
				stampa = new String(buffer, 0, letti);
				System.out.println("Ricevuta stringa: " + stampa + " di " + letti + " byte da " + toClient.getInetAddress() + "; " + toClient.getPort());
			}

			toClient.close();	// Chiudo la socket con il client attivo
			sSrv.close();		// Spengo sostanzialmente il server

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
