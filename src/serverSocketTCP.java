import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class serverSocketTCP {
	//******************ATTRIBUTS******************//
	private ServerSocket serveur;
	private Inet4Address ipServeur;
	private int portServeur;
	private Inet4Address ipClient;
	private int portClient;
	private Socket clientSoket;
	private PrintWriter reponse;
	private DatagramPacket dataRec;
	private InputStream FluxEntree;
	private InputStreamReader bufferFluxEntree;
	private OutputStream FluxSortie;
	private BufferedReader requette;
	
	//***************CONSTRUCTOR*****************//
	public serverSocketTCP(int pPort) throws IOException {
		/* Constructeur du Soket TCP serveur
		 * valeur a null
		 * */
		super();
		//valeurs a 0
		this.portClient = 0;
		this.portServeur = pPort;
		this.ipClient = (Inet4Address) InetAddress.getByName("0.0.0.0");
		this.ipServeur = (Inet4Address) InetAddress.getByName("0.0.0.0");
		// appel des méthodes de la classe
		this.lancerServeur(pPort);
		this.attendreClient();
		deconnecterClient();
	}
	//**************METHODES******************//
	private void lancerServeur(int pPort) throws IOException {
		/* Methode qui permet de lancer le serveur
		 * 
		 * */
		this.ipServeur = (Inet4Address) Inet4Address.getLocalHost();
		this.portServeur = pPort;
		this.serveur = new ServerSocket(this.portServeur, 1, this.ipServeur);
	}
	private void attendreClient() throws IOException {
		// on accept le client et on recupères les info de celui-ci
		this.clientSoket = this.serveur.accept();
		this.ipClient = (Inet4Address) this.clientSoket.getInetAddress();
		this.portClient = this.clientSoket.getPort();
		this.FluxEntree = this.clientSoket.getInputStream();
		
		this.requette = new BufferedReader(new InputStreamReader(this.FluxEntree));
		this.FluxSortie = this.clientSoket.getOutputStream();
		this.reponse = new PrintWriter(this.FluxSortie);

	}
	private void deconnecterClient() throws IOException {
		this.clientSoket.close();
		this.FluxEntree.close();
		this.FluxSortie.close();
	}
	private String recevoirRequette() throws IOException {
		return this.requette.readLine();
	}
	private void envoyerReponse(String message) {
		this.reponse.write(message);
		this.reponse.notify();
		
		
	}
	// **** gs *****//
	
	public ServerSocket getServeur() {
		return serveur;
	}

	public void setServeur(ServerSocket serveur) {
		this.serveur = serveur;
	}

	public Inet4Address getIpServeur() {
		return ipServeur;
	}

	public void setIpServeur(Inet4Address ipServeur) {
		this.ipServeur = ipServeur;
	}

	public int getPortServeur() {
		return portServeur;
	}

	public void setPortServeur(int portServeur) {
		this.portServeur = portServeur;
	}

	public Inet4Address getIpClient() {
		return ipClient;
	}

	public void setIpClient(Inet4Address ipClient) {
		this.ipClient = ipClient;
	}

	public int getPortClient() {
		return portClient;
	}

	public void setPortClient(int portClient) {
		this.portClient = portClient;
	}

	public Socket getClientSoket() {
		return clientSoket;
	}

	public void setClientSoket(Socket clientSoket) {
		this.clientSoket = clientSoket;
	}

	public PrintWriter getReponse() {
		return reponse;
	}

	public void setReponse(PrintWriter reponse) {
		this.reponse = reponse;
	}

	public DatagramPacket getDataRec() {
		return dataRec;
	}

	public void setDataRec(DatagramPacket dataRec) {
		this.dataRec = dataRec;
	}

	public InputStream getFluxEntree() {
		return FluxEntree;
	}

	public void setFluxEntree(InputStream fluxEntree) {
		FluxEntree = fluxEntree;
	}

	public InputStreamReader getBufferFluxEntree() {
		return bufferFluxEntree;
	}

	public void setBufferFluxEntree(InputStreamReader bufferFluxEntree) {
		this.bufferFluxEntree = bufferFluxEntree;
	}

	public OutputStream getFluxSortie() {
		return FluxSortie;
	}

	public void setFluxSortie(OutputStream fluxSortie) {
		FluxSortie = fluxSortie;
	}

	public BufferedReader getRequette() {
		return requette;
	}

	public void setRequette(BufferedReader requette) {
		this.requette = requette;
	}

	private void arreterServeur() throws IOException {
		this.serveur.close();
		
	}
	
	
	
}
