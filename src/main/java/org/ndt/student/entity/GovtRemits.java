
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
@Table( name = "GOVTREMITS")
public class GovtRemits implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@Column( name ="TRANSACTION_ID")
	private Long transactionID;
	
	@Column( name ="TRANSACTION_DATE")
	private String transactionDate;
	
	@Column( name ="DESCRIPTION")
	private String description;
	
	@Column( name ="CHEQUE_NO")
	private String chequeNo;
	
	@Column( name ="CREDIT_OR_DEBIT")
	private String creditDebit;
	
	@Column( name ="AMOUNT_INR")
	private double amountINR;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
 	@JoinTable( name = "GOVTREMITS_STUDENT", joinColumns ={@JoinColumn( name = "TRANSACTION_ID")}, inverseJoinColumns ={@JoinColumn( name = "CANDIDATE_ID")})
	private Set<Student> students ;

	
	public GovtRemits() 
	{
		super();
	}
	
	public GovtRemits(Long transactionID, String transactionDate, String description, String chequeNo,String creditDebit, double amountINR) 
	{
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.description = description;
		this.chequeNo = chequeNo;
		this.creditDebit = creditDebit;
		this.amountINR = amountINR;
	}

	
	public Long getTransactionID() 
	{
		return transactionID;
	}

	public String getTransactionDate() 
	{
		return transactionDate;
	}

	public String getDescription() 
	{
		return description;
	}

	public String getChequeNo()
	{
		return chequeNo;
	}

	public String getCreditDebit() 
	{
		return creditDebit;
	}

	public Double getAmountINR() 
	{
		return amountINR;
	}

	public void setTransactionID(Long transactionID)
	{
		this.transactionID = transactionID;
	}

	public void setTransactionDate(String transactionDate)
	{
		this.transactionDate = transactionDate;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public void setChequeNo(String chequeNo) 
	{
		this.chequeNo = chequeNo;
	}

	public void setCreditDebit(String creditDebit) 
	{
		this.creditDebit = creditDebit;
	}

	public void setAmountINR(Double amountINR) 
	{
		this.amountINR = amountINR;
	}
	
	public Set<Student> getStudents() 
	{
		return students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

	public void setAmountINR(double amountINR) 
	{
		this.amountINR = amountINR;
	}

	@Override
	public String toString() {
		return "GovtRemits [transactionID=" + transactionID	+ ", transactionDate=" + transactionDate + ", description="	+ description + ", chequeNo=" + chequeNo + ", creditDebit="
				+ creditDebit + ", amountINR=" + amountINR + ", students="+ students + "]";
	}
}	
