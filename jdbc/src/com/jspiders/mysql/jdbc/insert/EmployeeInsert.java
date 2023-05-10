package com.jspiders.mysql.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeInsert {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id : ");
		int eid = sc.nextInt();
		System.out.print("Enter the name : ");
		String ename = sc.next();
		System.out.print("Enter the contact number : ");
		long contact = sc.nextLong();
		System.out.print("Enter the email : ");
		String email = sc.next();
		System.out.print("Enter the address : ");
		String address = sc.next();
		
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "insert into employee values(?,?,?,?,?)";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, eid);
		ps.setString(2, ename);
		ps.setLong(3, contact);
		ps.setString(4, email);
		ps.setString(5, address);
		int count = ps.executeUpdate();
		if (count==1) {
			System.out.println("Query inserted successfully..!!");
		}else {
			System.out.println("Query not inserted..!!");
		}
		connection.close();
	}
}
