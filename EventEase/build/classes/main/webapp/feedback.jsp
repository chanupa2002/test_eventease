<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.customer.Feedback" %>
<%@ page import="com.customer.CustomerDBUtil" %>

<html>
<head>
    <title>Feedbacks</title>
</head>
<body>
    <h2>Feedback List</h2>
    
    <% 
        // Get user ID from session or request; replace this with your logic to get userId
        int userId = 1; // Replace with actual logic to retrieve user ID
        List<Feedback> feedbackList = CustomerDBUtil.getFeedbackByUserId(userId);
    %>

    <table border="1">
        <tr>
            <th>Feedback ID</th>
            <th>No of Stars</th>
            <th>Feedback Description</th>
            <th>Action</th>
        </tr>
        <c:forEach var="feedback" items="${feedbackList}">
            <tr>
                <td>${feedback.feedbackId}</td>
                <td>${feedback.noOfStars}</td>
                <td>${feedback.feedbackDescription}</td>
                <td>
                    <form action="feedbackDelete" method="post">
                        <input type="hidden" name="feedbackId" value="${feedback.feedbackId}" />
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this feedback?');" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
