package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIInterface extends Remote {
	
	public ArrayList<String> validate(String username, String password) throws RemoteException, SQLException;
	
		
}