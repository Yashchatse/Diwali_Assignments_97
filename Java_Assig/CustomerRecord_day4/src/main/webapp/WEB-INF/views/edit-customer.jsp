<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><title>Edit Customer</title></head>
<body>
    <h2>Edit Customer</h2>
    <form:form action="update" method="post" modelAttribute="customer">
        <form:hidden path="id"/>
        Name: <form:input path="name" /><br><br>
        Email: <form:input path="email" /><br><br>
        Address: <form:input path="address" /><br><br>
        <input type="submit" value="Update" />
        <a href="<c:url value='/customer/list'/>">Cancel</a>
    </form:form>
</body>
</html>