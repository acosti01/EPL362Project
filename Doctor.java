package objects;

import java.util.ArrayList;

public class Doctor extends Staff{

	ArrayList<Patient> patients;
	
	public Doctor(String name, String surname, int ID, boolean canEdit,
			boolean canAccess, boolean isAtWork, ArrayList<Patient> patients) {
		
		super(name, surname, ID, canEdit, canAccess, isAtWork);
		this.patients = patients;
		
	}
}
