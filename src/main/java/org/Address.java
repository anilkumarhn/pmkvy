package org.ict.crudex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

	@Transient
	private static final long serialVersionUID = 597949610511824947L;
	
	@Id
	@GeneratedValue
	@Column(name="ADDRESS_ID")
	private long addressId;
	
	@Column(name="PRI_ADDRESS", length=256)
	private String primaryAddress;

	@Column(name="CORRS_ADDRESS", length=256)
	private String corrsAddress;
	
	public Address() {
		super();
	}
	
	public Address(String primaryAddress, String corrsAddress) {
		super();
		this.primaryAddress = primaryAddress;
		this.corrsAddress = corrsAddress;
	}

	public Address(long addressId, String primaryAddress, String corrsAddress) {
		super();
		this.addressId = addressId;
		this.primaryAddress = primaryAddress;
		this.corrsAddress = corrsAddress;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getCorrsAddress() {
		return corrsAddress;
	}

	public void setCorrsAddress(String corrsAddress) {
		this.corrsAddress = corrsAddress;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", primaryAddress=" + primaryAddress + ","
				+ " corrsAddress="+ corrsAddress + "]";
	}
}
