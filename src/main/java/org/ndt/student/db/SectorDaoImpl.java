package org.ndt.student.db;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ndt.student.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SectorDaoImpl  implements SectorDao
{
	
	private static final Logger logger = Logger.getLogger(SectorDaoImpl.class);
	
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
	public void uploadSectorDetails(Sector sectorDetails) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.saveOrUpdate(sectorDetails);
			tx.commit();
		}
		catch(Exception ex)
		{
			logger.debug("Scetor Details Failed to Upload......:"+ex.getMessage());
			tx.rollback();
		}
		finally
		{
			session.close();
		}
	}
}
