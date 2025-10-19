package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDAO {

	void saveStudentsToFile(List<Student> students, String filename);
    List<Student> loadStudentsFromFile(String filename);
}
