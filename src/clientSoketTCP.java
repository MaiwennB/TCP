import java.io.*;
import java.net.*;



public class clientSoketTCP {
	//******************ATTRIBUTS******************//
	private Inet4Address ipServeur;
	private int portServeur;
	private Inet4Address ipClient;
	private int portClient;
	private DatagramSocket clientSocket;
	private DatagramPacket dataSend;
	private DatagramPacket dataRec;
	private DataOutputStream bufferSend;
	private BufferedReader bufferRec;
	private String sentence;
	private String modifiedSentence;
	//***************CONSTRUCTOR*****************//
	public clientSoketTCP() throws IOException {
		super();
		this.ipClient = (Inet4Address) InetAddress.getByName("0.0.0.0");
		this.ipServeur = (Inet4Address) Inet4Address.getLocalHost();
		connecter();
		envoyerRequete();
		recevoirReponse();
		deconecter();
		
	}
	//*************** GET&SET *****************//
	
	//**************METHODES******************//
	public void connecter() throws UnknownHostException, IOException {
		 	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		 	Socket clientSocket = new Socket("localhost", 6789);
		}
	public void deconecter() {
		 this.clientSocket.close();
	}
	public void envoyerRequete() throws IOException {
		Socket clientSocket = new Socket("localhost", 6789);
	    this.bufferSend = new DataOutputStream(clientSocket.getOutputStream());
	    this.bufferRec = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    sentence = this.bufferRec .readLine();
	    bufferSend.writeBytes(sentence + '\n');
			
	}
	private void recevoirReponse() throws IOException {
		modifiedSentence = this.bufferRec.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
	}
	
	
}
