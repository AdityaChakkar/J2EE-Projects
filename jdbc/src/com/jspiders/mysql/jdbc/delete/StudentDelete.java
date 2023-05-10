package com.jspiders.mysql.jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String userName = "root";
		String password = "root";
		String query = "delete from student where sid = 5";
		
		//1)load or register the Driver
		Class.forName(className);
		System.out.println("1)Driver Registered successfully..!!");
		
		//2)Establish Connection
		Connection connection =DriverManager.getConnection(url,userName,password);
		System.out.println("2)Connection estblished successfully..!!");
		
		//3)Create Statement
		Statement statement = connection.createStatement();
		System.out.println("3)Statement created successfully..!!");
		
		//4)Execute Statement
		int res=statement.executeUpdate(query);
		if (res==1) {
			System.out.println("4)Query deleted successfully..!!");
		}else {
			System.out.println("4)Query not deleted..!!");
		}
		
		//5)Close the Connection
		connection.close();
	}
}

