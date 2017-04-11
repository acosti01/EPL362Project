package objects;

import java.util.ArrayList;

public class Condition {

	String description;
	ArrayList<Prescription> prescriptions;
	
	public Condition(String description, ArrayList<Prescription> prescriptions){
		this.description = description;
		this.prescriptions = prescriptions;
	}
}
