package org.ndt.student.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CENTRE")
public class Centre 
{
	@Id
	@Column( name = "CENTRE_ID")
	private String centreID;
	@Column( name = "CENTRE_NAME")
	private String centreName;
	
	@ManyToMany
	@JoinTable(name = "CENTRE_SECTOR" , joinColumns = {@JoinColumn(name = "CENTRE_ID")},inverseJoinColumns = {@JoinColumn ( name = "SECTOR_ID")})
	private Set<Sector> sectors = new HashSet<Sector>();

	public String getCentreID() {
		return centreID;
	}

	public void setCentreID(String centreID) {
		this.centreID = centreID;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public Set<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}

	public Centre(String centreID, String centreName) {
		super();
		this.centreID = centreID;
		this.centreName = centreName;
	}

	public Centre() {
		super();
	}

	@Override
	public String toString() {
		return "Centre [centreID=" + centreID + ", centreName=" + centreName
				+ "]";
	}
	
	
}
