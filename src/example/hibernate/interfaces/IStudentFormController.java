package example.hibernate.interfaces;


public interface IStudentFormController {
	public void openForm();
	public void saveButtonPressed();
	public void loadStudents();
	public void selectedStudentUpdated(IStudent student);
	public void studentSaved();
}
