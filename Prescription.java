package objects;

import java.util.ArrayList;

public class Prescription {

	String drugName;
	float dosage;
	ArrayList<String> sideEffects;

	public Prescription(String drugName, float dosage,
			ArrayList<String> effects) {
		
		this.drugName = drugName;
		this.dosage = dosage;
		this.sideEffects = effects;
	}
}
