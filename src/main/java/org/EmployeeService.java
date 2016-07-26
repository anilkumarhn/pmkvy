package org.ict.crudex.service;

import java.util.List;

import org.ict.crudex.entity.Employee;

public interface EmployeeService {

	public long createEmloyee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(long empId);
	public String updateEmployee(Employee employee);
}
