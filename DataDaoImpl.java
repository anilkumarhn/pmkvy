package org.mahesh.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mahesh.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public int insertRow(Employee employee) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

/*	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getList() {
		
		Session session = sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.close();
		return employeeList;
	}

	@Override
	public Employee getRowById(int id) {
		
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	@Override
	public int updateRow(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, id);
		session.delete(employee);
		tx.commit();
		Serializable ids = session.getIdentifier(employee);
		session.close();
		return (Integer) ids;
	}
*/}
