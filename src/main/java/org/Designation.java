package org.ict.crudex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DESIGNATION")
public class Designation implements Serializable {

	@Transient
	private static final long serialVersionUID = -1423204280856552445L;

	@Id
	@GeneratedValue
	@Column(name="DESG_ID")
	private long desgId;
	
	@Column(name="DESG_NAME", length=256)
	private String desgName;

	public Designation() {
		super();
	}

	public Designation(long desgId, String desgName) {
		super();
		this.desgId = desgId;
		this.desgName = desgName;
	}

	public Designation(String desg) {
		this.desgName = desg;
	}

	public long getDesgId() {
		return desgId;
	}

	public void setDesgId(long desgId) {
		this.desgId = desgId;
	}

	public String getDesgName() {
		return desgName;
	}

	public void setDesgName(String desgName) {
		this.desgName = desgName;
	}

	@Override
	public String toString() {
		return "Designation [desgId=" + desgId + ", desgName=" + desgName + "]";
	}
}
