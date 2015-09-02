package org.rooman.student.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "COURSES")
public class Course implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "COURSE_ID")
	private String courseID;
	
	@Column( name = "SECTOR_NAME")
	private String sectorName;
	
	@Column( name = "COURSE_NAME")
	private String courseName;
	
	/*@ManyToMany( cascade = CascadeType.ALL , targetEntity = Student.class )
	@JoinTable( name = "COURSE_STUDENTS", joinColumns ={@JoinColumn( name = "COURSE_ID")}, inverseJoinColumns = {@JoinColumn ( name = "CANDIDATE_ID")})
	private Set<Student> students = new HashSet<Student>();
	*/
	
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
 	@JoinTable( name = "COURSE_BATCHES", joinColumns ={@JoinColumn( name = "COURSE_ID")}, inverseJoinColumns ={@JoinColumn( name = "BATCH_ID")}	)
	//@Access(AccessType.PROPERTY)
	private Set<Batch> batches ;
	
	@ManyToMany( mappedBy = "courses")
	private Set<Partner> partners;
	
	public Course() 
	{
		super();
	}
	
	public Course(String courseID, String sectorName, String courseName) 
	{
		super();
		this.courseID = courseID;
		this.sectorName = sectorName;
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

	public String getSectorName() 
	{
		return sectorName;
	}

	public void setSectorName(String sectorName) 
	{
		this.sectorName = sectorName;
	}

	public String getCourseName() 
	{
		return courseName;
	}

	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public Set<Batch> getBatches() 
	{
		return batches;
	}

	public void setBatches(Set<Batch> batches) 
	{
		this.batches = batches;
	}

	public Set<Partner> getPartners() 
	{
		return partners;
	}

	public void setPartners(Set<Partner> partners) 
	{
		this.partners = partners;
	}


	@Override
	public int hashCode() 
	{
		return this.getCourseID().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof Course ) ) return false;
		Course other = (Course) obj;
		return this.courseID.equals(other.getCourseID());
	}
}
