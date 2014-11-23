package example.hibernate.main;

import example.hibernate.controllers.StudentFormController;
import example.hibernate.datasources.HibernateStudentDataSource;
import example.hibernate.datasources.MemoryStudentDataSource;
import example.hibernate.interfaces.*;
import example.hibernate.views.StudentFormDesktopView;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		IStudentFormController controller = null;
		IStudentDataSource hibSource = new HibernateStudentDataSource();
		IStudentFormView view = new StudentFormDesktopView();
		view.setFormTitle("Hibernate Student");
		controller = new StudentFormController(view, hibSource);
		hibSource.setController(controller);
		view.setController(controller);
		controller.openForm();
		
		IStudentFormController memController = null;
		IStudentDataSource memSource = new MemoryStudentDataSource();
		IStudentFormView memView = new StudentFormDesktopView();
		memView.setFormTitle("Memory Student");
		memController = new StudentFormController(memView, memSource);
		memSource.setController(memController);
		memView.setController(memController);
		memController.openForm();
	}
}
