package org.dinesh.pabbi;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dinesh.pabbi.JDBCTEST;
import org.dinesh.pabbi.UserModel;


/**
 * Servlet implementation class EditCRUD
 */
@WebServlet("/EditCRUD")
public class EditCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			int rows = JDBCTEST.UpdateEmployeeById(id, name, email, salary);
			response.setContentType("text/html");
			response.getWriter().println("<p>Updated : "+rows+". Please click <a href=\"Login\">Here</a> to go back to main page");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("An error occured during updating operation");
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserModel user = null;
		try {
			user = JDBCTEST.getEmployeeById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

}
