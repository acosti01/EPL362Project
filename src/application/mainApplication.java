package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

import Entities.User;
import rmiinterface.RMIInterface;
import GUI.ClinicalStaff_GUI;
import GUI.HomePage_GUI;
import GUI.Receptionist_GUI;

public class mainApplication {
	private static RMIInterface look_up;
	static ArrayList<String> s;

	public static void main(String[] args)
			throws InterruptedException, MalformedURLException, RemoteException, NotBoundException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		boolean logged_in = false;
		log_in login = new log_in();// object used for login
		HomePage_GUI home = new HomePage_GUI(login);
		while (!logged_in) {
			home.waitForInput();
			s = look_up.validate(login.getUsername(), login.getPassword());
			if (s != null)
				logged_in = true;
			else
				home.alertForWrongLogin();
		}
		int a = 1;
		home.setVisible(false);
		User currentUser = new User(s);
		switch (currentUser.getType()) {
		case "CLINICAL_STAFF":
			new  Receptionist_GUI(currentUser);
			break;
		case "RECEPTIONIST":
			new Receptionist_GUI(currentUser);
			break;
		case "MEDICAL_RECORD_STAFF":
			//new MedicalRecord_GUI(currentUser);
			break;
		case "HEALTH_SERVICE_MANAGEMENT":
			//new Management_GUI(currentUser);
			break;
		}
	}
}
