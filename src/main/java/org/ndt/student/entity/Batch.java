package org.ndt.student.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "BATCH")
public class Batch implements Serializable  
{

	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "BATCH_ID")
	private String batchID;

	@Column( name = "CENTRE_ID")
	private String centreID;
	
	@Column( name = "LOCATION")
	private String location;
	
	@Column( name = "BATCH_SIZE")
	private String batchSize;
	
	@Column( name = "SECTOR_NAME")
	private String sectorName;
	
	@Column( name = "START_DATE")
	private String startDate;
	
	@Column( name = "END_DATE")
	private String endDate;
	
	@Column( name = "TEST_DATE")
	private String testDate;
	
	@Column( name = "TEST_CONDUCTED")
	private String testConducted;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable( name = "STUDENT_BATCH", joinColumns ={@JoinColumn( name = "BATCH_ID")}, inverseJoinColumns = {@JoinColumn ( name = "CANDIDATE_ID",referencedColumnName="CANDIDATE_ID")})
	Set<Student> studentList;
	
	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

	public Batch() 
	{
		super();
	}

	public Batch(String batchID, String centreID, String location,String batchSize, String sectorName, String startDate,
			String endDate, String testDate, String testConducted) 
	{
		super();
		this.batchID = batchID;
		this.centreID = centreID;
		this.location = location;
		this.batchSize = batchSize;
		this.sectorName = sectorName;
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

	
	public String getCentreID() {
		return centreID;
	}

	public void setCentreID(String centreID) {
		this.centreID = centreID;
	}

	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getBatchSize() 
	{
		return batchSize;
	}

	public void setBatchSize(String batchSize) 
	{
		this.batchSize = batchSize;
	}

	public String getSectorName() 
	{
		return sectorName;
	}

	public void setSectorName(String sectorName) 
	{
		this.sectorName = sectorName;
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
	
}
