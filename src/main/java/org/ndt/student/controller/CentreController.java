package org.ndt.student.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.ndt.student.services.CentreService;
import org.ndt.student.util.UploadManagerUtil;
import org.ndt.student.util.ValidateUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CentreController 
{
	private static final Logger logger = Logger.getLogger(CentreController.class);
	
	@Autowired
	private CentreService centreService;
	
	@RequestMapping(value = "/rooman.html", method = RequestMethod.GET)
	public ModelAndView getSectorCentreList(Model model) 
	{
		model.addAttribute("CentreList", centreService.getAllCentres());
		model.addAttribute("SectorList", centreService.getAllSectors());
		return new ModelAndView("rooman","command",model);
	}
		
	@Autowired
	private UploadManagerUtil uploadManagerUtil;
		
	@RequestMapping(value = "/upload-centre-details.html", method = RequestMethod.POST)
	public String handleSectorUpload( @RequestParam("file") MultipartFile file)  throws IOException
	{
		if(!file.isEmpty())
		{
			if(ValidateUploadUtil.validateFileType(file))
			{
				uploadManagerUtil.uploadCentreDetails(file);
			}
			else
			{
				logger.debug("invalid file type u've selected");
			}
		}
		return "redirect:/";
	}
}
