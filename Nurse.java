package objects;

import java.util.ArrayList;

public class Nurse extends Staff {

	ArrayList<Patient> listOfPatients;
	boolean isAtHomeVisit;

	public Nurse(String name, String surname, int ID, boolean canEdit,
			boolean canAccess, boolean isAtWork, ArrayList<Patient> patients,
			boolean isAtHome, Clinic clinic, AccountType type) {

		super(name, surname, ID, canEdit, canAccess, isAtWork, clinic, type);
		this.listOfPatients = patients;
		this.isAtHomeVisit = isAtHome;
	}

}
