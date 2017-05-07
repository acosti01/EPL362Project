package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

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

	public int addAppointment(int iD, String date, String time, String clinic, String clinician, String type,
			String status) throws SQLException, RemoteException;

	public Object[] getClinicians() throws SQLException, RemoteException;

	public String getPatientsFullName(int patientsID) throws SQLException, RemoteException;

	public int getClinicianID(String string, String string2) throws SQLException, RemoteException;

	public void editAppointment(int iD, String date, int patientsID, int clinicianID, String clinic, String time,
			String type) throws SQLException, RemoteException;

	public void deleteAppointment(Object id) throws RemoteException, SQLException;

	public Object[][] fillUser() throws RemoteException, SQLException;

	public void addUser(int iD, String name, String surname, String email, String username, String tel, String password,
			String type) throws RemoteException, SQLException;

	public void editUser(int iD, String name, String surname, String telephone, String email, String username,
			String password, String type) throws SQLException, RemoteException;

	public String getUserPassword(int iD) throws SQLException, RemoteException;

	
}