package app.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.Hibernate.HibernateUtil;
import app.entity.Student;

public class StudentDao implements Serializable{

	private Transaction transaction;
	public StudentDao() {}
	
	
	// New student data is saved in the database
	public boolean addStudent(Student student) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.save(student);
			transaction.commit();
			
		} catch(Exception e) {
			transaction.rollback();
			System.out.println(e);
		}
		
		
		
		return false;
	}
	
	
	
	// To get a list of students
	@SuppressWarnings("unchecked")
	public List<Student> fetchStudents() {
		List<Student> studentList = new ArrayList<Student>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			studentList = (ArrayList<Student>) session.createQuery("FROM Student").getResultList();
			System.out.println("Fetched success");
		} catch(Exception e) {
			System.out.println("Fetched Failed");
			System.err.println(e);
		}
		
		
		return studentList;
	}
	
	
	// Delete a single student
	public boolean deleteStudent(Student student) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Student studentDb = (Student) session.createQuery("FROM Student WHERE student_id = :stid")
					.setParameter("stid", student.getStudnet_id())
					.getSingleResult();
			
			session.delete(studentDb);
			transaction.commit();
			
		} catch(Exception e) {
			transaction.rollback();
			System.out.println(e);
		}
		
		
		return false;
	}
	
	
	
	// Get single student details 
	public Student getStudent(int studentID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Student student = (Student) session.createQuery("FROM Student WHERE student_id = :stid")
					.setParameter("stid", studentID).getSingleResult();
			return student;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	public boolean updateStudent(Student student) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			System.out.println(student.getFirst_name());
			
			session.update(student);
			transaction.commit();
			
			System.out.println("Update success");
			return true;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
}
