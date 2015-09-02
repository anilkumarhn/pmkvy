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
@Table( name = "PARTNERS")
public class Partner implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "PARTNER_ID")
	private String partnerID;
	
	@Column( name = "PARTNER_NAME")
	private String partnerName;
	
	@Column( name = "ADDRESS")
	private String address;
	
	@Column( name = "CONTACT_NO")
	private String contactNumber;
	
	@Column( name = "EMAIL_ID")
	private String emailID;
	
	@Column( name = "PAN_NO")
	private String panNumber;
	
	@Column( name = "CONTACT_PERSON")
	private String contactPerson;
	
	@Column( name = "MOU_SIGNED")
	private String mouSigned;
	
	@Column( name = "TDS")
	private float tds;
	
	@Column( name = "PARTNER_SHARE")
	private float partnerShare;
	
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
 	@JoinTable( name = "PARTNER_COURSES", joinColumns ={@JoinColumn( name = "PARTNER_ID")}, inverseJoinColumns ={@JoinColumn( name = "COURSE_ID")}	)
	private Set<Course> courses;
	
/*
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable( name = "PARTNER_TRANSFER", joinColumns ={@JoinColumn( name = "PARTNER_ID")}, inverseJoinColumns ={@JoinColumn( name = "TRANSACTION_ID")})
	private Set<TransactionDetail> transactioDetails;
*/	
	public Partner() 
	{
		super();
	}
	
	public Partner(String partnerID, String partnerName, String address,String contactNumber, String emailID, String panNumber,
			String contactPerson, String mouSigned, float tds,float partnerShare)
	{
		super();
		this.partnerID = partnerID;
		this.partnerName = partnerName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.emailID = emailID;
		this.panNumber = panNumber;
		this.contactPerson = contactPerson;
		this.mouSigned = mouSigned;
		this.tds = tds;
		this.partnerShare = partnerShare;
	}

	public Partner(String partnerID) 
	{
		super();
		this.partnerID = partnerID;
	}

	public String getPartnerID() 
	{
		return partnerID;
	}

	public void setPartnerID(String partnerID)
	{
		this.partnerID = partnerID;
	}

	public String getPartnerName() 
	{
		return partnerName;
	}

	public void setPartnerName(String partnerName) 
	{
		this.partnerName = partnerName;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getContactNumber()
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}

	public String getEmailID() 
	{
		return emailID;
	}

	public void setEmailID(String emailID)
	{
		this.emailID = emailID;
	}

	public String getPanNumber() 
	{
		return panNumber;
	}

	public void setPanNumber(String panNumber) 
	{
		this.panNumber = panNumber;
	}

	public String getContactPerson() 
	{
		return contactPerson;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	public String getMouSigned() 
	{
		return mouSigned;
	}

	public void setMouSigned(String mouSigned) 
	{
		this.mouSigned = mouSigned;
	}

	public float getTds() 
	{
		return tds;
	}

	public void setTds(float tds) 
	{
		this.tds = tds;
	}

	public float getPartnerShare() 
	{
		return partnerShare;
	}

	public void setPartnerShare(float partnerShare) 
	{
		this.partnerShare = partnerShare;
	}

	
	public Set<Course> getCourses() 
	{
		return courses;
	}

	public void setCourses(Set<Course> courses) 
	{
		this.courses = courses;
	}

	@Override
	public int hashCode() 
	{
		return this.getPartnerID().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof Partner ) ) return false;
		Partner other = (Partner) obj;
		return this.partnerID.equals(other.getPartnerID());
	}

	@Override
	public String toString() {
		return "Partner [partnerID=" + partnerID + ", partnerName="+ partnerName + ", address=" + address + ", contactNumber="
				+ contactNumber + ", emailID=" + emailID + ", panNumber="+ panNumber + ", contactPerson=" + contactPerson
				+ ", mouSigned=" + mouSigned + ", tds=" + tds+ ", partnerShare=" + partnerShare + "]";
	}
}
