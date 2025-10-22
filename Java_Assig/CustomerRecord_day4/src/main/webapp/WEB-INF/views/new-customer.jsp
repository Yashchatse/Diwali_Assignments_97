<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><title>Add Customer</title></head>
<body>
    <h2>Add New Customer</h2>
    <form:form action="save" method="post" modelAttribute="customer">
        Name: <form:input path="name" /><br><br>
        Email: <form:input path="email" /><br><br>
        Address: <form:input path="address" /><br><br>
        <input type="submit" value="Save" />
        <a href="<c:url value='/customer/list'/>">Cancel</a>
    </form:form>
</body>
</html>