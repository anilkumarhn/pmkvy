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

@Controller
public class SectorController 
{
	private static final Logger logger = Logger.getLogger(SectorController.class);
	
	@Autowired
	private UploadManagerUtil uploadManagerUtil;
	
    @RequestMapping(value = "/upload-sector-details.html", method = RequestMethod.POST)
	public String handleSectorUpload( @RequestParam("file") MultipartFile file)  throws IOException
	{
		if(!file.isEmpty())
		{
			if(ValidateUploadUtil.validateFileType(file))
			{
				uploadManagerUtil.uploadSectorDetails(file);
			}
			else
			{
				logger.debug("invalid file type u've selected");
			}
		}
		return "redirect:/";
	}
}
