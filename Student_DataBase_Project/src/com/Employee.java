package com;

public class Employee {
	String id;
	String name;

	static int count = 101;

	public Employee(String name) {
		this.id = "JSP" + count;
		this.name = name;
		count++;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("Anjan");
		System.out.println("ID:" + e1.id + " Name:" + e1.name);

		Employee e2 = new Employee("Amar");
		System.out.println("ID:" + e2.id + " Name:" + e2.name);

		Employee e3 = new Employee("Ram");
		System.out.println("ID:" + e3.id + " Name:" + e3.name);
	}

}
