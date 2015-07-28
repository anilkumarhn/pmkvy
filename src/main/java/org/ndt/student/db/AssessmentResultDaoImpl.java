package org.ndt.student.db;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssessmentResultDaoImpl implements AssessmentResultDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public static final Logger logger = Logger.getLogger(AssessmentResultDaoImpl.class);
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	

	@Override
	public void editAssessmentResult(Student student,AssessmentResult assessmentResult)
	{
		assessmentResult.setAssessmentID(null);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();//Error will come if u get AssessmentID auto generated
		Student s = (Student) session.load(Student.class,student.getCandidateID());
		s.getAssessmentResult().clear();
		
		Set<AssessmentResult> assResult = new HashSet<AssessmentResult>();
		assResult.add(assessmentResult);
		s.getAssessmentResult().addAll(assResult);
		System.out.println("Student: "+s);
		session.update(s);
		
		tx.commit();
		session.close();
		
	}
}
