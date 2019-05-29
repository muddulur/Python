package com.sampleapp.testapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sampleapp.testapp.model.Courses;
@Entity
@Table(name="STUDENT_DETAILS")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotNull
	@Id
	@Column(name="STD_ID")
	private int sId;
	

	public Student() {
	
	}
	public Student(@NotNull int sId, @NotNull String sName, String description,List<Courses> courses) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.description = description;
		this.courses = courses;
	}

	@NotNull
	@Column(name="STD_NAME")
	private String sName;
	@Column(name="STD_DESCRIPTION")
	private String description;

	@OneToMany(mappedBy="Student",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Courses> courses;

	public int getId() {
		return sId;
	}
	public void setId(int id) {
		this.sId = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

		
}
