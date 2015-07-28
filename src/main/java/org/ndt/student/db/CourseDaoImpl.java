package org.ndt.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CourseDaoImpl implements CourseDao
{

	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(CourseDaoImpl.class);
	
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void uploadCourseDetails(MultipartFile file) 
	{
		
	}
}

