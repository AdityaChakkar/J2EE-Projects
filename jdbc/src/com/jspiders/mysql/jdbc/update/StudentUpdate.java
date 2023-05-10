package com.jspiders.mysql.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String userName = "root";
		String password = "root";
		String query = "Update student set sname = 'Pranav' where sid = 2";

		// 1)load or register the Driver
		Class.forName(className);
		System.out.println("1)Driver Registered successfully..!!");

		// 2)Establish Connection
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("2)Connection estblished successfully..!!");

		// 2)Create Statement
		Statement statement = connection.createStatement();
		System.out.println("3)Statement created successfully..!!");

		// 4)Execute Statement
		statement.execute(query);
		System.out.println("4)Query executed successfully..!!");
		// 5)Close the Connection
		connection.close();
	}
}
