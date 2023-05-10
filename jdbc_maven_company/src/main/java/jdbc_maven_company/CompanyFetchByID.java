package jdbc_maven_company;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CompanyFetchByID {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id :");
		int id = scanner.nextInt();

		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall("CALL COMPANYDB.COMPANY_FETCH_BY_ID(?)");
		callableStatement.setInt(1, id);
		ResultSet resultSet = callableStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getLong(5));

		}
		connection.close();
		scanner.close();
	}
}
