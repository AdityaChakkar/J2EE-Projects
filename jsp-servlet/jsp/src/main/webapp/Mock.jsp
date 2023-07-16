<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Student Details</h1>
    <form action="Register.jsp" method="POST">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
