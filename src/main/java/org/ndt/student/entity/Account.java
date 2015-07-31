package org.ndt.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ACCOUNT")
public class Account implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="ACCOUNT_NO", unique = true)
	private String accountNo;

	@Column(name ="BANK_NAME")
	private String bankName;

	@Column(name ="BRANCH_NAME")
	private String branchName;
	
	@Column(name ="IFSC_CODE")
	private String ifscCode;
	
	@Column( name ="BANK_GROUP", nullable = true)
	private String bankGroup;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankGroup() {
		return bankGroup;
	}

	public void setBankGroup(String bankGroup) {
		this.bankGroup = bankGroup;
	}

	public Account(String accountNo, String bankName, String branchName,
			String ifscCode, String bankGroup) {
		super();
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.bankGroup = bankGroup;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", bankName=" + bankName
				+ ", branchName=" + branchName + ", ifscCode=" + ifscCode
				+ ", bankGroup=" + bankGroup + "]";
	}
	
		
}