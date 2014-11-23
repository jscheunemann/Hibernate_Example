package example.hibernate.controllers;

import example.hibernate.interfaces.*;


/***
 * The controller acts as a go-between for the view and datasource.
 * The main purpose of this class is to implement the business logic. 
 */
public class StudentFormController implements IStudentFormController {
	private IStudentFormView view;
	private IStudentDataSource dataSource;
	private IStudent selectedStudent;

	/***
	 * Grab references to the view and datasource for later use
	 */
	public StudentFormController(IStudentFormView view, IStudentDataSource source) {
		this.view = view;
		this.dataSource = source;
	}
 
	/***
	 * React to the save button
	 */
	@Override
	public void saveButtonPressed() {
		if (this.view.getFirstName().equals("") || this.view.getLastName().equals("")) {
			this.view.showValidationErrorDialog(); 
		}
		else {
			this.dataSource.saveStudent(selectedStudent,
										this.view.getFirstName(), 
										this.view.getLastName());
		}
	}

	/***
	 * Clear the loaded students and re-query the database server
	 */
	@Override
	public void loadStudents() {
		this.view.clearStudentsComboBox();

		//Place holder student for new adding new student
		this.view.addStudent(dataSource.newStudent());

		for (IStudent student : dataSource.getStudents()) {
			this.view.addStudent(student);
		}
	}

	/***
	 * Open the form.
	 */
	@Override
	public void openForm() {
		this.loadStudents();
		this.view.open();
	}

	/***
	 * React to a change in the selected student
	 */
	@Override
	public void selectedStudentUpdated(IStudent student) {
		this.selectedStudent = student;
		if (student != null) {
			this.view.setFirstName(student.getFirstName());
			this.view.setLastName(student.getLastName());
		}
	}

	/***
	 * React to a write on the database
	 */
	@Override
	public void studentSaved() {
		this.loadStudents();
	}
}
