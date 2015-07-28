package org.ndt.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name ="PARTNER")
public class Partner implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private Long serialNo;
	private String partnerID;
	private String partnerName;
	
	public Partner() 
	{
		super();
	}
	
	public Partner(String partnerID, String partnerName) 
	{
		super();
		this.partnerID = partnerID;
		this.partnerName = partnerName;
	}
	
	@Id
	@GeneratedValue
	@Column( name = "SERIAL_NO")
	public Long getSerialNo() 
	{
		return serialNo;
	}

	@Column( name = "PARTNER_ID", unique = true)
	public String getPartnerID()
	{
		return partnerID;
	}
	
	@Column( name = "PARTNER_NAME")
	public String getPartnerName()
	{
		return partnerName;
	}
	
	public void setSerialNo(Long serialNo) 
	{
		this.serialNo = serialNo;
	}

	public void setPartnerID(String partnerID)
	{
		this.partnerID = partnerID;
	}
	
	public void setPartnerName(String partnerName) 
	{
		this.partnerName = partnerName;
	}
	
	@Override
	public String toString() 
	{
		return "Partner [partnerID=" + partnerID + ", partnerName="+ partnerName + "]";
	}
}
