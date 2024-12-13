package project;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

// This StudentManager() object provides methods to perform operations on students, 
// such as adding, removing, updating, and displaying student data.

		StudentManager manager = new StudentManager();
		Scanner scanner = new Scanner(System.in);

// By using while loop user Enter command (add, update, remove, display or exit).
		while (true) {
			System.out.println("\nEnter command: add, update, remove, display, or exit");
			String command = scanner.nextLine();
			
// implement a block of code based on user's input
			switch (command) {
			case "add":
				manager.addStudent();
				break;
			case "update":
				manager.updateStudentDetails();
				break;
			case "remove":
				manager.removeStudent();
				break;
			case "display":
				manager.showAllStudents();
				break;
			case "exit":
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}
	}
}
