package org.ndt.student.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SECTOR")
public class Sector 
{
	@Id
	@Column(name = "SECTOR_ID")
	private String sectorID;
	
	@Column(name = "SECTOR_NAME")
	private String sectorName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SECTOR_COURSE",joinColumns = {@JoinColumn(name = "SECTOR_ID")},inverseJoinColumns = {@JoinColumn ( name = "COURSE_ID")})
	private Set<Course> courses=new HashSet<Course>();

	public String getSectorID() {
		return sectorID;
	}

	public void setSectorID(String sectorID) {
		this.sectorID = sectorID;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Sector(String sectorID, String sectorName) {
		super();
		this.sectorID = sectorID;
		this.sectorName = sectorName;
	}

	public Sector() {
		super();
	}

	@Override
	public String toString() {
		return "Sector [sectorID=" + sectorID + ", sectorName=" + sectorName
				+ "]";
	}
	
	
}
