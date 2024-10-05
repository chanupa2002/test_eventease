<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Inquiry</title>
</head>
<body>

<h1>Add an Inquiry</h1>

<form action="${pageContext.request.contextPath}/InsertInquiryServlet" method="POST">
    <input type="hidden" name="userId" value="${param.userId}">
    <label for="inquiry_type">Inquiry Type:</label>
    <input type="text" id="inquiry_type" name="inquiry_type" required><br><br>

    <label for="inquiry">Inquiry:</label>
    <textarea id="inquiry" name="inquiry" required></textarea><br><br>

    <input type="submit" value="Submit Inquiry">
</form>


<a href="index.jsp"><input type="button" value="Back"></a>

</body>
</html>
