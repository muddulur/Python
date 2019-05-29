package com.sampleapp.testapp.service;



import java.util.List;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleapp.testapp.DAO.StudentDAO;
import com.sampleapp.testapp.model.Courses;
import com.sampleapp.testapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	private static final Logger LOG = Logger.getLogger(StudentServiceImpl.class.getName());
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student retrieveStudent(int id) {
		LOG.log(Level.INFO, "Request to Service for one student details");
		return studentDAO.retrieveStudent(id);
	}

	@Override
	public List<Student> retrieveAllStudent() {
		LOG.log(Level.INFO, "Retreiving Student in Service");
		return studentDAO.retrieveAllStudent();
	}

	@Override
	public boolean addStudent(Student student) {
		LOG.log(Level.INFO, "Adding Student to Service");
	return studentDAO.addStudent(student);	
	}

	@Override
	public List<Courses> retrieveStudentCourses(int id) {
		
		LOG.log(Level.INFO, "Request to Service for  student courses");
		if(studentDAO.retrieveStudent(id)==null) {
			return null;
		}
		
		return studentDAO.retrieveStudentCourses(id);
	}

	@Override
	public Student updateStudent(int id, Student s) {
		LOG.log(Level.INFO, "Updating in Service for one student details");
		if(studentDAO.retrieveStudent(id)==null) {
		 return null;
		}
		return studentDAO.updateStudent(id, s);
		
	}

	@Override
	public boolean deleteStudent(int id) {
		LOG.log(Level.INFO, "Deleting in Service for one student details");
		return studentDAO.deleteStudent(id);
		
	}
}
