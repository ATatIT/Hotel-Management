<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Login</h3>
	<form action="authenticate" method="post">


		<label>Email</label> <input type="email" id="email" name="email"
			placeholder=" "> <label>Password</label> <input
			type="password" id="password" name="password" placeholder=" ">
			<h4>${invalidemail}</h4>
			<h4>${invalidpass}</h4>
		<button type="submit" >Sign In</button>
	</form>
</body>
</html>