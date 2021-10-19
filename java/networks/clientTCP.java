import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;

// Codice client per servizio connection-oriented (TCP)

public class clientTCP{
	public static void main(String[] args){
		Socket sClient;
		InetAddress ia;		// IP address SERVER
		InetSocketAddress isa;	// Socket address SERVER
		String frase;

		// Abbiamo creato una struttura del processo per gestire il punto
		// terminale del canale di comunicazione.
		sClient = new Socket();

		try{
			ia = InetAddress.getLocalHost();	// IP del server a cui mi voglio connettere (in questo caso siccome ho getLocalHost() sto usando il server locale sulla macchina client
			isa = new InetSocketAddress(ia, Integer.parseInt(args[0]));	// Porta del server

			sClient.connect(isa);	// Si connette al server che stara' facendo la accept()

			System.out.println("Porta locale: " + sClient.getLocalPort());

			// Stampo porta locale e indirizzo del server
			System.out.println("Indirizzo: " + sClient.getInetAddress() + "; porta: " + sClient.getPort());

			InputStreamReader tastiera = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(tastiera);
			frase = br.readLine();
			OutputStream toSrv = sClient.getOutputStream();
			toSrv.write(frase.getBytes(), 0, frase.length()); // Conversione

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				sClient.close();
			}catch(Exception e){
				System.err.println("Client error");
				e.printStackTrace();
			}
		}
	}
}
