<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Inquiry</title>
</head>
<body>

<h1>Modify Inquiry ID: ${inquiry.id}</h1>

<form action="updateInquiry" method="POST">
    <input type="hidden" name="inquiryId" value="${inquiry.id}">
    <input type="hidden" name="userId" value="${param.userId}">
    
    <label for="inquiry_type">Inquiry Type:</label>
    <input type="text" id="inquiry_type" name="inquiry_type" value="${inquiry.inquiryType}" required><br><br>

    <label for="inquiry">Inquiry:</label>
    <textarea id="inquiry" name="inquiry" required>${inquiry.inquiry}</textarea><br><br>

    <input type="submit" value="Update Inquiry">
</form>

<a href="inquiryView?userId=${param.userId}">Back to Inquiries</a>

</body>
</html>
