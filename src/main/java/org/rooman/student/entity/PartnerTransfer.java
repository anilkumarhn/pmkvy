package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "PARTNER_TRANSFER")
public class PartnerTransfer implements Serializable 
{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "PARTNER_ID", nullable = false)
	private String partnerId;
	
	@Column(name = "TRANSACTED_DATE", nullable = true)
	private String transactedDate;
	
	@Column(name = "BENIFICIARY_NAME", nullable = true)
	private String benificiaryName;
	
	@Column(name = "BANK_NAME", nullable = true)
	private String bankName;
	
	@Column(name = "CHEQUE_NO", nullable = true , unique = true)
	private String chequeNo;
	
	@Column(name = "RECEIPT_NO", nullable = true)
	private String receiptNo;
	
	@Column(name = "INVOICE_NO", nullable = true)
	private String invoiceNo;
	
	@Column(name = "LIST_NO", nullable = true)
	private String listNumber;
	
	@Column(name = "NO_OF_CANDIDATES")
	private String noOfCandidates;
	
	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;
	
	@Column(name = "ROOMAN_SHARE")
	private double roomanShare;
	
	@Column(name = "PARTNER_SHARE")
	private double partnerShare;
	
	@Column(name = "CUR_TRAN_AMT")
	private double curTranAmount;
	
	@Column(name = "REMAINING_AMT")
	private double remainingAmount;
	
	@Column( name = "REMARK")
	private String remarks;

	public PartnerTransfer() 
	{
		super();
	}

	public PartnerTransfer(String partnerId, String transactionId,String transactedDate, String benificiaryName, String bankName,
			String chequeNo, String receiptNo, String invoiceNo,String listNumber, String noOfCandidates, double totalAmount,
			double roomanShare, double partnerShare, double curTranAmount,double remainingAmount, String remarks)
	{
		super();
		this.partnerId = partnerId;
		this.transactionId = transactionId;
		this.transactedDate = transactedDate;
		this.benificiaryName = benificiaryName;
		this.bankName = bankName;
		this.chequeNo = chequeNo;
		this.receiptNo = receiptNo;
		this.invoiceNo = invoiceNo;
		this.listNumber = listNumber;
		this.noOfCandidates = noOfCandidates;
		this.totalAmount = totalAmount;
		this.roomanShare = roomanShare;
		this.partnerShare = partnerShare;
		this.curTranAmount = curTranAmount;
		this.remainingAmount = remainingAmount;
		this.remarks = remarks;
	}

	public String getPartnerId() 
	{
		return partnerId;
	}

	public void setPartnerId(String partnerId)
	{
		this.partnerId = partnerId;
	}

	public String getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId(String transactionId) 
	{
		this.transactionId = transactionId;
	}

	public String getTransactedDate() 
	{
		return transactedDate;
	}

	public void setTransactedDate(String transactedDate) 
	{
		this.transactedDate = transactedDate;
	}

	public String getBenificiaryName() 
	{
		return benificiaryName;
	}

	public void setBenificiaryName(String benificiaryName) 
	{
		this.benificiaryName = benificiaryName;
	}

	public String getBankName() 
	{
		return bankName;
	}

	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}

	public String getChequeNo() 
	{
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) 
	{
		this.chequeNo = chequeNo;
	}

	public String getReceiptNo() 
	{
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) 
	{
		this.receiptNo = receiptNo;
	}

	public String getInvoiceNo() 
	{
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) 
	{
		this.invoiceNo = invoiceNo;
	}

	public String getListNumber() 
	{
		return listNumber;
	}

	public void setListNumber(String listNumber) 
	{
		this.listNumber = listNumber;
	}

	public String getNoOfCandidates() 
	{
		return noOfCandidates;
	}

	public void setNoOfCandidates(String noOfCandidates) 
	{
		this.noOfCandidates = noOfCandidates;
	}

	public double getTotalAmount() 
	{
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) 
	{
		this.totalAmount = totalAmount;
	}

	public double getRoomanShare()
	{
		return roomanShare;
	}

	public void setRoomanShare(double roomanShare)
	{
		this.roomanShare = roomanShare;
	}

	public double getPartnerShare() 
	{
		return partnerShare;
	}

	public void setPartnerShare(double partnerShare) 
	{
		this.partnerShare = partnerShare;
	}

	public double getCurTranAmount()
	{
		return curTranAmount;
	}

	public void setCurTranAmount(double curTranAmount) 
	{
		this.curTranAmount = curTranAmount;
	}

	public double getRemainingAmount() 
	{
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) 
	{
		this.remainingAmount = remainingAmount;
	}

	public String getRemarks() 
	{
		return remarks;
	}

	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chequeNo == null) ? 0 : chequeNo.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartnerTransfer other = (PartnerTransfer) obj;
		if (chequeNo == null) 
		{
			if (other.chequeNo != null)
				return false;
		} 
		else if (!chequeNo.equals(other.chequeNo))
			return false;
		if (transactionId == null)
		{
			if (other.transactionId != null)
				return false;
		} 
		else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
}
