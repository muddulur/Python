package com.sampleapp.testapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleapp.testapp.DAO.CourseDAO;
import com.sampleapp.testapp.model.Courses;
@Service("CourseService")
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public boolean addCourse(Courses c) {
		
		return courseDAO.addCourse(c);
	}

	@Override
	public Courses retrieveCourse(int id) {
		return courseDAO.retrieveCourse(id);
		 
}
}