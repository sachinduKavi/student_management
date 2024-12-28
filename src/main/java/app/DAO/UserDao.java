package app.DAO;

import java.io.Serializable;

import org.hibernate.Session;

import app.Hibernate.HibernateUtil;
import app.entity.MD5;
import app.entity.User;

public class UserDao implements Serializable{
	public UserDao() {}
	
	
	public boolean authenticate(User user) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			User userDb = (User) session.createQuery("FROM User WHERE username = :username").setParameter("username", user.getUsername()).uniqueResult();
			
			return userDb.getPassword().equals(MD5.getMd5(user.getPassword()));
			
		} catch( Exception e) {
			System.err.println(e);
		}
		
		
		
		return false;
	}
}
