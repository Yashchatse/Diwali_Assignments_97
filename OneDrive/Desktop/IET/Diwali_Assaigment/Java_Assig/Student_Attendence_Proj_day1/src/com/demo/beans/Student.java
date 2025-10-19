package com.demo.beans;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
	
	private int roll_no;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;
	
	public Student(){
	super();	
	}
	public Student(int roll_no, String sname, String course, double attendance_percentage, double score )throws InsufficientAttendanceException {
		this.roll_no = roll_no;
		this.sname = sname;
		this.course=course;
		setAttendance_percentage(attendance_percentage);
		this.score=score;
		
	}
	
	public void setAttendance_percentage(double attendance_percentage) throws InsufficientAttendanceException{
		if(attendance_percentage < 60.0) {
			throw new InsufficientAttendanceException("Attendance should be at least 60.0: " + sname );
		}
		this.attendance_percentage = attendance_percentage;
	}
	
	
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getAttendance_percentage() {
		return attendance_percentage;
	}
	
	 public String calculateGrade() {
	        if (score >= 90) return "A";
	        else if (score >= 80) return "B";
	        else if (score >= 70) return "C";
	        else if (score >= 60) return "D";
	        else return "F";
	    }
	 
	 
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + ", calculateGrade()=" + calculateGrade() + "]";
	}
	@Override
	public int compareTo(Student o) {
		return Double.compare(o.attendance_percentage, this.attendance_percentage);
	}
	
}
