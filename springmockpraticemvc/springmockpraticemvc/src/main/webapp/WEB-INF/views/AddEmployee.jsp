<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Page</title>
<style type="text/css">
</style>
</head>
<body>
	<div align="center">
		<form action="./addemployee" method="post">
			<fieldset>
				<legend align="center" >Add Employee Details</legend>
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="ADD">
		</form>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		
		
		
	</div>
</body>
</html>