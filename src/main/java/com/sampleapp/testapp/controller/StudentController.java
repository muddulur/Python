package com.sampleapp.testapp.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sampleapp.testapp.model.Courses;
import com.sampleapp.testapp.model.Student;
import com.sampleapp.testapp.service.StudentService;

@RestController
public class StudentController {
	private static final Logger LOG = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	StudentService studentservice;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello World";
		}
	@RequestMapping(value="/Students/{studentId}/Courses",method=RequestMethod.GET,produces="application/json",consumes="application/json")
	public List<Courses> retrieveCoursesOfStudents(@PathVariable int studentId){
		
		LOG.log(Level.INFO, "Request to Controller");
		
		return studentservice.retrieveStudentCourses(studentId) ;
	}
	
	@RequestMapping(value="/Students",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Object> registerStudentForCourse(@RequestBody Student student){
		
		LOG.log(Level.INFO, "Adding Student to Controller"+student.toString());
		
	     studentservice.addStudent(student);
	     
	     URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(student.getId())
                 .toUri();
	     
	     LOG.log(Level.INFO, location);
	     
return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/Students/{studentId}",method=RequestMethod.PUT,headers="Accept=application/json",produces="application/json",consumes="application/json")
	public  ResponseEntity<String> updateStudentDetails(@PathVariable int studentId,@RequestBody Student student){
		
		LOG.log(Level.INFO, "Updating details to Controller for"+studentId+"with"+student.toString());
		
		Student foundStudent=studentservice.retrieveStudent(studentId);
		if(foundStudent==null) {
			
			LOG.log(Level.INFO, "Error in updating student in Controller");
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	     studentservice.updateStudent(studentId, student);
	     return new ResponseEntity<String>(HttpStatus.OK);
		
	}

	@RequestMapping(value="/Students",method=RequestMethod.GET,produces="application/json",consumes="application/json")
	public  List<Student> totalStudentsRegistered(){
		
		LOG.log(Level.INFO, "Retrieving details in controller");
		
		return studentservice.retrieveAllStudent();
	}
	
	@RequestMapping(value="/Students/{studentId}",method=RequestMethod.DELETE,headers="Accept=application/json",produces="application/json",consumes="application/json")
	public ResponseEntity<Student> removeStudentDetails(@PathVariable int studentId){
		LOG.log(Level.INFO, "Removing details in Controller");
		Student foundStudent=studentservice.retrieveStudent(studentId);
		if(foundStudent==null) {
			
			LOG.log(Level.INFO, "Error in deleting details in Controller");
			 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		studentservice.deleteStudent(studentId);
		 return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
}
