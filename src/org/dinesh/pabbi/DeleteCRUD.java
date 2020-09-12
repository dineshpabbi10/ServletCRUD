package org.dinesh.pabbi;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCRUD
 */
@WebServlet("/DeleteCRUD")
public class DeleteCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doDelete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			int rows = JDBCTEST.DeleteEmployeeById(id);
			response.setContentType("text/html");
			response.getWriter().println("<p>Deleted : "+rows+" records. Please click <a href=\"Login\">Here</a> to go back to main page");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("An error occured during updating operation");
			e.printStackTrace();
		}
	}

}
