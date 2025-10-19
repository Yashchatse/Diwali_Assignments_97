package com.demo.test;

import java.util.*;

import com.demo.beans.InsufficientAttendanceException;
import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

public class StudentTest {
	 private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        StudentService service = new StudentServiceImpl();
	        List<Student> students = new ArrayList<>();
	        final int TOTAL_STUDENTS = 1;

	        System.out.println("Student Registration System");
	        System.out.println("Enter details for " + TOTAL_STUDENTS + " students.\n");

	        for (int i = 0; i < TOTAL_STUDENTS; ) {
	            System.out.println(">>> Student " + (i + 1) + " <<<");

	            String name = "";
	            String course = "";
	            double attendance = -1;
	            double score = -1;
	            boolean validInput = false;

	            // Use do-while to ensure valid student data before proceeding
	            do {
	                try {
	                    // Input name
	                    System.out.print("  Enter Name: ");
	                    name = scanner.nextLine().trim();
	                    if (name.isEmpty()) {
	                        System.out.println("   Name cannot be empty. Try again.");
	                        continue;
	                    }

	                    // Input course
	                    System.out.print("  Enter Course: ");
	                    course = scanner.nextLine().trim();
	                    if (course.isEmpty()) {
	                        System.out.println("  Course cannot be empty. Try again.");
	                        continue;
	                    }

	                    // Input attendance
	                    System.out.print("  Enter Attendance Percentage: ");
	                    attendance = Double.parseDouble(scanner.nextLine().trim());

	                    // Input score
	                    System.out.print("  Enter Score (0–100): ");
	                    score = Double.parseDouble(scanner.nextLine().trim());

	                    // Validate range (optional but good practice)
	                    if (attendance < 0 || attendance > 100 || score < 0 || score > 100) {
	                        System.out.println("   Attendance and Score must be between 0 and 100. Try again.");
	                        continue;
	                    }

	                    // Attempt to create student (this validates attendance ≥ 60%)
	                    Student student = new Student(i + 1, name, course, attendance, score);
	                    students.add(student);
	                    validInput = true; // Exit do-while
	                    System.out.println("  Student registered successfully!\n");

	                } catch (InsufficientAttendanceException e) {
	                    System.out.println(e.getMessage());
	                    System.out.println("     Please re-enter all details for this student.\n");
	                } catch (NumberFormatException e) {
	                    System.out.println("  Invalid number format. Please enter numeric values.\n");
	                } catch (Exception e) {
	                    System.out.println("   Unexpected error: " + e.getMessage() + ". Try again.\n");
	                }
	            } while (!validInput);

	            i++; 
	        }

	        // Save to file
	        String filename = "data/student.txt"; 
	        service.saveStudents(students, filename);

	        // Load from file
	        List<Student> loadedStudents = service.loadStudents(filename);

	        // Sort by attendance (descending)
	        SortedSet<Student> sortedStudents = service.getStudentsSortedByAttendance(loadedStudents);

	        // Display results
	        System.out.println("\n" + "=".repeat(80));
	        System.out.println("📊 FINAL REPORT: Students Sorted by Attendance (Highest to Lowest)");
	        System.out.println("=".repeat(80));
	        int rank = 1;
	        for (Student s : sortedStudents) {
	            System.out.printf("%2d. %s%n", rank++, s);
	        }
	        System.out.println("=".repeat(80));
	        System.out.println("💾 Data saved to: " + filename);
	    
}
}
