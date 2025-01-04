package app.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.Hibernate.HibernateUtil;
import app.entity.Course;

public class CourseDao implements Serializable{
	private Transaction transaction;
	public CourseDao() {}
	
	
	public List<Course> fetchAllCourses() {
		List<Course> courseList = new ArrayList<Course>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			courseList = (List<Course>) session.createQuery("FROM Course").getResultList();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return courseList;
	}
}
