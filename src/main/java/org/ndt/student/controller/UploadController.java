package org.ndt.student.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.ndt.student.util.UploadManagerUtil;
import org.ndt.student.util.ValidateUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController
{
   public static final Logger logger = Logger.getLogger(UploadController.class);
    
   @Autowired
   private UploadManagerUtil uploadManagerUtil;
   
   @RequestMapping(value = "/upload-student-partner-details.html", method = RequestMethod.POST)
   public String handleFormUpload(@RequestParam("file") MultipartFile file)throws IOException 
   {
       	if (!file.isEmpty())
       	{
       		if(ValidateUploadUtil.validateFileType(file))
       		{
       			uploadManagerUtil.uploadStudentDetails(file);
       			uploadManagerUtil.uploadRemitsDetails(file);
       		}
       		else
     		{
       			logger.info("invalid file type u've selected");
       		} 
        }
        return "redirect:/";
    }
    
    @RequestMapping("/contact")  
    public ModelAndView showContacts() 
    {  
        return new ModelAndView("contact");  
    } 
}
    


