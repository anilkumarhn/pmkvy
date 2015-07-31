package org.ndt.student.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ndt.student.entity.Centre;
import org.ndt.student.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CentreDaoImp implements CentreDao
{
	private static final Logger logger = Logger.getLogger(CentreDaoImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void uploadCentreDetails(Centre centreDetails) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
				session.saveOrUpdate(centreDetails);
				tx.commit();
		}
		catch( Exception ex )
		{
				logger.debug("Centre Details Failed to Upload.....:"+ ex.getMessage());
				tx.rollback();			
		}
		finally
		{
				session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Centre> getAllCentres()
	{
		Session session = sessionFactory.openSession();
		List<Centre> centreList = null;
		try
		{
			centreList = session.createCriteria(Centre.class).list();
		}
		catch( Exception ex)
		{
			logger.debug(ex.getCause().getMessage());
		}
		finally
		{
			session.close();
		}
		return centreList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> getAllSectors() 
	{
		Session session = sessionFactory.openSession();
	    List<Sector> sectorsList = null;
		try
		{
			sectorsList = session.createCriteria(Sector.class).list();
		}
		catch( Exception ex)
		{
			logger.debug(ex.getCause().getMessage());
		}
		finally
		{
			session.close();
		}
		return sectorsList;
	}
}
