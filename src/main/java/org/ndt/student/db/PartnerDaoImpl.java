package org.ndt.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class PartnerDaoImpl implements PartnerDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	private SessionFactory sessionFactory;

	public static final Logger logger = Logger.getLogger(PartnerDaoImpl.class);
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void uploadPartnerDatails(MultipartFile file)
	{
	}
}
