package org.ndt.student.db;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class AccountDaoImpl implements AccountDao
{

	@Autowired
	@Resource( name = "sessionFactory")
	public SessionFactory sessionFactory;
	
	public static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void uploadAccountInfo(MultipartFile file) 
	{
		Workbook workbook = null;
		Sheet spreadsheet = null;
		Row entry = null;
		
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
			    	e.printStackTrace();
			        throw new MultipartException("Constraints Violated");
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
				e.printStackTrace();
		        throw new MultipartException("Constraints Violated");
		    }
		}      
		
		 for(int i=1; i<=spreadsheet.getLastRowNum(); i++)
	      {
	    	  entry=spreadsheet.getRow(i);
	    	  Session session = sessionFactory.openSession();
              Transaction tx = session.beginTransaction();
              try
	 		  {
	 		     tx.commit();
	 			 session.flush();
	    	  }
	 		  catch(Exception e)
	 		  {
	 		   	 if( e.getCause().getMessage().contains("Duplicate entry"))
	 		  	 {
	 		  		 // do nothing
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
	}
	
	
	public static boolean isRowEmpty(Row row) 
	{
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++)
		{
		     Cell cell = row.getCell(c);
		     if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
		     return false;
		}
	    return true;
	}
}
