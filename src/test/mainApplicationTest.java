package test;

import static org.junit.Assert.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import application.log_in;
import rmiinterface.RMIInterface;

public class mainApplicationTest {
	static log_in login;
	static RMIInterface look_up;
	static ArrayList<String> s;

	@BeforeClass
	public static void setUpBeforeClas12s() throws Exception {
		// creates a dummy user with username/password="test"
		// all fields in the database are filled with the word test and
		// id=666666
		// test1 is clinical_staff
		// test2 is receptionist
		// test3 is medical_records_staff
		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		login = new log_in();
		login.setPassword("test");
		login.setUsername("test");
		s = new ArrayList<String>();
		look_up.addPatient(666666, "test", "test", "test", "test", "test", "test", "M");
		look_up.addUser(666666, "test", "test", "test", "test", "test", "test", "M");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		look_up.deletePatient(666666);
		look_up.deletePersonnel(666666);
	}
	
	@Test(timeout = 10000)
	public void testValidation() throws RemoteException, SQLException {
		s = look_up.validate(login.getUsername(), login.getPassword());
		assertFalse(s.equals(null));
		assertEquals("Wrong object", s.get(0), "666666");// id of user
	}

	@Test(timeout = 10000)
	public void testAddAppointment() throws RemoteException, SQLException {
		int result = look_up.addAppointment(666666, "2017-01-01", "01:01", "test", "test test", "test", "test");
		result++;
		int result1 = look_up.addAppointment(666666, "2017-01-02", "01:02", "test", "test test", "test", "test");
		look_up.deleteAppointment(result-1);
		look_up.deleteAppointment(result1);
		assertEquals("Error in adding appointment", result1, result);

	}

	@Test
	public void testFindAppointment() throws RemoteException, SQLException {
		int result = look_up.addAppointment(666666, "2017-01-01", "01:01", "test", "test test", "test", "test");
		String resultString = look_up.findAppointment(666666);
		String expected = result + " 2017-01-01 666666 666666 test 01:01 test test";
		look_up.deleteAppointment(result);

		assertEquals(expected, resultString);

	}

	@Test
	public void testFindPatient() throws RemoteException, SQLException {
		look_up.addPatient(666667, "test", "test", "test", "test", "test", "test", "M");
		String result = look_up.findPatient(666667);
		String expected = "666667/test/test/test/test/test/test/M";
		look_up.deletePatient(666667);
		assertEquals(result,expected);

	}

}
