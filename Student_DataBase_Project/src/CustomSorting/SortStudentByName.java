package CustomSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());
	}

}
//x-->Object to be inserted and y-->Already existing object
