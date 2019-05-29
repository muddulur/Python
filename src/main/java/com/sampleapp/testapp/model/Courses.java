package com.sampleapp.testapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COURSE_DETAILS")
public class Courses implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@Column(name="COU_ID")
	private int cId;

	public Courses(@NotNull int cId, @NotNull String cName, String description) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.description = description;
	}

	@NotNull
	@Column(name="COU_NAME")
	private String cName;
	@Column(name="COU_DESCRIPTION")
	private String description;
	


public Courses() {
	
}


@Override
public String toString() {
	return "Courses [cId=" + cId + ", cName=" + cName + ", description=" + description + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cName == null) ? 0 : cName.hashCode());
	result = prime * result + cId;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Courses other = (Courses) obj;
	if (cName == null) {
		if (other.cName != null)
			return false;
	} else if (!cName.equals(other.cName))
		return false;
	if (cId != other.cId)
		return false;
	return true;
}

public int getId() {
	return cId;
}

public void setId(int id) {
	this.cId = id;
}

public String getcName() {
	return cName;
}

public void setcName(String cName) {
	this.cName = cName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


}
