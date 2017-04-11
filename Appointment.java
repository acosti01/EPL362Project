package objects;

import java.util.Date;

public class Appointment {

	int patientID;
	Clinic clinic;
	Date date;
	boolean missed;
	Doctor supervisingDoctor;
	
	public Appointment(int ID, Clinic clinic, Date date, boolean missed, Doctor doctor){
		this.patientID = ID;
		this.clinic = clinic;
		this.date = date;
		this.missed = missed;
		this.supervisingDoctor = doctor;
	}
}
