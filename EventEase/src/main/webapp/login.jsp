<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<h1>Login Page - Welcome </h1>
	
	<form action="LoginServlet" method="post">
		User Name : <input type="text" name="uid"><br>
		Password  : <input type="password" name="pass"><br>
		
		<input type="submit" name="submit" value="Login">
	</form>

</body>
</html>