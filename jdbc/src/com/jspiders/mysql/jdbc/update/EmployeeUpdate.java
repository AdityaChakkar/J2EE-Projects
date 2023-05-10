package com.jspiders.mysql.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeUpdate {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the id : ");
		int eid = sc.nextInt();
		System.out.println("Enter the Name : ");
		String ename = sc.next();
		System.out.println("Enter the Contact : ");
		long contact = sc.nextLong();
		System.out.println("Enter the email : ");
		String email = sc.next();
		System.out.println("Enter the address : ");
		String address = sc.next();
		
		
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "UPDATE EMPLOYEE SET ENAME=?, CONTACT=?, EMAIL=?, ADDRESS=? WHERE EID=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, ename);
		ps.setLong(2, contact);
		ps.setString(3, email);
		ps.setString(4, address);
		ps.setInt(5, eid);
		int count = ps.executeUpdate();
		if (count==1) {
			System.out.println("Updated Successfully..!!");
		} else {
			System.out.println("Not Updated..!!");
		}
		connection.close();
	}
}
