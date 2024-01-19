<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc.pojo.PersonPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
List<PersonPOJO> pojo = (List<PersonPOJO>) request.getAttribute("persons");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

fieldset {
	margin: 15px 520px;
	text-align: center;
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

#data {
	margin-top: 30px; background-color : white;
	border: 1px solid black;
	width: 150px;
	border: 1px solid black;
	background-color: white;
}

#data th {
	border: 1px solid black;
	text-align: center;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<form action="./search" method="post">
			<fieldset>
				<legend>Search Person Details</legend>
				<table>
					<tr>
						<td>Enter Name</td>
						<td><input type="text" name="name"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="SEARCH">
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%>
		</h4>
		<%
		}
		%>
		<%
		if (pojo != null) {
		%>
		<table id="data">
			<tr>
				<th>Name</th>
			</tr>
			<%
			for (PersonPOJO Pojo2 : pojo) {
			%>
			<tr>
				<td><%=Pojo2.getName()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>