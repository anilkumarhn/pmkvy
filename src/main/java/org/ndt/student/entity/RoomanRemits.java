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
@Table( name = "ROOMANREMITS")
public class RoomanRemits implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "TRANSACTION_ID")
	private String transactionID;
	
	@Column( name = "TRANSACTED_DATE")
	private  String transactedDate;
	
	@Column( name = "BENIFICIARY_NAME")
	private String benificiaryName;
	
	@Column( name = "ROOMAN_SHARE")
	private float roomanShare;
	
	@Column( name = "PARTNER_SHARE")
	private float partnerShare;
	
	@Column( name = "BANK_NAME")
	private String bankName;
	
	@Column( name = "TOTAL_AMT")
	private double totalAmount;
	
	@Column( name = "CUR_TRANS_AMT")
	private double curTransAmount;
	
	@Column( name = "CHEQUE_NO", unique = true)
	private String chequeNo;
		
	@Column( name = "RECEIPT_NO")
	private String receiptNo;
	
	@Column( name = "INVOICE_NO")
	private String invoiceNo;
	
	@Column( name = "LIST_NO")
	private String listNo;
	
	@Column( name = "NO_OF_CANDIDATES")
	private String numOfCandidates;
	
	@Column( name = "REMARKS")
	private String remarks;
	
	
	@OneToMany( cascade = CascadeType.ALL)
 	@JoinTable( name = "ROOMAN_PARTNERS", joinColumns ={@JoinColumn( name = "TRANSACTIO_ID")}, inverseJoinColumns ={@JoinColumn( name = "PARTNER_ID")}	)
	private Set<Partner> partner;

	public RoomanRemits() 
	{
		super();
	}

	public RoomanRemits(String transactionID, String transactedDate,String benificiaryName, float roomanShare, float partnerShare,
			String bankName, double totalAmount, double curTransAmount,String chequeNo, String receiptNo, String invoiceNo, String listNo,
			String numOfCandidates, String remarks) 
	{
		super();
		this.transactionID = transactionID;
		this.transactedDate = transactedDate;
		this.benificiaryName = benificiaryName;
		this.roomanShare = roomanShare;
		this.partnerShare = partnerShare;
		this.bankName = bankName;
		this.totalAmount = totalAmount;
		this.curTransAmount = curTransAmount;
		this.chequeNo = chequeNo;
		this.receiptNo = receiptNo;
		this.invoiceNo = invoiceNo;
		this.listNo = listNo;
		this.numOfCandidates = numOfCandidates;
		this.remarks = remarks;
	}

	public String getTransactionID() 
	{
		return transactionID;
	}

	public void setTransactionID(String transactionID) 
	{
		this.transactionID = transactionID;
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

	public float getRoomanShare() 
	{
		return roomanShare;
	}

	public void setRoomanShare(float roomanShare) 
	{
		this.roomanShare = roomanShare;
	}

	public float getPartnerShare() 
	{
		return partnerShare;
	}

	public void setPartnerShare(float partnerShare) 
	{
		this.partnerShare = partnerShare;
	}

	public String getBankName() 
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public double getTotalAmount() 
	{
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) 
	{
		this.totalAmount = totalAmount;
	}

	public double getCurTransAmount() 
	{
		return curTransAmount;
	}

	public void setCurTransAmount(double curTransAmount) 
	{
		this.curTransAmount = curTransAmount;
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

	public String getListNo() 
	{
		return listNo;
	}

	public void setListNo(String listNo) 
	{
		this.listNo = listNo;
	}

	public String getNumOfCandidates() 
	{
		return numOfCandidates;
	}

	public void setNumOfCandidates(String numOfCandidates) 
	{
		this.numOfCandidates = numOfCandidates;
	}

	public String getRemarks() 
	{
		return remarks;
	}

	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public Set<Partner> getPartner() 
	{
		return partner;
	}

	public void setPartner(Set<Partner> partner) 
	{
		this.partner = partner;
	}
}
