package quizServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * 
 * @author Noam
 * This is the class of the server.
 * This server upload the remote object QuizerImpl.
 */
public class Server {
	Registry reg;
	
	/**
     * Main method of the server, turn on the server.
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("Server is uploading...");
		server.serverRegister();
		System.out.println("Server uploaded");
	}
	
	/**
	 * this method register the server and upload it's remote object.
	 */
	private void serverRegister() {
		
		try {
			reg = LocateRegistry.createRegistry(1099);
			reg.bind("QuizerImpl", new QuizerImpl());
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}	
	}
}
