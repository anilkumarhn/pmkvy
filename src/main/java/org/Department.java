package org.ict.crudex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable {

	@Transient
	private static final long serialVersionUID = 5259519694111616653L;

	@Id
	@GeneratedValue
	@Column(name="DEPT_ID")
	private long deptId;
	
	@Column(name="DEPT_NAME" ,length=256)
	private String deptName;

	public Department() {
		super();
	}

	public Department(long deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Department(String dept) {
		this.deptName = dept;

	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
