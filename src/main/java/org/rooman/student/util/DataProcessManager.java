package org.rooman.student.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.rooman.student.entity.Account;
import org.rooman.student.entity.AssessmentFee;
import org.rooman.student.entity.AssessmentResult;
import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Course;
import org.rooman.student.entity.GovtRemits;
import org.rooman.student.entity.Partner;
import org.rooman.student.entity.PartnerTransfer;
import org.rooman.student.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class DataProcessManager 
{
	private static final Logger logger = Logger.getLogger(DataProcessManager.class);
	
	public Partner masterDataProcessor(String[] data, Partner ppartner)
	{
		if(ppartner != null)
		{
			String courseId = data[8];
			Set<Course> courseSet = ppartner.getCourses();
			boolean courseFlag = false;
			boolean batchFlag = false;
			Course matchedCourse = null;
			
			outer: for(Course c : courseSet)
			{
				if(c.getCourseID().equals(courseId))
				{
					courseFlag = true;
					matchedCourse = c;
					String batchId = data[13];
					Set<Batch> batches = c.getBatches();
					
					for(Batch b : batches)
					{
						if(b.getBatchID().equals(batchId))
						{
							batchFlag = true;
							
							Student student = new Student(data[0], data[1], data[2], data[3],data[4], data[5], data[6], data[7]);
							student.setAccount(new Account(data[19],data[20],data[21],data[22],data[23]));
							
							Set<AssessmentFee> fees  = new HashSet<AssessmentFee>();
							fees.add(new AssessmentFee(Double.valueOf(data[11]), data[12]));
							student.setAssessmentFee(fees);
							
							Set<AssessmentResult> results = new HashSet<AssessmentResult>();
							results.add(new AssessmentResult(data[24],data[25], data[26], data[27], data[28]));
							student.setAssessmentResult(results);
							
							Set<GovtRemits> remits = new HashSet<GovtRemits>();
							remits.add(new GovtRemits(data[29], data[30], data[31], data[32], data[33],Double.valueOf(data[34])));
							student.setGovtRemits(remits);	
							
							b.getStudents().add(student);
							break outer;
						}
					}
					
				}
			}
			
			if(!courseFlag && !batchFlag)
			{	
				logger.debug("COURSE NOT FOUND && BATCH NOT FOUND");
				//create both course and batch set
				ppartner = createCourse(data, ppartner);
			}
			else if(!batchFlag)
			{
				logger.debug("COURSE FOUND BUT BATCH NOT FOUND");
				Set<Batch> batches = createBatch(data);
				//TO DO check
				if((matchedCourse.getBatches() != null) && (matchedCourse.getBatches().size() > 0))
				{
					matchedCourse.getBatches().addAll(batches);
				}
				else
				{
					matchedCourse.setBatches(batches);
				}
			}
			}
		else
		{
			//create new partner
			 ppartner = createCourse(data, ppartner);
		}
		return ppartner;
	}
	
	
	private Set<Batch> createBatch(String[] data)
	{
		Set<Student> students = new HashSet<Student>();
		
		Student student = new Student(data[0], data[1], data[2], data[3],data[4], data[5], data[6], data[7]);
		student.setAccount(new Account(data[19],data[20],data[21],data[22],data[23]));
		
		Set<AssessmentFee> fees  = new HashSet<AssessmentFee>();
		fees.add(new AssessmentFee(Double.valueOf(data[11]), data[12]));
		student.setAssessmentFee(fees);
		
		Set<AssessmentResult> results = new HashSet<AssessmentResult>();
		results.add(new AssessmentResult(data[24],data[25], data[26], data[27], data[28]));
		student.setAssessmentResult(results);
		
		Set<GovtRemits> remits = new HashSet<GovtRemits>();
		remits.add(new GovtRemits(data[29], data[30], data[31], data[32], data[33],Double.valueOf(data[34])));
		student.setGovtRemits(remits);	
		
		 Batch batch =  new Batch(data[13], data[14], data[15], data[16], data[17], data[18]);
		 batch.setStudents(students);
		 
		 Set<Batch> batchs = new HashSet<Batch>();
		 batchs.add(batch);
		 
		 return batchs;
	}
	
	private Partner createCourse(String[] data, Partner ppartner)
	{
		Set<Student> students = new HashSet<Student>();
		Set<Course> courseset = new HashSet<Course>();
		
		 Student student = new Student(data[0], data[1], data[2], data[3],data[4], data[5], data[6], data[7]); 	
		 students.add(student);
		
		 student.setAccount(new Account(data[19],data[20],data[21],data[22],data[23]));
		 
		 Set<AssessmentFee> fees  = new HashSet<AssessmentFee>();
		 fees.add(new AssessmentFee(Double.valueOf(data[11]), data[12]));
		 student.setAssessmentFee(fees);
		
		 Set<AssessmentResult> results = new HashSet<AssessmentResult>();
		 results.add(new AssessmentResult(data[24],data[25], data[26], data[27], data[28]));
		 student.setAssessmentResult(results);
		 
		 Set<GovtRemits> remits = new HashSet<GovtRemits>();
		 remits.add(new GovtRemits(data[29], data[30], data[31], data[32], data[33],Double.valueOf(data[34])));
		 student.setGovtRemits(remits);				
		 
		 students.add(student);
		 
		 Batch batch =  new Batch(data[13], data[14], data[15], data[16], data[17], data[18]);
		 batch.setStudents(students);
		 Set<Batch> batchs = new HashSet<Batch>();
		 batchs.add(batch);
		
		 Course course = new Course(data[8],data[9], data[10]);
		 course.setBatches(batchs);
		 
		 courseset.add(course);

		 if(ppartner == null)
		 {
			 ppartner = new Partner(data[35]);			 
		 }
		 
		 
		 if((ppartner.getCourses()) != null && (ppartner.getCourses().size() > 0))
		 {
			 ppartner.getCourses().addAll(courseset);
		 }
		 else
		 {
			 ppartner.setCourses(courseset);
		 }
		 return ppartner;
	}
	
	public Partner partnerDataProcessor( String sb)
	{
		Partner partner = null;
		String str = sb.toString();
		String[] data = str.split("~");
		if(data.length == 0 )
		{
			logger.info("ROW IS EMPTY.....");
		}
		else
		{
			partner = new Partner(data[0], data[1],data[2], data[3], data[4], data[5], data[6], data[7], Float.valueOf(data[8]), Float.valueOf(data[9]));	
			logger.debug("DATA PROCESSING COMPLETED.....");
		}
		return partner;
	}
	
	public PartnerTransfer partnerTransferDataProcessor( String sb)
	{
		PartnerTransfer partnerTransfer = null;
		String str = sb.toString();
		String[] data = str.split("~");
		if(data.length == 0 )
		{
			logger.info("ROW IS EMPTY.....");
		}
		else
		{
			double totalAmount = Double.valueOf(data[10]);
			double roomanShare = Double.valueOf(data[11]);
			double partnerShare = Double.valueOf(data[12]);
			double curTrnsAmt =  Double.valueOf(data[13]);
			double remainingAmt = Double.valueOf(data[14]);
			partnerTransfer = new PartnerTransfer(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], totalAmount, roomanShare, partnerShare, curTrnsAmt, remainingAmt, data[15]);
			logger.debug("DATA PROCESSING COMPLETED.....");
		}
		return partnerTransfer;
	}
}