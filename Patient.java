package objects;

import java.util.ArrayList;

public class Patient {

	int ID;
	String name;
	String surname;
	String Address;
	boolean isHomeless;
	boolean isAlive;
	ArrayList<Appointment> appointments;
	ArrayList<Condition> conditions;
	ArrayList<Allergy> allergies;
	RiskIndicator risk;

	public Patient(int ID, String name, String surname, boolean isHomeless,
			boolean isAlive, ArrayList<Appointment> app,
			ArrayList<Condition> cond, ArrayList<Allergy> allergy,
			RiskIndicator risk) {

		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.isHomeless = isHomeless;
		this.isAlive = isAlive;
		this.appointments = app;
		this.conditions = cond;
		this.allergies = allergy;
		this.risk = risk;
	}
}
