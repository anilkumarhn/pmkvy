package org.ndt.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name ="ASSESSMENTRESULT")
public class AssessmentResult implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column( name ="ASSESSMENT_ID")
	private Long assessmentID;
	
	@Column( name ="RESULT")
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

	public Long getAssessmentID() 
	{
		return assessmentID;
	}

	public void setAssessmentID(Long assessmentID) 
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

/*	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AssessmentResult))
		{
			return false;
		}
		AssessmentResult other = (AssessmentResult)obj;
		return this.assessmentID == other.getAssessmentID() ;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.assessmentID.intValue();
	}*/
	
	@Override
	public String toString() {
		return "AssessmentResult [assessmentID=" + assessmentID + ", result="
				+ result + ", certIssuedByNSDC=" + certIssuedByNSDC
				+ ", certIssuedToStudent=" + certIssuedToStudent
				+ ", nsdcProcessed=" + nsdcProcessed + ", disbursementList="
				+ disbursementList + "]";
	}
	
	
	
	
	
}
