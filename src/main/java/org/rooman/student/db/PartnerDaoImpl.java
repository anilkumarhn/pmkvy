package org.rooman.student.db;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerDaoImpl implements PartnerDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	private SessionFactory sessionFactory;

	public static final Logger logger = Logger.getLogger(PartnerDaoImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<Partner> getPartnerList()
	{
		List<Partner> partnerList = null;
		Session session = null;
		String hql = "from Partner";
		try
		{
			session = sessionFactory.openSession();
			partnerList = session.createQuery(hql).list();
			logger.debug("PARTNER LIST :" +partnerList.toString());
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
		return partnerList;
	}

	@Override
	public boolean updatePartnerInfo( Partner partner )
	{
		boolean updateStatus = false;
		Session session = null;
		String hql = "update Partner set partnerName=:partnerName, address=:address, contactNumber=:contactNumber, emailID=:emailID, panNumber=:panNumber, contactPerson=:contactPerson, mouSigned=:mouSigned, tds=:tds, partnerShare=:partnerShare where partnerID=:partnerID";
		try
		{
			session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();	
			Query query = session.createQuery(hql);
			query.setParameter("partnerName", partner.getPartnerName());
			query.setParameter("address", partner.getAddress());
			query.setParameter("contactNumber", partner.getContactNumber());
			query.setParameter("emailID", partner.getEmailID());
			query.setParameter("panNumber", partner.getPanNumber());
			query.setParameter("contactPerson", partner.getContactPerson());
			query.setParameter("mouSigned", partner.getMouSigned());
			query.setParameter("tds",partner.getTds());
			query.setParameter("partnerShare", partner.getPartnerShare());
			query.setParameter("partnerID", partner.getPartnerID());
			int result = query.executeUpdate();
			if(result > 0)
			{
				txn.commit();
				updateStatus = true;
			}
			else
			{
				updateStatus = false;
			}
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("PARTNER UPDATION FAILED");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return updateStatus;
	}

	@Override
	public Partner getPartnerById(String partnerId)
	{
		Partner partner = null;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			partner = (Partner)session.get(Partner.class, partnerId);
			logger.info("PARTNER INFO :" +partner);
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
		return partner;
	}
	
	@Override
	public void bulkUploadPartnerDeatils(Collection<Partner> partnerList) 
	{
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			for(Partner p : partnerList)
			session.saveOrUpdate(p);
			txn.commit();
		}
		catch(Exception hbe)
		{
			if( hbe.getCause().getMessage().contains("Duplicate entry"))
		  	 {
		  		logger.info(" Duplicate Key :"+ hbe);
		  	 }
		   	 else
		   	 {
		   		logger.error(hbe);
		  	 }
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Partner getPartnerByMail(String emailID) 
	{
		List<Partner> partnerList = null;
		Partner partner = null;
		Session session = null;
		String hql = "from Partner where emailID=:emailID";
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("emailID", emailID);
			partnerList = (List<Partner>)query.list();
			for(Partner p: partnerList)
			{
				partner = p;
			}
		}
		catch(HibernateException hbe)
		{
			hbe.printStackTrace();
			logger.error("ERROR IN PARTNER SEARCH");
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return partner;
	}
}
