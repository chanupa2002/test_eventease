<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Give Feedback</title>
</head>
<body>
	
	
	<%
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
	%>
	
	
	<form action="feedbackInsert" method="post">
		User Id : <input type="text" name="user_id" value="<%= userId %>"><br>
		User Name : <input type="text" name="user_name" value="<%= userName %>"><br>
		Rate : <input type="number" name="no_of_stars"><br>
		Feedback : <input type="text" name="feedback"><br>
		
		<input type="submit" name="submit" value="Submit">
	</form>



</body>
</html>