package com.demo.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class BookDao {
	 private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
	 private String jdbcUsername = "root"; // change as needed
	    private String jdbcPassword = "YashChatse"; // change as needed
	    private Connection jdbcConnection;
	    
	    protected void connect() throws SQLException{
	    	if(jdbcConnection == null || jdbcConnection.isClosed()) {
	    		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	    		 jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    	}
	    }
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }

	    // CREATE
	    public boolean insertBook(Book book) throws SQLException {
	        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
	        connect();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, book.getTitle());
	        statement.setString(2, book.getAuthor());
	        statement.setDouble(3, book.getPrice());

	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }

	    // READ
	    public List<Book> listAllBooks() throws SQLException {
	        List<Book> listBook = new ArrayList<>();
	        String sql = "SELECT * FROM books ORDER BY id";
	        connect();
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            double price = resultSet.getDouble("price");
	            Book book = new Book(id, title, author, price);
	            listBook.add(book);
	        }

	        resultSet.close();
	        statement.close();
	        disconnect();
	        return listBook;
	    }

	    // UPDATE
	    public boolean updateBook(Book book) throws SQLException {
	        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
	        connect();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, book.getTitle());
	        statement.setString(2, book.getAuthor());
	        statement.setDouble(3, book.getPrice());
	        statement.setInt(4, book.getId());

	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;
	    }

	    // DELETE
	    public boolean deleteBook(int id) throws SQLException {
	        String sql = "DELETE FROM books WHERE id=?";
	        connect();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, id);

	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;
	    }

	    // GET by ID
	    public Book getBook(int id) throws SQLException {
	        Book book = null;
	        String sql = "SELECT * FROM books WHERE id=?";
	        connect();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            double price = resultSet.getDouble("price");
	            book = new Book(id, title, author, price);
	        }

	        resultSet.close();
	        statement.close();
	        disconnect();
	        return book;
	    }



}
