package com.sampleapp.testapp.service;

import com.sampleapp.testapp.model.Courses;

public interface CourseService {
	public abstract boolean addCourse(Courses c);
	public abstract Courses retrieveCourse(int id);
}
