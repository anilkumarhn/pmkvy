
package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "GOVTREMITS")
public class GovtRemits implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name ="TRANSACTION_ID")
	private String transactionID;
	
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
	
	public GovtRemits() 
	{
		super();
	}
	
	public GovtRemits(String transactionID, String transactionDate, String description, String chequeNo,String creditDebit, double amountINR) 
	{
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.description = description;
		this.chequeNo = chequeNo;
		this.creditDebit = creditDebit;
		this.amountINR = amountINR;
	}

	
	public String getTransactionID() 
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

	public void setTransactionID(String transactionID)
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
	
	public void setAmountINR(double amountINR) 
	{
		this.amountINR = amountINR;
	}

	@Override
	public int hashCode() 
	{
		return this.getTransactionID().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof GovtRemits ) ) return false;
		GovtRemits other = (GovtRemits) obj;
		return this.transactionID.equals(other.getTransactionID());
	}
}	
