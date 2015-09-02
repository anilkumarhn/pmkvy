package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name ="ASSESSMENT_RESULT")
public class AssessmentResult implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column( name ="ASSESSMENT_ID")
	private long assessmentID;
	
	@Column( name ="ASSESSMENT_RESULT")
	private String result;
	
	@Column( name ="CERT_ISSUED_BY_NSDC")
	private String certIssuedByNSDC;
	
	@Column( name ="CERT_ISSUED_TO_STUDENT")
	private String certIssuedToStudent;
	
	@Column( name ="NSDC_PROCESSED")
	private String nsdcProcessed;
	
	@Column( name ="DISBURSEMENT_LIST")
	private String disbursementList;

	public AssessmentResult() 
	{
		super();
	}

	public AssessmentResult(String result, String certIssuedByNSDC,String certIssuedToStudent, String nsdcProcessed,
			String disbursementList) 
	{
		super();
		this.result = result;
		this.certIssuedByNSDC = certIssuedByNSDC;
		this.certIssuedToStudent = certIssuedToStudent;
		this.nsdcProcessed = nsdcProcessed;
		this.disbursementList = disbursementList;
	}

	public long getAssessmentID() 
	{
		return assessmentID;
	}

	public void setAssessmentID(long assessmentID) 
	{
		this.assessmentID = assessmentID;
	}

	public String getResult() 
	{
		return result;
	}

	public void setResult(String result) 
	{
		this.result = result;
	}

	public String getCertIssuedByNSDC() 
	{
		return certIssuedByNSDC;
	}

	public void setCertIssuedByNSDC(String certIssuedByNSDC) 
	{
		this.certIssuedByNSDC = certIssuedByNSDC;
	}

	public String getCertIssuedToStudent() 
	{
		return certIssuedToStudent;
	}

	public void setCertIssuedToStudent(String certIssuedToStudent) 
	{
		this.certIssuedToStudent = certIssuedToStudent;
	}

	public String getNsdcProcessed() 
	{
		return nsdcProcessed;
	}

	public void setNsdcProcessed(String nsdcProcessed) 
	{
		this.nsdcProcessed = nsdcProcessed;
	}

	public String getDisbursementList() 
	{
		return disbursementList;
	}

	public void setDisbursementList(String disbursementList) 
	{
		this.disbursementList = disbursementList;
	}
	
	@Override
	public int hashCode() 
	{
		return (int) this.getAssessmentID();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof AssessmentResult) ) return false;
		AssessmentResult other = (AssessmentResult) obj;
		return this.assessmentID == other.getAssessmentID();
	}
}
