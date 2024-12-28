package app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.UserDao;
import app.entity.MD5;
import app.entity.User;


@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url_path;
	private User user;
	private UserDao userDao;
    /**
     * Default constructor. 
     */
    
    public void init() throws ServletException {
    	super.init();
    	
    	userDao = new UserDao();
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
		}
		
	}
	
	
	private RequestDispatcher getView(HttpServletRequest request, String view) {
		return request.getRequestDispatcher("WEB-INF/views/" + view + ".jsp");
	}
	

}
