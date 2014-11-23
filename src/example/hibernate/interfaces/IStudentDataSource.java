package example.hibernate.interfaces;

import java.util.List;

public interface IStudentDataSource {
	public List<IStudent> getStudents();
	public void saveStudent(IStudent student, String firstName, String lastName);
	public IStudent newStudent();
	public void setController(IStudentFormController controller);
}
