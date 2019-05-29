package com.sampleapp.testapp.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sampleapp.testapp.model.Courses;
@Repository("CourseDAO")
@Transactional
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	private SessionFactory sessionfactory;
		@Override
		public boolean addCourse(Courses c) {
			try {
				sessionfactory.getCurrentSession().save(c);
				return true;
			}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		}

		@Override
		public Courses retrieveCourse(int id) {
			String query="FROM Courses WHERE cId=:cId";
			try {
				return sessionfactory.getCurrentSession().createQuery(query,Courses.class)
				                         .setParameter("cId", id).getSingleResult();
			}
			catch(Exception e) {
			return null;
			}
			
}
}
