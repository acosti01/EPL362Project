package objects;

public class Staff {

	String name;
	String surname;
	int ID;
	boolean canEdit;
	boolean canAccess;
	boolean isAtWork;
	Clinic clinic;
	AccountType type;
	
	public Staff(String name, String surname, int ID, boolean canEdit,
			boolean canAccess, boolean isAtWork, Clinic clinic, AccountType type) {

		this.name = name;
		this.surname = surname;
		this.ID = ID;
		this.canAccess = canAccess;
		this.canEdit = canEdit;
		this.isAtWork = isAtWork;
		this.clinic = clinic;
		this.type = type;
	}
}
