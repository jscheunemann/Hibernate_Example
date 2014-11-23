package example.hibernate.interfaces;


public interface IStudentFormView {
	public void setController(IStudentFormController controller);
	public void open();
	public void addStudent(IStudent student);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public void clearStudentsComboBox();
	public void showValidationErrorDialog();
	public void setFormTitle(String title);
}
