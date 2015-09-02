package org.rooman.student.db;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.GovtRemits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GovtRemitsDaoImpl implements GovtRemitsDao
{
	@Autowired
	@Resource( name = "sessionFactory" )
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(GovtRemitsDaoImpl.class);
	
	@Override
	public boolean updateGovtRemits(GovtRemits govtRemits)
	{
		Session session = null;
		Transaction txn = null;
		boolean updated =false;
		String hql = " update GovtRemits set transactionDate=:transactionDate, description=:description, chequeNo=:chequeNo, creditDebit=:creditDebit, amountINR=:amountINR  where transactionID=:transactionID";
		try 
		{
			session =sessionFactory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("transactionDate", govtRemits.getTransactionDate() );
			query.setParameter("description", govtRemits.getDescription());
			query.setParameter("chequeNo", govtRemits.getChequeNo());
			query.setParameter("creditDebit", govtRemits.getCreditDebit());
			query.setParameter("amountINR", govtRemits.getAmountINR());
			query.setParameter("transactionID",govtRemits.getTransactionID());
			int result = query.executeUpdate();
			if(result > 0)
			{
				txn.commit();
				updated = true;
			}
			else
			{
				updated = false;
				logger.error("GOVT REMIT UPDATION FAILED");
			}
		}
		catch (HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN GOVT REMIT UPDATION");
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
	@SuppressWarnings("unchecked")
	public GovtRemits getGovtRemit(String transactionID) 
	{
		Session session = null;
		List<GovtRemits> govtRemitList = null;
		GovtRemits govtRemits = null;
		String hql = "from GovtRemits where transactionID=:transactionID";
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("transactionID", transactionID);
			govtRemitList = (List<GovtRemits>)query.list();
			Iterator<GovtRemits> iterator = govtRemitList.iterator();
			while (iterator.hasNext()) 
			{
				govtRemits = (GovtRemits) iterator.next();
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
		return govtRemits;
	}

}
