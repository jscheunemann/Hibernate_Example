package example.hibernate.entities;

import javax.persistence.*;

import example.hibernate.interfaces.IStudent;

/***
 * This models a student, notice the use of annotations to create the DDL on the fly
 */

@Entity
@Table
public class HibernateStudent implements IStudent{

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;

	public HibernateStudent() {};

	public HibernateStudent(Integer id, String firstName, String lastName) {
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