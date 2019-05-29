package com.sampleapp.testapp.service;

import java.util.List;

import com.sampleapp.testapp.model.Courses;
import com.sampleapp.testapp.model.Student;

public interface StudentService {
	public abstract Student retrieveStudent(int id); 
	public abstract List<Student> retrieveAllStudent(); 
	public abstract boolean addStudent(Student student); 
	public abstract List<Courses> retrieveStudentCourses(int id); 
	public abstract Student updateStudent(int id,Student s); 
	public abstract boolean deleteStudent(int id);
}
