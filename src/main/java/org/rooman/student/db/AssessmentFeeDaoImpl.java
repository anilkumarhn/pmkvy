package org.rooman.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.AssessmentFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssessmentFeeDaoImpl implements AssessmentFeeDao
{
	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(AssessmentFeeDaoImpl.class);
	
	@Override
	public boolean updateAssmtFeeInfo(AssessmentFee assessmentFee) 
	{
		Session session = null;
		Transaction txn = null;
		boolean updated = false;
		String hql = "update AssessmentFee set assesssmentFee=:assesssmentFee, paidBy=:paidBy where assessmentID=:assessmentID";
		try
		{
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("assesssmentFee", assessmentFee.getAssesssmentFee());
			query.setParameter("paidBy", assessmentFee.getPaidBy());
			query.setParameter("assessmentID", assessmentFee.getAssessmentID());
			int result = query.executeUpdate();
			if(result > 0)
			{
				txn.commit();
				updated = true;
			}
			else
			{
				logger.error("ASSESSMENT FEE UPDATION FAILED");
				updated = false;
			}
		}
		catch( HibernateException hbe )
		{
			hbe.printStackTrace();
			logger.error("ASSESSMENT FEE UPDATION FAILED");
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
