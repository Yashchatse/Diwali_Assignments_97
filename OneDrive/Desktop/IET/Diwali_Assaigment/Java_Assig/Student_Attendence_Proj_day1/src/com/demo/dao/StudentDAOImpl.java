package com.demo.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public void saveStudentsToFile(List<Student> students, String filename) {
	    // Create parent directories if they don't exist
	    File file = new File(filename);
	    file.getParentFile().mkdirs(); // creates 'data/' if needed

	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
	        oos.writeObject(students);
	        System.out.println("✅ Students saved to: " + file.getAbsolutePath());
	    } catch (IOException e) {
	        System.err.println("❌ Failed to save students: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Student> loadStudentsFromFile(String filename) {
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	            return (List<Student>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
	}

}
