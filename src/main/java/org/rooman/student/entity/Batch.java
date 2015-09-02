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
@Table( name = "BATCHES")
public class Batch implements Serializable  
{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "BATCH_ID"	)
	private String batchID;

	@Column( name = "BATCH_SIZE")
	private String batchSize;
	
	@Column( name = "START_DATE")
	private String startDate;
	
	@Column( name = "END_DATE")
	private String endDate;
	
	@Column( name = "TEST_DATE")
	private String testDate;
	
	@Column( name = "TEST_CONDUCTED")
	private String testConducted;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable( name = "BATCH_STUDENTS", joinColumns ={@JoinColumn( name = "BATCH_ID")}, inverseJoinColumns = {@JoinColumn ( name = "CANDIDATE_ID")})    
	private Set<Student> students;
		
	@ManyToMany( mappedBy = "batches")
	private Set<Course> course ;
	
	public Batch() 
	{
		super();
	}

	public Batch(String batchID, String batchSize, String startDate,String endDate, String testDate, String testConducted)
	{
		super();
		this.batchID = batchID;
		this.batchSize = batchSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testDate = testDate;
		this.testConducted = testConducted;
	}

	public String getBatchID() 
	{
		return batchID;
	}

	public void setBatchID(String batchID) 
	{
		this.batchID = batchID;
	}

	public String getBatchSize() 
	{
		return batchSize;
	}

	public void setBatchSize(String batchSize) 
	{
		this.batchSize = batchSize;
	}

	public String getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(String startDate) 
	{
		this.startDate = startDate;
	}

	public String getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(String endDate) 
	{
		this.endDate = endDate;
	}

	public String getTestDate() 
	{
		return testDate;
	}

	public void setTestDate(String testDate) 
	{
		this.testDate = testDate;
	}

	public String getTestConducted() 
	{
		return testConducted;
	}

	public void setTestConducted(String testConducted)
	{
		this.testConducted = testConducted;
	}

	public Set<Course> getCourse() 
	{
		return course;
	}

	public void setCourse(Set<Course> course) 
	{
		this.course = course;
	}
	
	
	public Set<Student> getStudents() 
	{
		return students;
	}

	public void setStudents(Set<Student> students) 
	{
		this.students = students;
	}
	
	@Override
	public int hashCode() 
	{
		return this.getBatchID().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof Batch) ) return false;
		Batch other = (Batch) obj;
		return this.batchID.equals(other.getBatchID());
	}
	
}
