package rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rmiinterface.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 1L;
	private static Connection conn;
	private static Statement statement;
	private static final String HOST = "localhost";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE = "arkalam";

	protected ServerOperation() throws RemoteException {

		super();

	}

	public Statement getStatement() {
		return statement;
	}

	public static void main(String[] args) throws RemoteException {
		try {

			Naming.rebind("//localhost/MyServer", new ServerOperation());
			System.err.println("Server ready");

		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DATABASE, USER, PASSWORD);
			statement = conn.createStatement();
			if (conn == null) {
				System.out.println("Problem with connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> validate(String username, String password) throws RemoteException, SQLException {
		ArrayList<String> a = new ArrayList<String>();
		System.out.println("Trying to login with username = " + username);
		String query = "SELECT * FROM user WHERE " + "username='" + username + "' " + "AND password='" + password + "'";
		Statement stat = conn.createStatement();

		ResultSet rs = stat.executeQuery(query);
		if (!rs.next()) {
			System.out.println("No such user!");
			return null;
		} else {
			System.out.println("Login was successful!");
			int c = 1;
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();

			int numOfCols = rsmd.getColumnCount();
			while (c <= numOfCols) {
				a.add(rs.getString(c++));
			}
		}
		return a;
	}

	@Override
	public Object[][] fillDiary() throws RemoteException, SQLException {
		Object[][] diaryEntry = null;
		String query = "select appointment.id, patient.id,patient.firstname,patient."
				+ "lastname,patient.phonenumber, appointment.date,user.firstname,"
				+ "user.lastname,appointment.clinic,appointment.time, appointment.type "
				+ "from user,patient,appointment "
				+ "where patient.id=appointment.patient and user.id=appointment.clinician ORDER BY appointment.date";

		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int c = 0;
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		diaryEntry = new Object[size][11];
		while (rs.next()) {
			for (int i = 0; i < 11; i++)
				diaryEntry[c][i] = rs.getString(i + 1);
			c++;
		}
		return diaryEntry;
	}

	@Override
	public Object[][] fillPatients() throws RemoteException, SQLException {
		String query = "select * from patient order by patient.lastname";
		Object[][] patientsEntry;
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int c = 0;
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		patientsEntry = new Object[size][8];
		while (rs.next()) {
			for (int i = 0; i < 8; i++)
				patientsEntry[c][i] = rs.getString(i + 1);
			c++;
		}
		return patientsEntry;
	}

	@Override
	public void addPatient(int id, String name, String surname, String email, String address, String bday, String tel,
			String gender) throws RemoteException, SQLException {

		String query = "INSERT INTO PATIENT values ( " + "'" + id + "','" + name + "','" + surname + "','" + email
				+ "','" + address + "','" + tel + "','" + bday + "','" + gender + "')";

		Statement stat = conn.createStatement();
		stat.executeUpdate(query);
		System.out.println("Added new patient with ID = " + id);
	}

	@Override
	public void editPatient(int id, String name, String surname, String email, String address, String bday, String tel,
			String gender) throws RemoteException, SQLException {

		String query = "UPDATE PATIENT SET firstname = " + "'" + name + "', lastname = '" + surname
				+ "', relative_email = '" + email + "', address = '" + address + "', phonenumber = '" + tel
				+ "', birthday = '" + bday + "', gender = '" + gender + "'where id = '" + id + "'";

		Statement stat = conn.createStatement();
		stat.executeUpdate(query);
		System.out.println("Edited patient with ID = " + id);
	}

	@Override
	public void deletePatient(Object id) throws RemoteException, SQLException {

		String query = "DELETE FROM PATIENT WHERE id = '" + id + "'";
		Statement stat = conn.createStatement();
		stat.executeUpdate(query);
		System.out.println("Deleted patient with ID = " + id);
	}

	@Override
	public Object[] getClinics() throws SQLException, RemoteException {
		Object[] result = null;
		String query = "SELECT name  FROM clinic ";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int i = 0;
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		result = new Object[size];
		while (rs.next()) {
			result[i++] = rs.getString(1);
		}
		return result;

	}

	@Override
	public Object[] getClinicians() throws SQLException, RemoteException {
		Object[] result = null;
		String query = "SELECT firstname,lastname  FROM user where type='CLINICAL_STAFF'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int i = 0;
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		result = new Object[size];
		while (rs.next()) {
			result[i++] = rs.getString(1) + " " + rs.getString(2);
		}
		return result;

	}

	@Override
	public void addAppointment(int iD, int patientsID, String date, String time, String clinic, String clinician,
			String type, String status) throws SQLException, RemoteException {
		String fullname = clinician;
		String[] splited = fullname.split("\\s+");
		String name = splited[0];
		String surname = splited[1];
		String prequery = "select id from user where firstname='" + name + "' and lastname='" + surname + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(prequery);
		rs.next();
		String cliniciansID = rs.getString(1);

		String query = "INSERT INTO appointment values ( " + "'" + iD + "','" + date + "','" + patientsID + "','"
				+ cliniciansID + "','" + clinic + "','" + time + "','" + type + "','" + status + "')";
		stat.executeUpdate(query);
		System.out.println("Added new appointment with ID = " + iD);

	}

	@Override
	public String getPatientsFullName(int patientsID) throws SQLException, RemoteException {
		Object[] result = null;
		String query = "SELECT firstname,lastname,phonenumber  FROM patient where id='"+patientsID+"'";		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		result = new Object[size];
		while (rs.next()) {			
				result[0] = rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);			
		}
		String res=result[0].toString();
		return res;
		
	}

	@Override
	public int getClinicianID(String name ,String surname) throws SQLException {
		Object[] result = null;
		String query = "SELECT id  FROM user where firstname='"+name+"' and lastname='"+surname+"'";		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		int size = 0;
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		result = new Object[size];
		while (rs.next()) {			
				result[0] = rs.getString(1);			
		}
		String res=result[0].toString();
		int a = Integer.parseInt(res);
		return a;	
		}

	@Override
	public void editAppointment(int iD, String date, int patientsID, int clinicianID, String clinic, String time,
			String type) throws SQLException,RemoteException {
		String query = "UPDATE appointment SET date = '" + date + "', patient = '" + patientsID
				+ "', clinician = '" + clinicianID + "', clinic = '" + clinic + "', time = '" + time
				+ "', type = '" + type + "' where id= '"+iD+"'";

		Statement stat = conn.createStatement();
		stat.executeUpdate(query);
				
	}

	
}