<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
fieldset {
	width: 300px;
	height: 150px;
	padding: 10px;
	display: flex;
	align-items: center;
	justify-content: space-around;
	
}
fieldset {
	margin: 15px 520px;
	text-align: center;
	width: 300px;
	height: 150px;
	padding: 10px;
	display: flex;
	align-items: center;
	justify-content: space-around;
}
</style>
</head>
<body>

	<div align="center">
		<h2>Register Company</h2>
		<form action="./createCompany" method="post">
			<fieldset>
				<legend>Create Company credentials</legend>
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"
							placeholder="company name"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="REGISTER">
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
	</div>

</body>
</html>