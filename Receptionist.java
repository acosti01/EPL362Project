package objects;

import java.util.ArrayList;

public class Receptionist extends Staff {

	ArrayList<Appointment> appointments;
	ArrayList<Prescription> prescriptions;

	public Receptionist(String name, String surname, int ID, boolean canEdit,
			boolean canAccess, boolean isAtWork,
			ArrayList<Appointment> appointments,
			ArrayList<Prescription> prescriptions) {

		super(name, surname, ID, canEdit, canAccess, isAtWork);

		this.appointments = appointments;
		this.prescriptions = prescriptions;
	}
}
