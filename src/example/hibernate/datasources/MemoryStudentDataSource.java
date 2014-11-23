package example.hibernate.datasources;

import java.util.List;
import java.util.Vector;

import example.hibernate.entities.Student;
import example.hibernate.interfaces.IStudent;
import example.hibernate.interfaces.IStudentDataSource;
import example.hibernate.interfaces.IStudentFormController;

public class MemoryStudentDataSource implements IStudentDataSource {
	private IStudentFormController controller;
	private List<IStudent> students = null;
	
	static long counter = 0L;
	
	public MemoryStudentDataSource() {
		students = new Vector<IStudent>();
	}

	@Override
	public List<IStudent> getStudents() {
		return (List<IStudent>) students;
	}

	@Override
	public void saveStudent(IStudent student, String firstName, String lastName) {
		long id = 1;
		
		if (student == null) {
			student = new Student();
		}
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		if (!(student.getId() > 0)) {
			students.add(new Student(++id, firstName, lastName));
		}

		this.controller.studentSaved();	
	}

	@Override
	public IStudent newStudent() {
		return new Student(0, "", "");
	}

	@Override
	public void setController(IStudentFormController controller) {
		this.controller = controller;
	}
}
