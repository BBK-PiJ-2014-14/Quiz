package testings;

import static org.junit.Assert.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Test;

import quizServer.Quizer;
import quizServer.Server;

public class ServerTest {

	@Test
	public void testServerRegister() throws RemoteException {
		Server.main(new String[0]);
		Registry reg = LocateRegistry.getRegistry(1099);
		Quizer quizer = null;
		try {
			quizer = (Quizer) reg.lookup("QuizerImpl");
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		assertNotNull(quizer);
		
	}
}
