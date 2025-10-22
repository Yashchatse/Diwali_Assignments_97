<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h1>Customers</h1>
    <a href="<c:url value='/customer/showForm'/>">Add New Customer</a>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Actions</th></tr>
        <c:forEach var="cust" items="${customers}">
            <tr> 	
                <td>${cust.id}</td>
                <td>${cust.name}</td>
                <td>${cust.email}</td>
                <td>${cust.address}</td>
                <td>
                    <a href="<c:url value='/customer/updateForm/${cust.id}'/>">Edit</a> |
                    <a href="<c:url value='/customer/delete/${cust.id}'/>" onclick="return confirm('Delete?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>