package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIInterface extends Remote {

	public ArrayList<String> validate(String username, String password) throws RemoteException, SQLException;

	public Object[][] fillDiary() throws RemoteException, SQLException;

	Object[][] fillPatients() throws RemoteException, SQLException;

	void addPatient(int id, String name, String surname, String email, String address, String bday, String tel,
			String gender) throws RemoteException, SQLException;

	void deletePatient(Object id) throws SQLException, RemoteException;

	void editPatient(int id, String name, String surname, String email, String address, String bday, String tel,
			String gender) throws RemoteException, SQLException;

	public Object[] getClinics() throws SQLException, RemoteException;

	public void addAppointment(int iD, int patientsID, String date, String time, String clinic, String clinician,
			String type, String status)throws SQLException, RemoteException;

	public Object[] getClinicians() throws SQLException, RemoteException;

	// public String[] getClinicians();
	//
	// public String[] getAppointmentType();
	//
	// public String[] getStatus();
}