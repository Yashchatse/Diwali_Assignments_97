<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.demo.servlet.Book"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>
    <%
        Book book = (Book) request.getAttribute("book");
    %>
    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= book.getId() %>">
        Title: <input type="text" name="title" value="<%= book.getTitle() %>" required><br><br>
        Author: <input type="text" name="author" value="<%= book.getAuthor() %>" required><br><br>
        Price: <input type="number" step="0.01" name="price" value="<%= book.getPrice() %>" required><br><br>
        <input type="submit" value="Update">
        <a href="index.jsp">Cancel</a>
    </form>
</body>
</html>