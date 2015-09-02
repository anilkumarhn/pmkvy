package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "ACCOUNT")
public class Account implements Serializable
{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="ACCOUNT_NO")
	private String accountNo;

	@Column(name ="BANK_NAME", nullable = true)
	private String bankName;

	@Column(name ="BRANCH_NAME", nullable = true)
	private String branchName;
	
	@Column(name ="IFSC_CODE", nullable = true)
	private String ifscCode;
	
	@Column( name ="BANK_GROUP", nullable = true)
	private String bankGroup;

	public String getAccountNo()
	{
		return accountNo;
	}

	public void setAccountNo(String accountNo) 
	{
		this.accountNo = accountNo;
	}

	public String getBankName() 
	{
		return bankName;
	}

	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}

	public String getBranchName() 
	{
		return branchName;
	}

	public void setBranchName(String branchName) 
	{
		this.branchName = branchName;
	}

	public String getIfscCode() 
	{
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) 
	{
		this.ifscCode = ifscCode;
	}

	public String getBankGroup() 
	{
		return bankGroup;
	}

	public void setBankGroup(String bankGroup) 
	{
		this.bankGroup = bankGroup;
	}

	public Account() 
	{
		super();
	}

	public Account(String accountNo, String bankName, String branchName,
			String ifscCode, String bankGroup) 
	{
		super();
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.bankGroup = bankGroup;
	}
	
	@Override
	public int hashCode() 
	{
		return this.getAccountNo().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof Account) ) return false;
		Account other = (Account) obj;
		return this.accountNo.equals(other.getAccountNo());
	}
}