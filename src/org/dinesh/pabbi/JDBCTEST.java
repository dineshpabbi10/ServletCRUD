package org.dinesh.pabbi;
import java.sql.*;
import java.util.ArrayList;

public class JDBCTEST {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tiffinpass");
		return con;
	}
	
	public static ArrayList<UserModel> getEmployees() throws SQLException, ClassNotFoundException {
		Connection con = JDBCTEST.getConnection();
		Statement stmt=con.createStatement();  
		ResultSet rs = stmt.executeQuery("select * from employee");
		ArrayList<UserModel> employees = new ArrayList<UserModel>();
		while(rs.next()) {
			employees.add(new UserModel(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("salary")));
		}
		return employees;
	}
	
	public static UserModel getEmployeeById(int id) throws SQLException, ClassNotFoundException {
		Connection con = JDBCTEST.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee where id = "+id);
		rs.next();
		UserModel result = new UserModel(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("salary"));
		return result;
	}
	
	public static int UpdateEmployeeById(int id,String name,String email,int salary) throws SQLException, ClassNotFoundException {
		Connection con = JDBCTEST.getConnection();
		String up = "UPDATE EMPLOYEE SET name = ?,email = ?,salary=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(up);
		stmt.setString(1,name);
		stmt.setString(2, email);
		stmt.setInt(3, salary);
		stmt.setInt(4, id);
		
		int rows = stmt.executeUpdate();
		return rows;
	}
	
	public static int DeleteEmployeeById(int id) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTEST.getConnection();
		PreparedStatement stmt = con.prepareStatement("Delete from Employee where id = ?");
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows;
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		System.out.println("Hello Main");
		System.out.println(JDBCTEST.getEmployees());
	}
}
  