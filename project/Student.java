package project;

import java.time.LocalDate;

public class Student extends Person implements Updatable {
	private String studentId;
	private StudentStatus status;
	private LocalDate enrollmentDate;

	// Constructor using this() constructor call
	public Student(String name, int age, String studentId, StudentStatus status, LocalDate enrollmentDate) {
		super(name, age); // Calling the Person class constructor
		this.studentId = studentId;
		this.status = status;
		this.enrollmentDate = enrollmentDate;
	}

	// Overloaded constructor to demonstrate method overloading
	public Student(String name, int age, String studentId) {
		this(name, age, studentId, StudentStatus.ACTIVE, LocalDate.now());
	}

	// Getter and Setter for status
	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

	// Getter for studentId
	public String getStudentId() {
		return studentId;
	}

	// Method to print student information with status
	public void printInfo() {
		String formattedDate = enrollmentDate.toString();
		System.out.println("Student Info: " + getName() + ", Age: " + getAge() + ", ID: " + studentId + ", Status: "
				+ status.toString() + ", Enrollment Date: " + formattedDate);
	}

	// Implementing updateInfo method
	@Override
	public void updateInfo(String newName, int newAge) {
		setName(newName); // Using setter from the Person class
		setAge(newAge); // Using setter from the Person class
		System.out.println("Student info updated: ");
		printInfo();
	}
}
