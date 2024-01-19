<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Person Page</title>
<style type="text/css">
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
</head>
<body>
	<div align="center">
		<form action="./add" method="post">
			<fieldset>
				<legend>Add Person Details</legend>
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
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