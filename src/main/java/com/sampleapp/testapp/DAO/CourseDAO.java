package com.sampleapp.testapp.DAO;

import com.sampleapp.testapp.model.Courses;

public interface CourseDAO {
	public abstract boolean addCourse(Courses c);
	public abstract Courses retrieveCourse(int id);
}
