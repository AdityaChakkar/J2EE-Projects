<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag Demo</title>
</head>
<body>
<%! List<Integer> list = new ArrayList<Integer>(); %>
<%
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
%>
<h1> <%=list %></h1>
</body>
<jsp:include page="TagDemo2.jsp"></jsp:include>
</html>