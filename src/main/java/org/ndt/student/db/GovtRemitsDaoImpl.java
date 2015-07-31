package org.ndt.student.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Batch;
import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GovtRemitsDaoImpl implements GovtRemitsDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	private SessionFactory sessionFactory;

	public static final Logger logger = Logger.getLogger(GovtRemitsDaoImpl.class); 
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void uploadGovtRemitsDetails(GovtRemits govtRemits) 
	{
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try
		{
			session.saveOrUpdate(govtRemits);
			txn.commit();
			session.flush();
		}
		catch(Exception e)
		{
			if( e.getCause().getMessage().contains("Duplicate entry"))
		  	 {
		  		logger.info(" Duplicate Key :"+ e);
		  	 }
		   	 else
		   	 {
			   	// do nothing
		   	 }
		}
		finally
		{
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GovtRemits> getAllStudentList(String batchID) {
		Session session = sessionFactory.openSession();
		
		//List<GovtRemits> list=session.createCriteria(GovtRemits.class).createAlias("students","st").add(Restrictions.like("st.candidateID", "10000", MatchMode.ANYWHERE)).list();
		List<Student> students = session.createCriteria(Student.class).createAlias("batch","bt").add(Restrictions.like("bt.batchID", batchID, MatchMode.ANYWHERE)).list();
		logger.debug("Student :-"+students);
		List<GovtRemits> list = new ArrayList<GovtRemits>();
		for(Student student : students)
		{
			List<GovtRemits> templist = session.createCriteria(GovtRemits.class).createAlias("students","st").add(Restrictions.like("st.candidateID",  student.getCandidateID(), MatchMode.ANYWHERE)).list();
			list.addAll(templist);
		}
		logger.debug("Govt :- "+list);
		return list;
	}

	@Override
	public void editGovtRemits(Student student, GovtRemits govtRemits) 
	{
		Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();//Error will come if u get AssessmentID auto generated
	/*GovtRemits remits = (GovtRemits) session.load(GovtRemits.class, govtRemits.getTransactionID());
	remits.getStudents().clear();
	
	Set<Student> assResult = new HashSet<Student>();
	assResult.add(student);
	remits.getStudents().addAll(assResult);
	System.out.println("GovtRemits : "+govtRemits);
	session.update(remits);*/
	Query query = session.createQuery("update GovtRemits  set transactionID=:transactionID,transactionDate=:transactionDate,description=:description,chequeNo=:chequeNo, creditDebit=:creditDebit,amountINR=:amountINR where transactionID=:transactionID");
	query.setParameter("transactionID", govtRemits.getTransactionID());
	query.setParameter("transactionDate", govtRemits.getTransactionDate());
	query.setParameter("description", govtRemits.getDescription());
	query.setParameter("chequeNo", govtRemits.getChequeNo());
	query.setParameter("creditDebit", govtRemits.getCreditDebit());
	query.setParameter("amountINR", govtRemits.getAmountINR());
	int modifications=query.executeUpdate();
	if(modifications == 1)
	{
		System.out.println("Successfully Updated");
		tx.commit();
	}
	else
	{
		System.out.println("Error in update");
	}

	
	session.close();
		
	}
}
