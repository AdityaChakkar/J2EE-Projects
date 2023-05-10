package com.jspiders.mysql.jdbc.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentFetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		// String userName = "root";
		// String password = "root";
		String query = "select * from student";

		// 1)load or register the Driver
		Class.forName(className);
		//System.out.println("1)Driver Registered successfully..!!");

		// 2)Establish Connection
		Connection connection = DriverManager.getConnection(url);
		//System.out.println("2)Connection estblished successfully..!!");

		// 3)Create Statement
		Statement statement = connection.createStatement();
		//System.out.println("3)Statement created successfully..!!");

		// 4)Execute Statement
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println("Sid : "+resultSet.getInt(1));
			System.out.println("Sname : "+resultSet.getString(2));
			System.out.println("Contct no : "+resultSet.getLong(3));
			System.out.println("Address : "+resultSet.getString(4));
			System.out.println("******************************\n");
		}

		// 5)Close the Connection
		connection.close();
	}
}
