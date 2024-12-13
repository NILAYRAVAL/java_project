package project;

public enum StudentStatus {
	ACTIVE, // Student is currently active in the course
	INACTIVE, // Student is not actively engaged in the course
	GRADUATED; // Student has graduated

	// You can add additional methods if needed, e.g., for displaying a
	// user-friendly status
	@Override
	public String toString() {
		switch (this) {
		case ACTIVE:
			return "Active";
		case INACTIVE:
			return "Inactive";
		case GRADUATED:
			return "Graduated";
		default:
			return super.toString();
		}
	}
}
