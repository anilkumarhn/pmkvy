package org.ndt.student.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.ndt.student.entity.Account;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Batch;
import org.ndt.student.entity.Centre;
import org.ndt.student.entity.Course;
import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Partner;
import org.ndt.student.entity.RoomanRemits;
import org.ndt.student.entity.Sector;
import org.ndt.student.entity.Student;

public class DataProcessManager 
{
	private Logger logger = Logger.getLogger(DataProcessManager.class);
	private Student student = null;
	private GovtRemits govtRemits = null;
	private RoomanRemits roomanRemits = null;
	private Sector sectorDetails = null;
	private Centre centreDetails = null;
	
	public GovtRemits studentDataProcessor(String sb)
	{
		String str = sb.toString();
		//List<String> processedData = new ArrayList<String>(Arrays.asList(str.split("'")));
		String[] data = str.split("~");
	
		if(data.length == 0 )
		{
			logger.debug("Empty row ..........");
		}
		else
		{
		    student = new Student(data[0], data[1], data[2], data[3],data[4], data[5], data[6], data[7]);
		    
		    Batch batch =  new Batch(data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16], data[17]);
			Set<Batch> batchs = new HashSet<Batch>();
			batchs.add(batch);
			student.setBatch(batchs);
			
			Course course = new Course(data[19], data[20]);
			Set<Course> courses = new HashSet<Course>();
			courses.add(course);
			student.setCourse(courses);
			
			Account account = new Account(data[24],data[25],data[26],data[27],data[28]);
			student.setAccount(account);
			
			AssessmentResult assessmentResult = new AssessmentResult(data[30], data[31], data[32], data[33], data[34]);
			Set<AssessmentResult> results = new HashSet<AssessmentResult>();
			results.add(assessmentResult);
			student.setAssessmentResult(results);
	
			govtRemits = new GovtRemits(Long.valueOf(data[36]), data[37], data[38], data[39], data[40],Double.valueOf(data[41]));
			Set<Student> students = new HashSet<Student>();
			students.add(student);
			govtRemits.setStudents(students);
			
			//student.setGovtRemits(govtRemits);
			
			
			logger.debug("Data Processing Completed ..........");
		}
		return govtRemits;
	}

	
	public RoomanRemits remitsDataProcessor(String sb)
	{
		String str = sb.toString();
		String[] data = str.split("~");
		if(data.length == 0 )
		{
			//logger.debug("Empty row ..........");
		}
		else
		{
				float roomanShare = Float.valueOf(data[49]);
				float partnerShare = Float.valueOf(data[50]);
				double totalAmount = Double.valueOf(data[52]);
				double curTrnsAmt = Double.valueOf(data[53]);
				roomanRemits = new RoomanRemits(data[46], data[47], data[48], roomanShare, partnerShare,data[51], totalAmount, curTrnsAmt, data[54], data[56], data[57], data[58],data[59],data[60]);
			
				Partner partner = new Partner(data[43], data[44]);
				Set<Partner> partners = new HashSet<Partner>();
				partners.add(partner);
				roomanRemits.setPartner(partners);
				
				logger.debug("Data Processing Completed ..........");
		}
		return roomanRemits;
	}
	
	
	public Sector sectorDataProcessor(String sb)
	{
		String str = sb.toString();
		String[] data = str.split("~");
		if(data.length == 0 )
		{
			//logger.debug("Empty row ..........");
		}
		else
		{
				sectorDetails = new Sector(data[0],data[1]);
				logger.debug("Data Processing Completed ..........");
		}
		return sectorDetails;
	}
	

	public Centre centreDataProcessor(String sb)
	{
		String str = sb.toString();
		String[] data = str.split("~");
		if(data.length == 0 )
		{
			//logger.debug("Empty row ..........");
		}
		else
		{
			    centreDetails = new Centre(data[0],data[1]);
				logger.debug("Data Processing Completed ..........");
		}
		return centreDetails;
	}
}


























