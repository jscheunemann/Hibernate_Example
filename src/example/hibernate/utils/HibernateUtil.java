package example.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/***
	 * This is a utility class to take care interacting with hibernate
	 */
	
	private static final SessionFactory sessionFactory;

	/**
	 * build a SessionFactory
	 */
	static {
	    try {
	        Configuration configuration = new Configuration().configure();
	        StandardServiceRegistry serviceRegistry = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    }
	    catch (Throwable ex) {
	        // Make sure you log the exception, as it might be swallowed
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
	}

	/**
	 * @return built SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
}