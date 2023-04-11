package CustomSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentById implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {

		return x.getId().compareTo(y.getId());
	}

}
//x-->Object to be inserted and y-->Already existing object