import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Codice client per servizio connection-less (UDP)

public class clientUDP{
	public static void main(String[] args){
		DatagramSocket sClient;
		String nome_host;
		int porta_server;

		try{
			nome_host = args[0];
			porta_server = Integer.parseInt(args[1]);

			sClient = new DatagramSocket(); // Fa bind implicito con porta random e IP locale
			System.out.println("Indirizzo: " + sClient.getLocalAddress() + "; porta: " + sClient.getLocalPort());
			InetSocketAddress isa = new InetSocketAddress(nome_host, porta_server);
			InputStreamReader tastiera = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(tastiera);
			String frase = br.readLine();
			byte[] buffer = frase.getBytes();
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			dp.setSocketAddress(isa);
			sClient.send(dp);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
