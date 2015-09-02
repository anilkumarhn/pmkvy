package org.rooman.student.db;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rooman.student.entity.RemitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RemitRequestDaoImpl implements RemitRequestDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public boolean getRemitById(String studentId)
	{
		Session session = null;
		boolean studentFound = false;
		try
		{
			session = sessionFactory.openSession();
			RemitRequest remitRequest = (RemitRequest)session.get(RemitRequest.class, studentId);
			if( remitRequest != null )
			{
				studentFound = true;
			}
		}
		catch( HibernateException hbe)
		{
			hbe.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return studentFound;
	}

	@Override
	public boolean postRemitRequest(RemitRequest remitRequest) 
	{
		Session session = null;
		boolean postRemit = false;
		try
		{
			session = sessionFactory.openSession();
			session.save(remitRequest);
			postRemit = true;
		}
		catch( HibernateException hbe)
		{
			hbe.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return postRemit;
	}
}
