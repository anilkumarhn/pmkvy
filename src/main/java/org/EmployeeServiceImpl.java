package org.ict.crudex.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.ict.crudex.dao.EmployeeDao;
import org.ict.crudex.entity.Employee;
import org.ict.crudex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public long createEmloyee(Employee employee) {
		return employeeDao.createEmloyee(employee);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}

	@Override
	public String updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(long empId) {
		return employeeDao.getEmployeeById(empId);
	}
}
