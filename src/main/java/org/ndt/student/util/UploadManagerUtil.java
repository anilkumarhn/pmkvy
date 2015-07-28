package org.ndt.student.util;


import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.RoomanRemits;
import org.ndt.student.services.AccountService;
import org.ndt.student.services.AssessmentResultService;
import org.ndt.student.services.BatchService;
import org.ndt.student.services.CourseService;
import org.ndt.student.services.GovtRemitsService;
import org.ndt.student.services.PartnerService;
import org.ndt.student.services.RoomanRemitsService;
import org.ndt.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadManagerUtil 
{
	@Autowired
	private StudentService studentService ;
		
	@Autowired
	private BatchService batchService;
		   
	@Autowired
	private CourseService courseService;
	  
	@Autowired
	private AccountService accountService;
		  
	@Autowired
	private AssessmentResultService assessmentResultService;
		
	@Autowired
	private PartnerService partnerService;
		
	@Autowired
	private RoomanRemitsService roomanRemitsService;
	
	@Autowired
	private GovtRemitsService govtRemitsService;
	
	private static final Logger logger = Logger.getLogger(UploadManagerUtil.class);
	
	public void uploadStudentDetails(MultipartFile file)
	{		
		
		Workbook workbook = null;
		Sheet spreadsheet = null;
		 
		String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
		if (lowerCaseFileName.endsWith(".xlsx")) 
		{
		   	try 
			{
		   		XSSFWorkbook workbook1 = new XSSFWorkbook(file.getInputStream());
		   		spreadsheet = workbook1.getSheetAt(0);
		   	}
			catch(Exception e)
			{
			   	logger.debug("Exception: " +e.getMessage());
			    throw new MultipartException("Constraints Voilated");
		    }
		}
		else if(lowerCaseFileName.endsWith(".xls")) 
		{
		    try 
		    {
		    	workbook = new HSSFWorkbook(file.getInputStream());
			    spreadsheet = workbook.getSheet("mahesh");
		    }
			catch(Exception e)
			{
				logger.debug("Exception: " +e.getMessage());
		        throw new MultipartException("Constraints Voilated");
		    }
		}
		
		Iterator<Row> rowIterator = spreadsheet.iterator();
		while (rowIterator.hasNext()) 
		{
			
			StringBuffer sb = new StringBuffer();
			Row row = (Row) rowIterator.next();				// iterate each row
			if(row.getRowNum() > 0) 						// ignore first header row 
			{ 
				Iterator<Cell> cellIterator = row.cellIterator();				
				while (cellIterator.hasNext()) 
				{
					Cell cell = (Cell) cellIterator.next();	//iterate each cell in a row
					cell.setCellType(1);					// 1 is string type/ general
					sb.append(cell);
					sb.append("~");							// append single quote instead of comma	
					//logger.debug("Student :"+ sb.toString());
				}				
				try
				{
					DataProcessManager processManager = new DataProcessManager();
					GovtRemits govtRemits  = processManager.studentDataProcessor(sb.toString());
					logger.debug("Student :" +govtRemits);
					logger.debug("Batch :" +govtRemits.getStudents());
					sb.delete(0, sb.length());   // after processing each row remove all the data from buffer  
					if( govtRemits != null )
					{
							//studentService.uploadStudentDetails(student);
							 govtRemitsService.uploadGovtRemitsDetails(govtRemits);
							 logger.debug(" Govt Remits :"+govtRemits.toString());
							 
					
					}        
				}
				catch(NullPointerException npe)
				{
					//npe.printStackTrace();
					logger.debug("No such records found to be insert.....");
				}	
			}
			else
			{
				logger.debug("first row is header row........ ");
			}
		}
	}
	
	
	public void uploadRemitsDetails(MultipartFile file)
	{		
		Workbook workbook = null;
		Sheet spreadsheet = null;
		 
		String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
		if (lowerCaseFileName.endsWith(".xlsx")) 
		{
		   	try 
			{
		   		XSSFWorkbook workbook1 = new XSSFWorkbook(file.getInputStream());
		   		spreadsheet = workbook1.getSheetAt(0);
		   	}
			catch(Exception e)
			{
			   	logger.debug("Exception: " +e.getMessage());
			    throw new MultipartException("Constraints Voilated");
		    }
		}
		else if(lowerCaseFileName.endsWith(".xls")) 
		{
		    try 
		    {
		    	workbook = new HSSFWorkbook(file.getInputStream());
			    spreadsheet = workbook.getSheet("mahesh");
		    }
			catch(Exception e)
			{
				logger.debug("Exception: " +e.getMessage());
		        throw new MultipartException("Constraints Voilated");
		    }
		}
		
		Iterator<Row> rowIterator = spreadsheet.iterator();
		while (rowIterator.hasNext()) 
		{
			StringBuffer sb = new StringBuffer();
			Row row = (Row) rowIterator.next();				// iterate each row
			if(row.getRowNum() > 0) 						// ignore first header row 
			{ 
				Iterator<Cell> cellIterator = row.cellIterator();				
				while (cellIterator.hasNext()) 
				{
					Cell cell = (Cell) cellIterator.next();	//iterate each cell in a row
					cell.setCellType(1);					// 1 is string type/ general
					sb.append(cell);
					sb.append("~");							// append single quote instead of comma	
					//logger.debug("Student :"+ sb.toString());
				}				
				try
				{
					DataProcessManager processManager = new DataProcessManager();
					RoomanRemits roomanRemits = processManager.remitsDataProcessor(sb.toString());
					logger.debug("Student :" +roomanRemits);
					sb.delete(0, sb.length());   // after processing each row remove all the data from buffer  
					if( roomanRemits != null )
					{
						roomanRemitsService.uploadRoomanRemitsDetails(roomanRemits);
					}        
				}
				catch(NullPointerException npe)
				{
					//npe.printStackTrace();
					logger.debug("No such records found to be insert.....");
				}	
			}
			else
			{
				logger.debug("first row is header row........ ");
			}
		}
	}
}
