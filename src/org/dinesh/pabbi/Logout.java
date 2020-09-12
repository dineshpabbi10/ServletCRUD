package org.dinesh.pabbi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		response.setContentType("text/html");
		if(email.equals("dineshpabbi10@gmail.com")) {
			Cookie e = new Cookie("email","");
			response.addCookie(e);
			request.getSession().setAttribute("email", null);
			PrintWriter pw = response.getWriter();
			pw.println("Logged Out ! <a href='Login.html'>Login</a>");
		}else {
			request.getRequestDispatcher("Login.html").forward(request,response);
		}
		
	}

}
