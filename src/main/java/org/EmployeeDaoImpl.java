package org.ict.crudex.daoimpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ict.crudex.dao.EmployeeDao;
import org.ict.crudex.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long createEmloyee(Employee employee) {
	
		Session session = null;
		Transaction transaction = null;
		long statusFlag = 0L;
		try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
				statusFlag = (Long) session.getIdentifier(employee);
		} catch (HibernateException hbe) {
			System.out.println("Exception Caught Inside :: createEmloyee()......... ");
			hbe.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return statusFlag;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {
		
		Session session = null;
		List<Employee> empList = null;
		Query query = null;
		try {
				session = sessionFactory.openSession();
				query = session.createQuery("From Employee");
				empList = (List<Employee>)query.list();
		} catch (HibernateException hbe) {
			System.out.println("Exception Caught Inside :: getEmployeeList()......... ");
			hbe.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return empList;
	}

	@Override
	public String updateEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		String statusFlag ="";
		try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.update(employee);
				transaction.commit();
				statusFlag = "Updated Successfully";
		} catch (HibernateException hbe) {
			System.out.println("Exception Caught Inside :: updateEmployee()......... ");
			hbe.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return statusFlag;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Employee getEmployeeById(long empId) {
	
		Session session = null;
		Employee employee = null;
		try {
			session = sessionFactory.openSession();
			employee = (Employee) session.get(Employee.class, empId);
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return employee;
	}
}
