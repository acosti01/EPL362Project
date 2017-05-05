package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public interface RMIInterface extends Remote {
	
	public ArrayList<String> validate(String username, String password) throws RemoteException, SQLException;

	public Object[][] fillDiary() throws RemoteException,SQLException;

	Object[][] fillPatients() throws RemoteException, SQLException;
	
		
}