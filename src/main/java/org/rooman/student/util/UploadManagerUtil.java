package org.rooman.student.util;


import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.rooman.student.entity.Partner;
import org.rooman.student.entity.PartnerTransfer;
import org.rooman.student.services.PartnerService;
import org.rooman.student.services.PartnerTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadManagerUtil 
{
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	DataProcessManager dataProcessManager;
	
	@Autowired
	private PartnerTransferService partnerTransferService;
	
	private static final Logger logger = Logger.getLogger(UploadManagerUtil.class);
	private HashMap<String, Partner> partnerMap = new HashMap<String,Partner>();
	public void uploadMasterInfo(MultipartFile file)
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
			    spreadsheet = workbook.getSheet("masterdata");
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
			StringBuffer sb = new StringBuffer(5000);
			Row row = (Row) rowIterator.next();				// iterate each row
			if(row.getRowNum() > 0) 						// ignore first header row 
			{ 
				Iterator<Cell> cellIterator = row.cellIterator();				
				while (cellIterator.hasNext()) 
				{
					Cell cell = (Cell) cellIterator.next();	//iterate each cell in a row
					cell.setCellType(1);					// 1 is string type/ general
					sb.append(cell);
					sb.append("~");							// append tidle quote instead of comma	
				}				
				try
				{
					String str = sb.toString();
					String[] data = str.split("~");
					
					if(data.length == 0 )
					{
						break; // break while loop
					}
					System.out.println(data);
					String partnerID = data[35];
					logger.info("PARTNER ID :"+ partnerID);
					Partner partner = partnerMap.get(partnerID);
					partner = dataProcessManager.masterDataProcessor(data, partner);
					partnerMap.put(partnerID, partner);
     
				}
				catch(NullPointerException npe)
				{
					logger.debug("NO SUCH RECORDS FOUND TO INSERT.....");
				}	
			}
			else
			{
				logger.debug("FIRST ROW IS HEADER ROW.....");
			}
		}
		partnerService.bulkUploadPartnerDeatils(partnerMap.values());
	}
	
	
	public void uploadPartnerInfo(MultipartFile file)
	{		
		Workbook workbook = null;
		Sheet spreadsheet = null;
		 
		String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
		if (lowerCaseFileName.endsWith(".xlsx")) 
		{
		   	try 
			{
		   		XSSFWorkbook workbook1 = new XSSFWorkbook(file.getInputStream());
		   		spreadsheet = workbook1.getSheetAt(2);
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
			    spreadsheet = workbook.getSheet("partner");
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
				}				
				try
				{
					Partner	partner  = dataProcessManager.partnerDataProcessor(sb.toString());
					sb.delete(0, sb.length());   // after processing each row remove all the data from buffer  
					if( partner != null )
					{
						partnerService.updatePartnerInfo(partner);
					}        
				}
				catch(NullPointerException npe)
				{
					//npe.printStackTrace();
					logger.debug("NO SUCH RECORDS FOUND TO INSERT.....");
				}	
			}
			else
			{
				logger.debug("FIRST ROW IS HEADER ROW.....");
			}
		}
	}


	public void uploadPartnerTransfer(MultipartFile file)
	{		
		Workbook workbook = null;
		Sheet spreadsheet = null;
		 
		String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
		if (lowerCaseFileName.endsWith(".xlsx")) 
		{
		   	try 
			{
		   		XSSFWorkbook workbook1 = new XSSFWorkbook(file.getInputStream());
		   		spreadsheet = workbook1.getSheetAt(1);
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
			    spreadsheet = workbook.getSheet("partnertransfer");
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
				}				
				try
				{
					
					PartnerTransfer ptransfer  = dataProcessManager.partnerTransferDataProcessor(sb.toString());
					sb.delete(0, sb.length());   // after processing each row remove all the data from buffer  
					if( ptransfer != null )
					{
						boolean status = partnerTransferService.getTransactionByIdForUpload(ptransfer.getTransactionId());
						if(status == false)
						{
							partnerTransferService.uploadPartnerTransfer(ptransfer);
						}					
					}        
				}
				catch(NullPointerException npe)
				{
					//npe.printStackTrace();
					logger.debug("NO SUCH RECORDS FOUND TO INSERT.....");
				}	
			}
			else
			{
				logger.debug("FIRST ROW IS HEADER ROW.....");
			}
		}
	}
}
