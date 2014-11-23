package example.hibernate.views;

import java.awt.event.*;

import javax.swing.*;

import example.hibernate.interfaces.*;

/***
 * This class only deals with elements of the user interface. No business
 * logic or database code is found here. Notice the controller even takes
 * care of loading students prior to showing the form or after saving a 
 * student. 
 */

public class StudentFormDesktopView implements IStudentFormView {
	private IStudentFormController controller;
	private JFrame window;
	private JComboBox<IStudent> studentComboBox;
	private JTextField firstNameTextBox;
	private JTextField lastNameTextBox;
	private JButton okButton;

	public StudentFormDesktopView() {
		window = new JFrame();

		JPanel studentPanel = new JPanel();
		studentPanel.add(new JLabel("Student"));
		studentComboBox = new JComboBox<IStudent>();
		studentPanel.add(studentComboBox);
		
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.add(new JLabel("First Name"));
		firstNameTextBox = new JTextField(15);
		firstNamePanel.add(firstNameTextBox);

		JPanel lastNamePanel = new JPanel();
		lastNamePanel.add(new JLabel("Last Name"));
		lastNameTextBox = new JTextField(15);
		lastNamePanel.add(lastNameTextBox);

		okButton = new JButton("OK");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

		window.add(studentPanel);
		window.add(firstNamePanel);
		window.add(lastNamePanel);
		window.add(okButton);

		window.pack();
	}


	@Override
	public void open() {
		studentComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentFormDesktopView.this.controller.selectedStudentUpdated((IStudent) studentComboBox.getSelectedItem());
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentFormDesktopView.this.controller.saveButtonPressed();
			}
		});
		
		this.window.setVisible(true);
	}

	@Override
	public void addStudent(IStudent student) {
		studentComboBox.addItem(student);
	}


	@Override
	public String getFirstName() {
		return this.firstNameTextBox.getText();
	}


	@Override
	public void setFirstName(String firstName) {
		this.firstNameTextBox.setText(firstName);
		
	}


	@Override
	public String getLastName() {
		return this.lastNameTextBox.getText();
	}


	@Override
	public void setLastName(String lastName) {
		this.lastNameTextBox.setText(lastName);
	}

	@Override
	public void clearStudentsComboBox() {
		this.studentComboBox.removeAllItems();
	}


	@Override
	public void showValidationErrorDialog() {
		JOptionPane.showMessageDialog(this.window, "All fields are required.");
	}


	@Override
	public void setFormTitle(String title) {
		this.window.setTitle(title);
	}


	@Override
	public void setController(IStudentFormController controller) {
		this.controller = controller;
	}
}
