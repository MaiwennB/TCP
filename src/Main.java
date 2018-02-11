import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		/* CLIENT */
		serverSocketTCP serveurTcp = new serverSocketTCP(6789);
		clientSoketTCP clientTcp = new clientSoketTCP();
		
		
	}
	
}
