<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback Display</title>
</head>
<body>
    <h1>User Feedback</h1>
    
    <c:if test="${not empty errorMessage}">
        <div style="color:red;">${errorMessage}</div>
    </c:if>
    
    <c:if test="${not empty message}">
        <div style="color:blue;">${message}</div>
    </c:if>

    <table>
        <tr>
            <th>Feedback ID</th>
            <th>Feedback Text</th>
            <th>Date</th>
        </tr>
        <c:forEach var="feedback" items="${feedbackList}">
            <tr>
                <td>${feedback.id}</td>
                <td>${feedback.text}</td>
                <td>${feedback.date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
