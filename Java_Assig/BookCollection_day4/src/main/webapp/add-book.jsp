<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h2>Add New Book</h2>
    <form action="insert" method="post">
        Title: <input type="text" name="title" required><br><br>
        Author: <input type="text" name="author" required><br><br>
        Price: <input type="number" step="0.01" name="price" required><br><br>
        <input type="submit" value="Save">
        <a href="index.jsp">Cancel</a>
    </form>
</body>
</html>