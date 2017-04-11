package objects;

import java.util.ArrayList;

public class Allergy {

	String allergy;
	ArrayList<String> causedByDrugs;
	
	public Allergy(String allergy, ArrayList<String> causedBy){
		
		this.allergy = allergy;
		this.causedByDrugs = causedBy;
	}
	
}
