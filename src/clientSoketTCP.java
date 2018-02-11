import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class clientSoketTCP {
	//******************ATTRIBUTS******************//
	private Inet4Address ipServeur;
	private int portServeur;
	private Inet4Address ipClient;
	private int portClient;
	private DatagramSocket clientSoket;
	private DatagramPacket dataSend;
	private DatagramPacket dataRec;
	private byte[] bufferSend;
	private byte[] bufferRec;
	//***************CONSTRUCTOR*****************//
	public clientSoketTCP() {
		super();
		
	}
	//*************** GET&SET *****************//
	
	//**************METHODES******************//
	public void connecter() {
			
		}
	public void deconecter() {
		
	}
	public void envoyerRequete(String message, int port, String pIp) throws IOException {
	
		this.ipServeur.getByName(pIp);
		this.portServeur = port;
		this.dataSend = new DatagramPacket(this.bufferSend,port);
		this.clientSoket.connect(this.ipServeur , this.portServeur );
		this.clientSoket.send(this.dataSend);
			
	}
	private void recevoirReponse() throws IOException {
		this.clientSoket.receive(this.dataRec);
	}
	
	
}
