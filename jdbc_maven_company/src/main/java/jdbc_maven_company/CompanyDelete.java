package jdbc_maven_company;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CompanyDelete {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id :");
		int id = scanner.nextInt();

		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall("CALL COMPANYDB.COMPANY_DELETE_BY_ID(?)");
		callableStatement.setInt(1, id);

		int count = callableStatement.executeUpdate();
		if (count == 1) {
			System.out.println("DELETED SUCCESFULLY");
		} else {
			System.out.println("FAILED TO DELETE");
		}

		connection.close();
		scanner.close();
	}
}
