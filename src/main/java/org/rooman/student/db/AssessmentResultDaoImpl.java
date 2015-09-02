package org.rooman.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.AssessmentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssessmentResultDaoImpl implements AssessmentResultDao
{
	@Autowired
	@Resource( name = "sessionFactory" )
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(AssessmentResultDaoImpl.class);

	@Override
	public boolean updateAssmtResultInfo(AssessmentResult assessmentResult)
	{
		Session session = null;
		Transaction txn = null;
		boolean updated =false;
		String hql = " update AssessmentResult set result=:result, certIssuedByNSDC=:certIssuedByNSDC, certIssuedToStudent=:certIssuedToStudent, nsdcProcessed=:nsdcProcessed, disbursementList=:disbursementList where assessmentID=:assessmentID";
		try 
		{
			session =sessionFactory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("result",assessmentResult.getResult());
			query.setParameter("certIssuedByNSDC", assessmentResult.getCertIssuedByNSDC());
			query.setParameter("certIssuedToStudent", assessmentResult.getCertIssuedToStudent());
			query.setParameter("nsdcProcessed", assessmentResult.getNsdcProcessed());
			query.setParameter("disbursementList", assessmentResult.getDisbursementList());
			query.setParameter("assessmentID", assessmentResult.getAssessmentID());
			int result = query.executeUpdate();
			if(result > 0)
			{
				txn.commit();
				updated = true;
			}
			else
			{
				updated = false;
				logger.error("ASSESSMENT RESULT UPDATION FAILED");
			}
		}
		catch (HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN ASSESSMENT RESULT UPDATION");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return updated;
	}
}
