import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

// Codice server per servizio connection-less (UDP)

public class serverUDP{
	public static void main(String[] args){
		DatagramSocket sSrv;
		int dim_buffer = 100;
		String stringa;
		try{
			sSrv = new DatagramSocket();
			System.out.println("Indirizzo: " + sSrv.getLocalAddress() + "; porta: " + sSrv.getLocalPort());

			byte[] buffer = new byte[dim_buffer];
			DatagramPacket dpin = new DatagramPacket(buffer, dim_buffer);
			sSrv.receive(dpin);
			stringa = new String(buffer, 0, dpin.getLength());
			System.out.println("Ricevuto: " + stringa);
			InetAddress ia = dpin.getAddress();
			int porta = dpin.getPort();
			System.out.println("Indirizzo " + ia.getHostAddress() + "; porta: " + porta);
			sSrv.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
