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

public class ServerOperation extends UnicastRemoteObject
		implements RMIInterface {

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
			conn = DriverManager.getConnection(
					"jdbc:mysql://" + HOST + "/" + DATABASE, USER, PASSWORD);
			statement = conn.createStatement();
			if (conn == null) {
				System.out.println("Problem with connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> validate(String username, String password)
			throws RemoteException, SQLException {
		ArrayList<String> a = new ArrayList<String>();
		System.out.println("Trying to login with username =" + username);
		String query = "SELECT * FROM user WHERE " + "username='" + username
				+ "' " + "AND password='" + password + "'";
		Statement stat = conn.createStatement();

		ResultSet rs = stat.executeQuery(query);
		if (!rs.next()) {
			System.out.println("No such user");
			return null;
		} else {
			System.out.println("Login was successful");
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
		String query = "select patient.id,patient.firstname,patient."
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
		diaryEntry = new Object[size][10];
		while (rs.next()) {
			for (int i = 0; i < 10; i++)
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
	public void addPatient(int id, String name, String surname, String email,
			String address, String bday, String tel, String gender)
			throws RemoteException, SQLException {
		String query = "INSERT INTO PATIENT values ( "
					+ "'" + id + "','" 
					+ name + "','" 
					+ surname + "','" 
					+ email + "','"
					+ address + "','" 
					+ tel + "','"
					+ bday + "','" 
					+ gender + "')";

		Statement stat = conn.createStatement();
		stat.executeUpdate(query);
		
	}
}