package org.rooman.student.db;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(CourseDaoImpl.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Course> getSetctors() 
	{
		List<Course> sectorList = null;
		Session session = sessionFactory.openSession();
		String hql = "select sectorName from Course";
		Query query = session.createQuery(hql);
		try
		{
			sectorList = query.list();
			logger.info("Sector List :"+sectorList.toString());
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
		return sectorList;
	}

	@Override
	public Course findCourseByIdForUpload(String courseId)
	{
		Session session = sessionFactory.openSession();
		Course	course = (Course)session.get(Course.class, courseId);
		try
		{
			if(course != null)
			{
				Set<Batch> batchList = course.getBatches();
				course.getBatches().addAll(batchList);
			}
		}
		catch(HibernateException hbe)
		{
			logger.error("Error in fetching record :"+hbe);
		}
		finally
		{
			if(session != null)
				session.clear();
				session.close();
		}
		return course;
	}

	@Override
	public Course getCourseById(String courseId) 
	{
		Course course = null;
		Session session = sessionFactory.openSession();
		try
		{
			course = (Course)session.get(Course.class, courseId);
			logger.info("COURSE INFO :" +course);
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
		return course;
	}

	@Override
	public void updateCourseInfo(Course course) 
	{
		Session session = sessionFactory.openSession();
		String hql = "update Course set sectorName=:sectorName, courseName=:courseName where courseID=:courseID";
		try
		{
			Query query = session.createQuery(hql);
			query.setParameter("sectorName", course.getSectorName());
			query.setParameter("courseName", course.getCourseName());
			query.setParameter("courseID", course.getCourseID());
			query.executeUpdate();
			logger.info("COURSE UPDATED SUCCESSFULLY");
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
	}
}



