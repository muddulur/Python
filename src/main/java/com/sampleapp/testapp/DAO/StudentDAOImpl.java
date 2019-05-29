package com.sampleapp.testapp.DAO;

import java.util.List;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sampleapp.testapp.model.Courses;
import com.sampleapp.testapp.model.Student;
@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger LOG = Logger.getLogger(StudentDAOImpl.class.getName());
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Student retrieveStudent(int id) {
		LOG.log(Level.INFO, "Request to DAO for one student details");
		String query="FROM Student WHERE sId=:sId";
		try {
		Student student= sessionfactory.getCurrentSession()
			                     .createQuery(query, Student.class)
			                     .setParameter("sId", id)
			                     .getSingleResult();
			LOG.log(Level.INFO, student);
			return student;
		}
		catch(Exception e) {
			LOG.error(e);
		return null;
		}
	}

	@Override
	public List<Student> retrieveAllStudent() {
		LOG.log(Level.INFO, "Retrieving to DAO for All details");
		String query="FROM Student";
		try {
			List<Student> list=sessionfactory.getCurrentSession()
					.createQuery(query, Student.class)
				    .getResultList();
			LOG.log(Level.INFO, list);
			return list;	
		}
		catch(Exception e) {
		return null;
		}
	}

	@Override
	public boolean addStudent(Student student) {
		try {
			sessionfactory.getCurrentSession().save(student);
			LOG.log(Level.INFO, "Student added in DAO");
			return true;
			
		}
	catch(Exception e) {
		e.printStackTrace();
		return false;
		
	}
	}

	@Override
	public List<Courses> retrieveStudentCourses(int id) {
		LOG.log(Level.INFO, "Student courses in DAO");
		try {
			Session session=sessionfactory.getCurrentSession();
			Student student=(Student)session.get(Student.class, id);
			List<Courses> courses=student.getCourses();
			return courses;
		}
		catch(Exception e) {
		return null;
		}
	}

	@Override
	public Student updateStudent(int id, Student s) {
		LOG.log(Level.INFO, "Update details in DAO");
		try {
			Session session=sessionfactory.getCurrentSession();
			Student student=(Student)session.get(Student.class, id);
			student.setsName(s.getsName());
			student.setDescription(s.getDescription());
			student.setCourses(s.getCourses());
			session.update(student);
			return student;
		}
		catch(Exception e) {
			
		return null;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		LOG.log(Level.INFO, "Student delete in DAO");
		try {
		Session session=sessionfactory.getCurrentSession();
		Student student=(Student)session.get(Student.class, id);
		session.delete(student);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
