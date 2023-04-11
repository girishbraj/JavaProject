package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomSorting.SortStudentByAge;
import CustomSorting.SortStudentById;
import CustomSorting.SortStudentByMarks;
import CustomSorting.SortStudentByName;
import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner scan = new Scanner(System.in);

	Map<String, Student> db = new LinkedHashMap<String, Student>();

	@Override
	public void addStudent() {
		System.out.println("enter Student age");
		int age = scan.nextInt();
		System.out.println("enter Student name");
		String name = scan.next();
		System.out.println("enter student marks");
		int marks = scan.nextInt();

		Student std = new Student(age, name, marks);
		db.put(std.getId(), std);
		System.out.println("Student record inserted successfully");
		System.out.println(std.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student ID");
		String id = scan.next(); // String id=scan.next().toUpperCase();
		id = id.toUpperCase();
		if (db.containsKey(id)) {
			Student std = db.get(id); // getting value(student object)
			System.out.println("ID: " + std.getId());
			System.out.println("Age: " + std.getAge());
			System.out.println("Name: " + std.getName());
			System.out.println("Marks: " + std.getMarks());
		} else {
			try {
				String message = "Student with the ID " + id + " is not Found";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudents() {
		if (db.size() != 0) {
			System.out.println("Student records are as follows");
			System.out.println("----------------");
			Set<String> keys = db.keySet();// JSP101 JSp102
			for (String key : keys) {
				Student std = db.get(key);
				System.out.println(std);
			}
		} else {
			try {
				String message = "Student DataBase is Empty, Nothing to Display";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student ID");
		String id = scan.next().toUpperCase();

		if (db.containsKey(id)) {
			db.clear();
			System.out.println("Student record with Id " + id + " is deleted Successfully");
		} else {
			try {
				String message = "Student with the ID " + id + " is not Found";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudents() {
		if (db.size() != 0) {
			db.clear();
			System.out.println("All Student records deleted successfully");
		} else {
			try {
				String message = "Student DataBase is Empty, Nothing to Delete";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("enter Student id for upadte");
		String id = scan.next();
		id = id.toUpperCase();
		if (db.containsKey(id)) {
			Student std = (Student) db.get(id);// getting STudent oject
			System.out.println(std);
			System.out.println("enter 1:To Upadte Age \nenter 2:To Upadte Name\n3:To Update Marks\nEnter Choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Age to update");
				int age = scan.nextInt();
				std.setAge(age);
				System.out.println("Student Age is Updated successfully");
				break;

			case 2:
				System.out.println("Enter Name to update");
				String name = scan.next();
				std.setName(name);
				System.out.println("Student Name is Updated successfully");
				break;
			case 3:
				System.out.println("Enter Marks to update");
				String marks = scan.next();
				std.setName(marks);
				System.out.println("Student Name is Updated successfully");
				break;
			default:
				try {
					String message = "Invalid choice, Enter Valid choice!";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		} else {
			try {
				String message = "Student with the ID " + id + " is not Found";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudents() {
		System.out.println("Available Student record:" + db.size());
	}

	@Override
	public void sortStudents() {

		if (db.size() >= 2) {
			Set<String> keys = db.keySet();
			List<Student> list = new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key)); // Adding STudent object into List
			}

			System.out.println("1:SortStudentById\n2:SortStudentByAge\n"
					+ "3:SortStudentByName\n4:SortStudentByMarks\nENter choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				Collections.sort(list, new SortStudentById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortStudentByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list, new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list, new SortStudentByMarks());
				display(list);
				break;
			default:
				try {
					String message = "Invalid choice, Enter Valid choice!";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			try {
				String message = "No sufficient Student records to sort";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void display(List<Student> list) {
		for (Student std : list) {
			System.out.println(std);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if (db.size() >= 2) {
			Set<String> keys = db.keySet(); // JSP101 JSP102
			List<Student> list = new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key)); // Adding STudent object into List
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(db.size() - 1));
		} else {
			try {
				String message = "No sufficient Student records Show Highest marks Student record";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void getStudentWithLowestMarks() {
		if (db.size() >= 2) {
			Set<String> keys = db.keySet(); // JSP101 JSP102
			List<Student> list = new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key)); // Adding STudent object into List
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(0));
		} else {
			try {
				String message = "No sufficient Student records to Show Lowest marks Student record";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
