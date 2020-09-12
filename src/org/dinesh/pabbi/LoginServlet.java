package org.dinesh.pabbi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email;
		String password;
		try {
		email = request.getParameter("email") == null ? "" : (String) request.getParameter("email");
		password = request.getParameter("password") == null ? "" : (String) request.getParameter("password");
		}
		catch(Exception e) {
			email = "";
			password = "";
		}
		
//		System.out.println(email);
//		System.out.println(password);
//		System.out.println(email.contentEquals("dineshpabbi10@gmail.com"));
		HttpSession s = request.getSession();
		String test = (String) s.getAttribute("email");
		System.out.print("Hello from LoginServlet "+test);
		
		if(email.equals("dineshpabbi10@gmail.com") && password.equals("welcome123")) {
			Cookie name = new Cookie("email","dineshpabbi10@gmail.com");
			response.addCookie(name);
			s.setAttribute("email", "dineshpabbi10@gmail.com");
			try {
				ArrayList<UserModel> emp = JDBCTEST.getEmployees();
				request.setAttribute("employees",emp );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("Success.jsp").forward(request, response);
		}
		else if(test.equals("dineshpabbi10@gmail.com")) {
			try {
				ArrayList<UserModel> emp = JDBCTEST.getEmployees();
				request.setAttribute("employees",emp );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("Success.jsp").forward(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("wrong password");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	

}
