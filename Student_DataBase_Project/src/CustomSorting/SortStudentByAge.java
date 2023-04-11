package CustomSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByAge implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {

		return x.getAge() - y.getAge();
	}

}
//x-->Object to be inserted and y-->Already existing object
