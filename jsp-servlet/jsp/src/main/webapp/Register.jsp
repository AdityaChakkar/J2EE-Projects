<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Status</title>
</head>
<body>

	<%!int id;
	String firstName, lastName, email, mobile;%>


	<%
	id = Integer.parseInt(request.getParameter("id"));
	firstName = request.getParameter("firstName");
	lastName = request.getParameter("lastName");
	email = request.getParameter("email");
	mobile = request.getParameter("mobile");
	%>


	<%!String url = "jdbc:mysql://localhost:3306/mock?user=root&password=root";
		String query = "INSERT INTO MOCK (id, firstname, lastname, email, mobile) VALUES (?, ?, ?, ?, ?)";
		int count = 0;%>

	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, mobile);

		count = count + preparedStatement.executeUpdate();
	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
	%>

	<%-- Expression Tag: Display registration status --%>
	<h1>
		<%
		if (count == 1) {
		%>
		Form Successfully Registered
		<%
		} else {
		%>
		Failed to Register
		<%
		}
		%>
	</h1>
</body>
</html>
