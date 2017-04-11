package objects;

public class Staff {

	String name;
	String surname;
	int ID;
	boolean canEdit;
	boolean canAccess;
	boolean isAtWork;

	public Staff(String name, String surname, int ID, boolean canEdit,
			boolean canAccess, boolean isAtWork) {

		this.name = name;
		this.surname = surname;
		this.ID = ID;
		this.canAccess = canAccess;
		this.canEdit = canEdit;
		this.isAtWork = isAtWork;
	}
}
