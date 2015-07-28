package org.ndt.student.db;



import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public static final Logger logger = Logger.getLogger(StudentDaoImpl.class);
	
	@Override
	public void uploadStudentDetails(MultipartFile file)
	{}

	@Override
	public void createStudent(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}
//
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Student> getAllStudentList()
	{
		Session session = sessionFactory.openSession();
		//Query query=session.createQuery("select stud.candidateName,stud.enrollmentNo,stud.contactNo,stud.emailID,stud.address,stud.aadharNo,stud.aadharValidated,result.result,result.certIssuedByNSDC,result.certIssuedToStudent,result.nsdcProcessed,result.disbursementList from Student stud,AssessmentResult result");
		List<Student> studentList = (List<Student>) session.createCriteria(Student.class).list();
		
		/*for(Student student: studentList)
		{
			System.out.println("Student "+student.getAssessmentResult());
		}*/
		
		return studentList;
	}

	@Override
	public void editStudent(Student student)
	{
		System.out.println("Student Data : "+student);
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("update Student s set s.candidateName=:candidateName,s.enrollmentNo=:enrollmentNo,s.contactNo=:contactNo,s.emailID=:emailID,s.address=:address,s.aadharNo=:aadharNo,s.aadharValidated=:aadharValidated where s.candidateID=:candidateID");
		query.setParameter("candidateID",student.getCandidateID());
		query.setParameter("candidateName",student.getCandidateName());
		query.setParameter("enrollmentNo",student.getEnrollmentNo());
		query.setParameter("contactNo",student.getContactNo());
		query.setParameter("emailID",student.getEmailID());
		query.setParameter("address",student.getAddress());
		query.setParameter("aadharNo",student.getAadharNo());
		query.setParameter("aadharValidated",student.getAadharValidated());
		
		int modifications=query.executeUpdate();
		if(modifications == 1)
		{
			System.out.println("Successfully Updated");
		}
		else
		{
			System.out.println("Error in update");
		}
	
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentResult> getAllAssessmentResult() {
		List<AssessmentResult> assessmentResultList = (List<AssessmentResult>) sessionFactory.getCurrentSession().createCriteria(AssessmentResult.class).list();
		for(AssessmentResult result:assessmentResultList)
		{
			System.out.println("Result "+result);
		}
		return assessmentResultList;
	}
}

