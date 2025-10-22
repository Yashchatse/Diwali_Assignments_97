package com.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  first_name = request.getParameter("username");
		String password = request.getParameter("password");
		
		  String jdbcUrl = "jdbc:mysql://localhost:3306/ygfchatse";
	        String dbUser = "root"; 
	        String dbPassword = "YashChatse";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

	            String sql = "SELECT * FROM users WHERE first_name = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, first_name);
	            stmt.setString(2, password);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                // Login successful
	                response.sendRedirect("success.jsp");
	            } else {
	                // Login failed
	                request.setAttribute("error", "Invalid username or password.");
	                request.getRequestDispatcher("index.jsp").forward(request, response);
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Database error: " + e.getMessage());
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
	    }

	}


