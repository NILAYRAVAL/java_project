package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class StudentManager {

	private ArrayList<Student> students = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	// Method to add a student
	public void addStudent() {
		System.out.print("Enter Student name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Student age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter student ID: ");
		String studentId = scanner.nextLine();

		// Default status is ACTIVE
		StudentStatus status = StudentStatus.ACTIVE;
		LocalDate enrollmentDate = LocalDate.now(); // Get the current date

		// Create new student
		Student student = new Student(name, age, studentId, status, enrollmentDate);
		students.add(student);
		System.out.println("Student added.");
	}

	// Method to remove a student
	public void removeStudent() {
		System.out.print("Enter student ID to remove: ");
		String studentId = scanner.nextLine();

		// Find student by ID
		boolean found = false;
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				students.remove(student);
				System.out.println("Student with ID " + studentId + " has been removed.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Student with ID " + studentId + " not found.");
		}
	}

	// Method to update student details (name, age, status)
	public void updateStudentDetails() {
		System.out.print("Enter student ID to update: ");
		String studentId = scanner.nextLine();

		// Find the student
		Student studentToUpdate = null;
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				studentToUpdate = student;
				break;
			}
		}

		if (studentToUpdate == null) {
			System.out.println("Student not found.");
			return;
		}

		// Update name
		System.out.println("Current name: " + studentToUpdate.getName());
		System.out.print("Enter new name (or press Enter to keep the current name): ");
		String newName = scanner.nextLine();
		if (!newName.isBlank()) {
			studentToUpdate.setName(newName);
		}

		// Update age
		System.out.println("Current age: " + studentToUpdate.getAge());
		System.out.print("Enter new age (or press Enter to keep the current age): ");
		String newAgeInput = scanner.nextLine();
		if (!newAgeInput.isBlank()) {
			try {
				int newAge = Integer.parseInt(newAgeInput);
				studentToUpdate.setAge(newAge);
			} catch (NumberFormatException e) {
				System.out.println("Invalid age. Keeping the current age.");
			}
		}

		// Update status
		System.out.println("Current status: " + studentToUpdate.getStatus());
		System.out.print("Enter new status (ACTIVE, INACTIVE, GRADUATED, or press Enter to keep current): ");
		String newStatusInput = scanner.nextLine().toUpperCase();
		if (!newStatusInput.isBlank()) {
			try {
				StudentStatus newStatus = StudentStatus.valueOf(newStatusInput);
				studentToUpdate.setStatus(newStatus);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid status. Keeping the current status.");
			}
		}

		System.out.println("Student details updated successfully.");
		studentToUpdate.printInfo();
	}

	// Method to display all students
	public void showAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students to display.");
		} else {
			System.out.println("Students:");
			for (Student student : students) {
				student.printInfo();
			}
		}
	}
}
