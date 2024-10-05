<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Inquiries</title>
</head>
<body>

    <h1>Inquiries for User: ${param.userId}</h1>

    <table border="1">
        <tr>
            <th>Inquiry ID</th>
            <th>Inquiry Type</th>
            <th>Inquiry</th>
            <th>Actions</th>
        </tr>
        
        <c:if test="${empty inquiryList}">
            <tr>
                <td colspan="4">No inquiries found.</td>
            </tr>
        </c:if>
        
        <c:forEach var="inquiry" items="${inquiryList}">
            <tr>
                <td>${inquiry.id}</td>
                <td>${inquiry.inquiryType}</td>
                <td>${inquiry.inquiry}</td>
                <td>
                    <!-- View Inquiry -->
                    <a href="viewInquiry?inquiryId=${inquiry.id}&userId=${param.userId}">View</a> |
                    
                    <!-- Modify Inquiry -->
                    <a href="modifyInquiry?inquiryId=${inquiry.id}&userId=${param.userId}">Modify</a> |
                    
                    <!-- Delete Inquiry -->
                    <a href="deleteInquiry?inquiryId=${inquiry.id}&userId=${param.userId}" onclick="return confirm('Are you sure you want to delete this inquiry?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="index.jsp">Back to Main UI</a>

</body>
</html>
