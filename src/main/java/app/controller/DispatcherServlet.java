package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.CourseDao;
import app.DAO.StudentDao;
import app.DAO.UserDao;
import app.entity.Course;
import app.entity.MD5;
import app.entity.Student;
import app.entity.User;


@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url_path;

	private UserDao userDao;
	private StudentDao studentDao;
	private CourseDao courseDao;
    /**
     * Default constructor. 
     */
    
    public void init() throws ServletException {
    	super.init();
    	
    	userDao = new UserDao();
    	studentDao = new StudentDao();
    	courseDao = new CourseDao();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		url_path = request.getServletPath();
		if(url_path.equals("/")) {
			getView(request, "login").forward(request, response);
		} else if(url_path.equals("/login")) {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			
			String isAuthenicated;
			if(userDao.authenticate(user)) {
				// Directed to the dashboard
				getView(request, "dashboard").forward(request, response);
			} else {
				request.setAttribute("auth", "false");
				getView(request, "login").forward(request, response);
			}
		} else if(url_path.equals("/students")) {	
			this.fetchStudents(request, response);
		} else if(url_path.equals("/save-student")) {
			Student student = new Student();
			student.setFirst_name(request.getParameter("firstname"));
			student.setLast_name(request.getParameter("lastname"));
			student.setEmail(request.getParameter("email"));
			
			student.setDate_of_birth(LocalDate.parse(request.getParameter("dob")));
			student.setGender(request.getParameter("gender").charAt(0));
			student.setPhone(request.getParameter("phone"));
			student.setAddress(request.getParameter("address"));
			student.setEnrollment_date(LocalDate.parse(request.getParameter("enrollmentdate")));
			
			studentDao.addStudent(student);
			this.fetchStudents(request, response);
		} else if(url_path.equals("/deleteStudent")) {
			Student student = new Student();
			student.setStudnet_id(Integer.parseInt(request.getParameter("stid")));
			
			studentDao.deleteStudent(student);
			this.fetchStudents(request, response);
		} else if(url_path.equals("/editStudent")) {
			request.setAttribute("student", studentDao.getStudent(Integer.valueOf(request.getParameter("stid"))));
			this.getView(request, "studentEdit").forward(request, response);
		} else if(url_path.equals("/studentUpdate")) {
			Student student = new Student();
			
			student.setStudnet_id(Integer.parseInt(request.getParameter("stid")));
			student.setFirst_name(request.getParameter("firstname"));
			student.setLast_name(request.getParameter("lastname"));
			student.setEmail(request.getParameter("email"));
			
			student.setDate_of_birth(LocalDate.parse(request.getParameter("dob")));
			student.setGender(request.getParameter("gender").charAt(0));
			student.setPhone(request.getParameter("phone"));
			student.setAddress(request.getParameter("address"));
			student.setEnrollment_date(LocalDate.parse(request.getParameter("enrollmentdate")));
			
			studentDao.updateStudent(student);
			
			request.setAttribute("student", student);
			this.getView(request, "studentEdit").forward(request, response);
		} else if(url_path.equals("/goDashboard")) {
			this.getView(request, "dashboard").forward(request, response);
		} else if(url_path.equals("/courses")) {
			List<Course> courseList = courseDao.fetchAllCourses();
			request.setAttribute("courseList", courseList);
			this.getView(request, "courses").forward(request, response);
		}
		
	}
	
	
	public void fetchStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = studentDao.fetchStudents();
		request.setAttribute("studentList", studentList);
		getView(request, "students").forward(request, response);
	}
	
	
	private RequestDispatcher getView(HttpServletRequest request, String view) {
		return request.getRequestDispatcher("WEB-INF/views/" + view + ".jsp");
	}
	

}
