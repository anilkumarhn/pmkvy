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
import org.rooman.student.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDaoImpl implements BatchDao 
{
	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;
	
	public static final Logger logger = Logger.getLogger(BatchDaoImpl.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Batch> getBatchList() 
	{
		List<Batch> batchList = null;
		Session session = sessionFactory.openSession();
		try
		{
			batchList = (List<Batch>) session.createCriteria(Batch.class).list();
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
		}
		finally
		{	if(session != null)
				session.clear();
				session.close();
		}
		return batchList;
	}

	@Override
	public void updateBatchInfo(Batch batch)
	{
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "update Batch set batchSize=:batchSize, startDate=:startDate, endDate=:endDate, testDate=:testDate, testConducted=:testConducted where batchID=:batchID";
		try 
		{
			Query query = session.createQuery(hql);
			query.setParameter("batchSize", batch.getBatchSize());
			query.setParameter("startDate", batch.getStartDate());
			query.setParameter("endDate", batch.getEndDate());
			query.setParameter("testDate", batch.getTestDate());
			query.setParameter("testConducted", batch.getTestConducted());
			query.setParameter("batchID", batch.getBatchID());
			query.executeUpdate();
			txn.commit();
		}
		catch (HibernateException hbe)
		{
			logger.debug("batch updation failed.....");
		}
		finally
		{
			if( session != null)
				session.clear();
				session.close();
		}
	}

	@Override
	public Batch getBatchById(String batchID)
	{
		Batch batch = null;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			batch = (Batch)session.get(Batch.class, batchID);
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
		return batch;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Batch> getBatchByTestStatus(String testStatus) {
		
		Session session = null;
		List<Batch> batches= new ArrayList<Batch>();
		String hql= "from Batch where  testConducted=:testStatus or startDate=:testStatus";
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setString("testStatus",testStatus);
			batches = query.list();
			for (Batch batch : batches) {
				System.out.println("Batch:"+batch.toString());
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
		return batches;
	}

}
