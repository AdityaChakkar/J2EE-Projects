<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag Demo</title>
</head>
<body>
<%! int a = 10;
	int b = 20;
	int sum = 0;
%>
<%!
public void add(int num1,int num2){
	sum = num1 + num2;
}
%>
<%add(a,b); %>
<h1><%=sum  %></h1>
</body>
</html>