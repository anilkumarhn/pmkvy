package org.ndt.student.db;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ndt.student.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class BatchDaoImpl implements BatchDao 
{

	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;
	
	public static final Logger logger = Logger.getLogger(BatchDaoImpl.class);
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void createBatch(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Batch> getBatchList() 
	{
		List<Batch> batchList = (List<Batch>) sessionFactory.getCurrentSession().createCriteria(Batch.class).list();
		return batchList;
	
	}

	@Override
	public void editBatch(Batch batch)
	{
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("update Batch set sectorName=:sectorName,startDate=:startDate,endDate=:endDate,testDate=:testDate,testConducted=:testConducted   where batchID=:batchID and centreID=:centreID");
		query.setParameter("sectorName",batch.getSectorName());
		query.setParameter("startDate",batch.getStartDate());
		query.setParameter("endDate",batch.getEndDate());
		query.setParameter("testDate",batch.getTestDate());
		query.setParameter("testConducted",batch.getTestConducted());
		query.setParameter("batchID",batch.getBatchID());
		query.setParameter("centreID",batch.getCentreID());
		
		int modifications=query.executeUpdate();
		if(modifications == 1)
		{
			System.out.println("Successfully Updated");
		}
		else
		{
			System.out.println("Error in update");
		}
	
	}
}
