package app.Hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import app.entity.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties props = new Properties();
				props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				props.put(Environment.URL, "jdbc:mysql://localhost:3306/student_management");
				props.put(Environment.USER, "root");
				props.put(Environment.PASS, "");
				props.put(Environment.SHOW_SQL, true);
				props.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.addProperties(props);
				
				// You need to add all your hibernate classes
				configuration.addAnnotatedClass(User.class);
				
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
						.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				
			} catch(Exception e) {
				System.err.println(e);
			}
		}
		
		
		return sessionFactory;
	}
}
