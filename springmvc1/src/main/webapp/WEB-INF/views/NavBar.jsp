<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	height:1000px;
	width:100%;
/* 	background-color: rgb(34, 34, 34); */
}
/* NAV STARTS */
#navbar {
	margin-top: 5px;
	height: 45px;
	width: 1400px;
	border-bottom: 3px solid rgb(68, 214, 44);
	background-color: black;
	display: flex;
	justify-content: center;
	align-items: center;
	position: fixed;
	opacity: 0.9;
}

#navback {
	height: 70px;
	width: 1400px;
	/* border: 1px solid; */
	/* background-color: black; */
}

#option {
	height: 50px;
	width: 900px;
	/* border: 1px solid white; */ 
	display: flex;
	justify-content: space-evenly;
	align-items: center;
	margin-left: 490px;
}

div a {
	color: rgb(219, 219, 219);
	text-decoration: none;
	
}

div a:hover {
	color: red;
}



/* nav Ends */
</style>
</head>
<body>

	<header>
		<nav id="navbar">
			<div id="option">
				<a style="color: white;" href="./home">Home</a> <a
					style="color: white;" href="./add">Add Employee</a> <a
					style="color: white;" href="./search">Search Employee</a> <a
					style="color: white;" href="./searchAll">All Records</a> <a
					style="color: white;" href="./update">Update Employee</a> <a
					style="color: white;" href="./remove">Remove Employee</a> <a
					style="color: white;" href="./logout">Logout</a>
			</div>
		</nav>
	</header>
	<div id="navback"></div>
</body>
</html>