package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIInterface extends Remote {

	public ArrayList<String> validate(String username, String password)
			throws RemoteException, SQLException;

	public Object[][] fillDiary() throws RemoteException, SQLException;

	Object[][] fillPatients() throws RemoteException, SQLException;

	void addPatient(int id, String name, String surname, String email,
			String address, String bday, String tel, String gender)
			throws RemoteException, SQLException;

	void deletePatient(Object id) throws SQLException, RemoteException;

}