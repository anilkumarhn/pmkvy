package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "REMIT_REQUEST")
public class RemitRequest implements Serializable
{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "STUDENT_ID")
	private  String studentId;
	
	@Column( name ="PARTNER_ID")
	private  String partnerId;
	
	public RemitRequest() 
	{
		super();
	}

	public RemitRequest(String studentId, String partnerId) 
	{
		super();
		this.studentId = studentId;
		this.partnerId = partnerId;
	}

	public String getStudentId() 
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	public String getPartnerId() 
	{
		return partnerId;
	}

	public void setPartnerId(String partnerId) 
	{
		this.partnerId = partnerId;
	}
	
	@Override
	public int hashCode() 
	{
		return this.getStudentId().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof RemitRequest) ) return false;
		RemitRequest other = (RemitRequest) obj;
		return this.studentId.equals(other.getStudentId());
	}
}
