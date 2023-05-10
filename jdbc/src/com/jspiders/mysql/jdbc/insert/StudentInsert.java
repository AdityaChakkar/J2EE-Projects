package com.jspiders.mysql.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1)load or register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1)Driver Registered successfully..!!");
			
		//2)Establish Connection
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/studentdb","root","root");
		System.out.println("2)Connection estblished successfully..!!");

			
		//3)Create Statement
		Statement statement = connection.createStatement();
		System.out.println("3)Statement created successfully..!!");
			
		//4)Execute Statement
		statement.execute("Insert into student values(5,'Pratik',9142565761,'Pune')");
		System.out.println("4)Query executed successfully..!!");
		//5)Close the Connection
		connection.close();
	}
}
