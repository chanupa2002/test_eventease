<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.customer.Feedback" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Feedback</title>
</head>
<body>

<h1>Modify Feedback</h1>

<%
    Feedback feedback = (Feedback) request.getAttribute("feedback");
    if (feedback != null) {
%>
    <form action="feedbackModify" method="post">
        <input type="hidden" name="feedbackId" value="<%= feedback.getFeedbackId() %>">
        No of Stars: <input type="number" name="no_of_stars" value="<%= feedback.getNoOfStars() %>"><br>
        Feedback: <input type="text" name="feedback" value="<%= feedback.getFeedbackDescription() %>"><br>
        <input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
        <input type="submit" value="Update Feedback">
    </form>
<%
    } else {
%>
    <p>Error: Feedback not found. Please go back and try again.</p>
<%
    }
%>

</body>
</html>
