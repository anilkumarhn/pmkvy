package org.rooman.student.db;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao
{
	public static final Logger logger = Logger.getLogger(StudentDaoImpl.class);
	
	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;;
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Student> getAllStudentList()
	{
		List<Student> studentList = null;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			studentList = (List<Student>) session.createCriteria(Student.class).list();
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return studentList;
	}
	
	@Override
	public boolean updateStudent(Student student)
	{
		Session session = null;
		boolean updated = false;
		Transaction txn = null;
		String hql = "update Student set candidateName=:candidateName, enrollmentNo=:enrollmentNo, contactNo=:contactNo, emailID=:emailID, aadharNo=:aadharNo, aadharValidated=:aadharValidated, address=:address where candidateID=:candidateID";
			try
			{
				session = sessionFactory.openSession();
				Query query = session.createQuery(hql);
				query.setParameter("candidateName", student.getCandidateName());
				query.setParameter("enrollmentNo", student.getEnrollmentNo());
				query.setParameter("contactNo", student.getContactNo());
				query.setParameter("emailID", student.getEmailID());
				query.setParameter("aadharNo", student.getAadharNo());
				query.setParameter("aadharValidated", student.getAadharValidated());
				query.setParameter("address", student.getAddress());
				query.setParameter("candidateID", student.getCandidateID());
				int result = query.executeUpdate();
				if(result > 0)
				{
					txn = session.beginTransaction();
					txn.commit();
					updated = true;
				}
				else
				{
					logger.error("STUDENT UPDATION FAILED");
					updated = false;
				}
			}
			catch(HibernateException hbe)
			{
				hbe.printStackTrace();
				logger.error("STUDENT UPDATION FAILED");
				updated = false;
			}
			finally
			{
				if(session != null)
					session.clear();
					session.close();
			}
		return updated;
	}

	@Override
	public Student getStudentById(String candidateID) 
	{
		Session session = null;
		Student student = null;
		try
		{
			session = sessionFactory.openSession();
			student  = (Student)session.get(Student.class, candidateID);
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN FETCHING RECORD");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return student;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentByAadharVal(String aadharVal) {
		
		Session session = null;
		List<Student> students= new ArrayList<Student>();
		String hql= "from Student where  aadharValidated=:aadharVal";
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setString("aadharVal",aadharVal);
			students = query.list();
			for (Student student : students)
			{
				System.out.println("Student:"+student.toString());
			}
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return students;
	}
}

