package org.rooman.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;

	public static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	@Override
	public boolean updateAccountInfo(Account account) 
	{
		Session session = null;
		Transaction txn = null;
		boolean updated = false;
		String hql = "update Account set bankName=:bankName, branchName=:branchName, ifscCode=:ifscCode, bankGroup=:bankGroup  where accountNo=:accountNo";
		try
		{
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("bankName", account.getBankName());
			query.setParameter("branchName", account.getBranchName());
			query.setParameter("ifscCode", account.getIfscCode());
			query.setParameter("bankGroup", account.getBankGroup());
			query.setParameter("accountNo", account.getAccountNo());
			int result = query.executeUpdate();
			if(result > 0)
			{
				txn.commit();
				updated = true;
			}
			else
			{
				updated = false;
				logger.error("ACCOUNT UPDATION FAILED");
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
		return updated;
	}
}
