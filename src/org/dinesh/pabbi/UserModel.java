package org.dinesh.pabbi;

public class UserModel {
	public int id;
	public String name;
	public String email;
	public int salary;
	
	UserModel(int id,String name,String email,int salary){
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
}
