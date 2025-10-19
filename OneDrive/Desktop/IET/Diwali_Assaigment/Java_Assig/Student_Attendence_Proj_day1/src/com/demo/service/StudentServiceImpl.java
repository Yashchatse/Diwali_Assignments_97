package com.demo.service;

import java.util.*;

import com.demo.beans.Student;
import com.demo.dao.StudentDAO;
import com.demo.dao.StudentDAOImpl;

public class StudentServiceImpl implements StudentService{

	 private final StudentDAO studentDAO = new StudentDAOImpl();

	@Override
	public SortedSet<Student> getStudentsSortedByAttendance(List<Student> students) {
		  SortedSet<Student> sortedStudents = new TreeSet<>(students);
	        return sortedStudents;
	}

	@Override
	public void saveStudents(List<Student> students, String filename) {
		studentDAO.saveStudentsToFile(students, filename);
		
	}

	@Override
	public List<Student> loadStudents(String filename) {
		return studentDAO.loadStudentsFromFile(filename);
	}

	    

}
