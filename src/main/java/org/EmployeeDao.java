package org.ict.crudex.dao;

import java.util.List;

import org.ict.crudex.entity.Employee;

public interface EmployeeDao {

	public long createEmloyee(Employee employee);
	public List<Employee> getEmployeeList();
	public String updateEmployee(Employee employee);
	public Employee getEmployeeById(long empId);
}
