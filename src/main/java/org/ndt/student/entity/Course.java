package org.ndt.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "COURSE")
public class Course implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "COURSE_ID", unique = true)
	private String courseID;
	
	@Column( name = "COURSE_NAME")
	private String courseName;

	public Course() 
	{
		super();
	}

	public Course(String courseID, String courseName) 
	{
		super();
		this.courseID = courseID;
		this.courseName = courseName;
	}

	public String getCourseID() 
	{
		return courseID;
	}

	public void setCourseID(String courseID) 
	{
		this.courseID = courseID;
	}

	public String getCourseName() 
	{
		return courseName;
	}

	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}
}
