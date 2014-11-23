package example.hibernate.datasources;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import example.hibernate.entities.*;
import example.hibernate.interfaces.*;
import example.hibernate.utils.HibernateUtil;

/***
 * This class performs mutations on the database. There is no business
 * logic or user interface code.
 */

public class HibernateStudentDataSource implements IStudentDataSource {
	private IStudentFormController controller;

	/***
	 * Grab a list of all the students on the server
	 */
	@Override
	public List<IStudent> getStudents() {
		List<IStudent> students = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		students = (List<IStudent>) session.createQuery("from HibernateStudent").list();
		session.close();

		return students;
	}

	/***
	 * Save or update a student
	 */
	@Override
	public void saveStudent(IStudent student, String firstName, String lastName) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (student == null) {
			student = new HibernateStudent();
		}

		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		session.beginTransaction();
		
		if (student.getId() > 0) {
			session.update(student);
		}
		else {
			session.save(student);
		}
	
		session.getTransaction().commit();
		session.close();
		
		this.controller.studentSaved();		
	}

	@Override
	public IStudent newStudent() {
		return new HibernateStudent(0, "", "");
	}
	
	@Override
	public void setController(IStudentFormController controller) {
		this.controller = controller;
	}

}
