package com.demo.service;

import java.util.List;
import java.util.SortedSet;

import com.demo.beans.Student;

public interface StudentService {

	 SortedSet<Student> getStudentsSortedByAttendance(List<Student> students);
	 
	    void saveStudents(List<Student> students, String filename);
	    
	    List<Student> loadStudents(String filename);
}
