package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "ASSESSMENT_FEE")
public class AssessmentFee implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column( name = "ASSESSMENT_ID")
	private long assessmentID;
	
	@Column( name = "ASSESSMENT_FEE")
	private double assesssmentFee;
	
	@Column( name = "PAID_BY")
	private String paidBy;
	
	
	public AssessmentFee() 
	{
		super();
	}

	public AssessmentFee(double assesssmentFee, String paidBy)
	{
		super();
		this.assesssmentFee = assesssmentFee;
		this.paidBy = paidBy;
	}

	public long getAssessmentID()
	{
		return assessmentID;
	}

	public void setAssessmentID(long assessmentID)
	{
		this.assessmentID = assessmentID;
	}

	public double getAssesssmentFee() 
	{
		return assesssmentFee;
	}

	public void setAssesssmentFee(double assesssmentFee)
	{
		this.assesssmentFee = assesssmentFee;
	}

	public String getPaidBy()
	{
		return paidBy;
	}

	public void setPaidBy(String paidBy)
	{
		this.paidBy = paidBy;
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
		if ( !(obj instanceof AssessmentFee) ) return false;
		AssessmentFee other = (AssessmentFee) obj;
		return this.assessmentID == other.getAssessmentID();
	}
}
