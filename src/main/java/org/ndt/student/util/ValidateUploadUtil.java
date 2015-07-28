package org.ndt.student.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class ValidateUploadUtil 
{
       private static Logger logger = Logger.getLogger(ValidateUploadUtil.class);
	   public static boolean validateFileType(MultipartFile file)
	   {
		   
		   logger.debug("File Type :"+ file.getOriginalFilename());
		   
	        //if(file.getContentType().equals("application/vnd.ms-excel") || file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	       if(file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx")) 
		   {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
	   }
}
