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

public class CompanyFetch {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner("System.in");

		FileInputStream fileInputStream = new FileInputStream("companyconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		CallableStatement callableStatement = (CallableStatement) connection
				.prepareCall("CALL COMPANYDB.COMPANY_FETCH");
		ResultSet resultSet = callableStatement.executeQuery();
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1)+"\t");
			System.out.print(resultSet.getString(2)+"\t");
			System.out.print(resultSet.getString(3)+"\t");
			System.out.print(resultSet.getString(4)+"\t");
			System.out.println(resultSet.getLong(5));

		}
		connection.close();
		scanner.close();
	}
}
