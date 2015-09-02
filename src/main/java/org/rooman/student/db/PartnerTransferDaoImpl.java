package org.rooman.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.PartnerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerTransferDaoImpl implements PartnerTransferDao
{
	@Autowired
	@Resource( name = "sessionFactory" )
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(PartnerTransferDaoImpl.class);
	
	@Override
	public void uploadPartnerTransfer(PartnerTransfer transfer)
	{
		Session session = null;
		Transaction txn = null;
		try
		{
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(transfer);
			txn.commit();
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN PARTNER TRANSFER UPLOADING");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
	}

	@Override
	public boolean getTransactionByIdForUpload(String transactionId) 
	{
		Session session = null;
		boolean transactionIdFound = false;
		try
		{
			session = sessionFactory.openSession();
			PartnerTransfer ptransfer = (PartnerTransfer)session.get(PartnerTransfer.class, transactionId);
			if(ptransfer != null)
			{
				transactionIdFound = true;
			}
			else
			{
				transactionIdFound = false;
			}
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN FETCHING PARTNER TRANSFER");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return transactionIdFound;
	}
}
