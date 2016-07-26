package org.ict.crudex.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {


	@Transient
	private static final long serialVersionUID = 7829475785583466577L;

	@Id
	@GeneratedValue
	@Column(name="EMP_ID", updatable=false)
	private long empId;
	
	@Column(name="EMP_CODE",unique=true, length=10)
	private String empCode;
	
	@Column(name="EMP_NAME", length=256, nullable=false)
	private String empName;
	
	@Column(name="DOB")
	private String empDob;
	
	
	@Column(name="isActive")
	private String isActive;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="EMP_DESG_ID")
	private Designation designation;

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="EMP_DEPT_ID")
	private Department department;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="EMP_ADDRESS", joinColumns={@JoinColumn(name="EID")}, inverseJoinColumns={@JoinColumn(name="AID")})
	private Set<Address> address;
	
	public Employee() {
		super();
	}
	
	public Employee(String empCode, String empName, String empDob, String isActive, Designation designation,
			Department department, Set<Address> address) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empDob = empDob;
		this.isActive = isActive;
		this.designation = designation;
		this.department = department;
		this.address = address;
	}
	
	public Employee(long empId, String empCode, String empName, String empDob, String isActive, Designation designation,
			Department department, Set<Address> address) {
		super();
		this.empId = empId;
		this.empCode = empCode;
		this.empName = empName;
		this.empDob = empDob;
		this.isActive = isActive;
		this.designation = designation;
		this.department = department;
		this.address = address;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDob() {
		return empDob;
	}

	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empCode=" + empCode + ", empName=" + empName + ", isActive=" + isActive
				+ ", designation=" + designation + ", department=" + department + ", address=" + address + "]";
	}
}
