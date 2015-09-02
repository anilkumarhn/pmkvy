package org.rooman.student.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable
{
	@Transient
    private static final long serialVersionUID = 1L;

    @Id  
    @Column(name = "CANDIDATE_ID")
    private String  candidateID;
    
    @Column(name = "CANDIDATE_NAME")
	private String candidateName;
    
    @Column(name = "ENROLLMENT_NO")
	private String enrollmentNo;
    
    @Column(name = "CONTACT_NO")
	private String contactNo;
    
    @Column(name = "EMAIL_ID")
	private String emailID;
    
    @Column(name = "AADHAR_NO")
	private String aadharNo;
    
    @Column(name = "AADHAR_NO_VALIDATED")
	private String aadharValidated;
    
    @Column(name = "ADDRESS")
	private String address;
  
    @ManyToMany( mappedBy = "students")
    private Set<Batch> batch = new HashSet<Batch>(0);
 
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNT_NO")
	private Account account;
    
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  	@JoinTable( name = "STUDENTS_ASSESSMENTFEE", joinColumns ={@JoinColumn( name = "CANDIDATE_ID",referencedColumnName="CANDIDATE_ID")}, inverseJoinColumns ={@JoinColumn( name = "ASSESSMENT_ID",referencedColumnName="ASSESSMENT_ID")}	)
    private Set<AssessmentFee> assessmentFee;


    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 	@JoinTable( name = "STUDENTS_ASSMTRESULT", joinColumns ={@JoinColumn( name = "CANDIDATE_ID",referencedColumnName="CANDIDATE_ID")}, inverseJoinColumns ={@JoinColumn( name = "ASSESSMENT_ID",referencedColumnName="ASSESSMENT_ID")}	)
    private Set<AssessmentResult> assessmentResult;
   
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 	@JoinTable( name = "STUDENTS_GOVTREMIT", joinColumns ={@JoinColumn( name = "CANDIADTE_ID",referencedColumnName="CANDIDATE_ID")}, inverseJoinColumns ={@JoinColumn( name = "TRANSACTION_ID",referencedColumnName="TRANSACTION_ID")}	)
    private Set<GovtRemits> govtRemits;
    
    @ManyToMany( mappedBy = "students" )
	private Set<Batch> batchs ;
	
    public Student() 
	{
		super();
	}

	public Student(String candidateID, String candidateName,String enrollmentNo, String contactNo, String emailID,
			String aadharNo, String aadharValidated, String address) 
	{
		super();
		this.candidateID = candidateID;
		this.candidateName = candidateName;
		this.enrollmentNo = enrollmentNo;
		this.contactNo = contactNo;
		this.emailID = emailID;
		this.aadharNo = aadharNo;
		this.aadharValidated = aadharValidated;
		this.address = address;
	}

	public String getCandidateID() 
	{
		return candidateID;
	}

	public void setCandidateID(String candidateID) 
	{
		this.candidateID = candidateID;
	}

	public String getCandidateName() 
	{
		return candidateName;
	}

	public void setCandidateName(String candidateName) 
	{
		this.candidateName = candidateName;
	}

	public String getEnrollmentNo() 
	{
		return enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) 
	{
		this.enrollmentNo = enrollmentNo;
	}

	public String getContactNo() 
	{
		return contactNo;
	}

	public void setContactNo(String contactNo) 
	{
		this.contactNo = contactNo;
	}

	public String getEmailID() 
	{
		return emailID;
	}

	public void setEmailID(String emailID) 
	{
		this.emailID = emailID;
	}

	public String getAadharNo() 
	{
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) 
	{
		this.aadharNo = aadharNo;
	}

	public String getAadharValidated()
	{
		return aadharValidated;
	}

	public void setAadharValidated(String aadharValidated) 
	{
		this.aadharValidated = aadharValidated;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Set<Batch> getBatch() 
	{
		return batch;
	}

	public void setBatch(Set<Batch> batch)
	{
		this.batch = batch;
	}

	public Account getAccount() 
	{
		return account;
	}

	public void setAccount(Account account) 
	{
		this.account = account;
	}

	public Set<AssessmentFee> getAssessmentFee() 
	{
		return assessmentFee;
	}

	public void setAssessmentFee(Set<AssessmentFee> assessmentFee) 
	{
		this.assessmentFee = assessmentFee;
	}

	public Set<AssessmentResult> getAssessmentResult() 
	{
		return assessmentResult;
	}

	public void setAssessmentResult(Set<AssessmentResult> assessmentResult) 
	{
		this.assessmentResult = assessmentResult;
	}

	public Set<GovtRemits> getGovtRemits() 
	{
		return govtRemits;
	}

	public void setGovtRemits(Set<GovtRemits> govtRemits) 
	{
		this.govtRemits = govtRemits;
	}
	
	@Override
	public int hashCode() 
	{
		return this.getCandidateID().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof Student ) ) return false;
		Student other = (Student) obj;
		return this.candidateID.equals(other.getCandidateID());
	}
}









	

