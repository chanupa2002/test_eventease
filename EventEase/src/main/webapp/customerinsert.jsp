<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>
	
	<form action="CustomerInsert" method="post">
		Name : <input type="text" name="name"><br>
		Email : <input type="text" name="email"><br>
		Phone Number : <input type="text" name="phone"><br>
		User Name : <input type="text" name="uid"><br>
		Password : <input type="password" name="psw"><br>
		
		<input type="submit" name="submit" value="Register">
	</form>



</body>
</html>