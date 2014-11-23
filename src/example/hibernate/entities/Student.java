package example.hibernate.entities;

import example.hibernate.interfaces.IStudent;

public class Student implements IStudent {
	private long id;

	private String firstName;
	private String lastName;

	public Student() {
	}

	public Student(long id, String firstName, String lastName) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public long getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		if (this.getId() > 0) {
			return String.format("%s %s", this.getFirstName(), this.getLastName());
		}
		else {
			return "<Add Student>";
		}
	}
}
