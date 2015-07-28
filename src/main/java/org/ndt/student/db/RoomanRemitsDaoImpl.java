package org.ndt.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ndt.student.entity.RoomanRemits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomanRemitsDaoImpl  implements RoomanRemitsDao
{

	@Autowired
	@Resource( name = "sessionFactory")
	private SessionFactory sessionFactory;
	 
	public static Logger logger = Logger.getLogger(RoomanRemitsDaoImpl.class);
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void uploadRoomanRemitsDetails(RoomanRemits roomanRemits)
	{	
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try
		{
			session.saveOrUpdate(roomanRemits);
			txn.commit();
			session.flush();
		}
		catch(Exception e)
		{
			if( e.getCause().getMessage().contains("Duplicate entry"))
		  	 {
		  		logger.info(" Duplicate Key :"+ e);
		  	 }
		   	 else
		   	 {
			   	// do nothing
		   	 }
		}
		finally
		{
			session.close();
		}
	}
}