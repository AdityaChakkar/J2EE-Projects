package jdbc_maven_company;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CompanyUpdate {
	public static void main(String[] args) throws Exception{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter Id :");
		int id=scanner.nextInt();
		System.out.println("Enter Name :");
		String name=scanner.next();
		System.out.println("Enter GST :");
		String gst=scanner.next();
		System.out.println("Enter Address :");
		String address = scanner.next();
		System.out.println("Enter Phone :");
		long phone=scanner.nextLong();
		
		FileInputStream fileInputStream= new FileInputStream("companyconfig.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall("Call companydb.company_update_by_id(?,?,?,?,?)");
		 callableStatement.setInt(1, id);
			callableStatement.setString(2, name);
			callableStatement.setString(3, gst);
			callableStatement.setString(4, address);
			callableStatement.setLong(5, phone);
			int count=callableStatement.executeUpdate();
			if(count==1)
			{
				System.out.println("Updated");
			}
			else
			{
				System.out.println("Not Updated");
			}
		}
}
