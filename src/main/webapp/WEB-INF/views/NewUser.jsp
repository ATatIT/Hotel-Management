<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>New User</h3>
	<form action="saveuser" method="post">

		FirstName : <input type="text" name="firstName"><br> <br>
		LastName : <input type="text" name="lastName"><br> <br>
		Email : <input type="email"  name="email"> <br> <br>
		Password : <input type="password"  name="password"><br> <br>
		ConfirmPassword : <input type="password"  name="confirmPassword"><br> <br>
		<h6>${passerror}</h6>
		<button type="submit" >Sign Up</button>
	</form>
</body>
</html>