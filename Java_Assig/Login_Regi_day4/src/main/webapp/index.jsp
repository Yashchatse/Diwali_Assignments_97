<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Page</title>
</head>
<body>
<h2>Login Form</h2>
<form action="loginservlet" method="post">
Username <input type="text" name="username" required><br><br>
Password <input type="password" name="password" required><br><br>
<input type="submit" value="login">
</form>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println("<p style='color:red;'>" + error + "</p>");
        }
    %>

</body>
</html>