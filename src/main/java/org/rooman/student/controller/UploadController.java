package org.rooman.student.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.rooman.student.util.UploadManagerUtil;
import org.rooman.student.util.ValidateUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
   
   @RequestMapping(value = "/show-data-upload-form.html", method = RequestMethod.POST)
   public ModelAndView showDataUploadForm(Model model) 
   {  
       return new ModelAndView("dataupload-form","command",model);  
   }
   
   @RequestMapping(value = "/upload-master.html", method = RequestMethod.POST)
   public ModelAndView uploadMasterData(@RequestParam("file") MultipartFile file, Model model)throws IOException 
   {
       	if (!file.isEmpty())
       	{
       		if(ValidateUploadUtil.validateFileType(file))
       		{
       			uploadManagerUtil.uploadMasterInfo(file);
       		}
       		else
     		{
       			logger.info("invalid file type u've selected");
       		} 
        }
       	return new ModelAndView("dataupload-form", "command", model);
    }
   
   
   @RequestMapping(value = "/upload-partner.html", method = RequestMethod.POST)
   public ModelAndView uploadPartnerData(@RequestParam("file") MultipartFile file, Model model)throws IOException 
   {
       	if (!file.isEmpty())
       	{
       		if(ValidateUploadUtil.validateFileType(file))
       		{
       			uploadManagerUtil.uploadPartnerInfo(file);
       		}
       		else
     		{
       			logger.info("invalid file type u've selected");
       		} 
        }
       	return new ModelAndView("dataupload-form", "command", model);
    }
   
   @RequestMapping(value = "/partner-transfer.html", method = RequestMethod.POST)
   public ModelAndView uploadPartnerTransfer(@RequestParam("file") MultipartFile file, Model model)throws IOException 
   {
       	if (!file.isEmpty())
       	{
       		if(ValidateUploadUtil.validateFileType(file))
       		{
       			uploadManagerUtil.uploadPartnerTransfer(file);
       		}
       		else
     		{
       			logger.info("invalid file type u've selected");
       		} 
        }
       	return new ModelAndView("dataupload-form", "command", model);
    }
     
}
    