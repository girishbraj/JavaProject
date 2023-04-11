package sdbms;

import java.util.Scanner;
import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("welcome to student database project");
		System.out.println("--------------");
		StudentManagementSystem sms = new StudentManagementSystemImpl();

		while (true) {
			System.out.println("1:addStudent\n2:displayStudent\n3:displayAllStudents");
			System.out.println("4:removeStudent\n5:removeAllStudents\n6:updateStudent");
			System.out.println("7:countStudents\n8:sortStudents\n9:getStudentWithHighestMarks");
			System.out.println("10:getStudentWithLowestMarks\nEnter Choice");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;

			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);
			default:
				try {
					String message = "Invalid choice, Enter Valid choice!";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
			System.out.println("-------------");

		}

	}
}
