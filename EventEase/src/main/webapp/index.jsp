<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main UI</title>
</head>
<body>

    <h1>This is Main UI</h1>
    
    <c:forEach var="cus" items="${cusDetails}">
    
        <c:set var="userId" value="${cus.id}"/>
        <c:set var="userName" value="${cus.userName}"/>
        
        User Id  - ${cus.id} <br>
        Name     - ${cus.name} <br>
        Email    - ${cus.email} <br>
        UserName - ${cus.userName} <br>
        Password - ${cus.password} <br>
    </c:forEach>
    
    <!-- Feedback section -->
    <c:url var="cus" value="feedback.jsp">
        <c:param name="userId" value="${userId}" />
        <c:param name="userName" value="${userName}" />
    </c:url>
    
    <a href="${cus}"><input type="submit" name="feedback" value="Feedback" ></a>
    <a href="feedbackView?userId=${userId}"><input type="button" value="View Feedbacks"></a>
    
    <!-- Inquiry section -->
    <c:url var="inquiry" value="inquiry.jsp">
        <c:param name="userId" value="${userId}" />
        <c:param name="userName" value="${userName}" />
    </c:url>

    <a href="${inquiry}"><input type="submit" name="inquiry" value="Add Inquiry" ></a>
    <a href="inquiryView?userId=${userId}"><input type="button" value="View Inquiries"></a>
    
</body>
</html>
