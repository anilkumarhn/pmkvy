package org.rooman.student.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.rooman.student.entity.Course;
import org.rooman.student.entity.Partner;
import org.rooman.student.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"PartnerID","PartnerName"})
public class PartnerController 
{
	private static final Logger logger = Logger.getLogger(PartnerController.class);
	
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping( value ="rooman.html", method = RequestMethod.POST)
	public ModelAndView getPartner(Model model)
	{
		return new ModelAndView("rooman","command", model);		
	}
	
	@RequestMapping( value = "/partnerinfo.html", method = RequestMethod.GET)
	public ModelAndView showPartnerInfo(Model model)
	{
		List<Partner> PartnerList = partnerService.getPartnerList();
		if(PartnerList != null)
		{
			model.addAttribute("PartnerList",PartnerList);
		}
		else
		{
			model.addAttribute("STATUS_MSG", "PARTNER NOT FOUND");
		}
		return new ModelAndView("rooman", "command", model);
	}
	
	@RequestMapping( value = "/updatepartner.html", method = RequestMethod.POST )
	public ModelAndView updatePartner(@ModelAttribute("partner") Partner partner, Model model)
	{
		boolean updatestatus = false;
		updatestatus = partnerService.updatePartnerInfo(partner);
		if(updatestatus == true)
		{
			List<Partner> PartnerList = partnerService.getPartnerList();
			if(PartnerList != null)
			{
				model.addAttribute("PartnerList",PartnerList);
			}
			else
			{
				model.addAttribute("STATUS_MSG", "PARTNER NOT FOUND");
			}
		}
		else
		{
			model.addAttribute("STATUS_MSG", "PARTNER UPDATION FAILED");
		}
		return new ModelAndView("rooman", "command", model);
	}
	
	@RequestMapping( value="/sectorinfo.html", method = RequestMethod.POST)
	public ModelAndView getSectorInfo(@RequestParam("partnerID") String partnerID, @RequestParam("partnerName") String partnerName,  Model model)
	{
		Partner partner = null;
		if(!partnerID.isEmpty())
		{
			partner = partnerService.getPartnerById(partnerID);
			if(partner != null)
			{
				Set<Course> courses = partner.getCourses();
				if( courses != null )
				{
					 model.addAttribute("PartnerID", partnerID);
					 model.addAttribute("PartnerName", partnerName);
					 model.addAttribute("CourseList", courses);
				}
				else
				{
					model.addAttribute("STATUS_MSG","NO COURSES FOUND FOR THIS PARTNER");
				}
			}
		}
		else
		{
			model.addAttribute("STATUS_MSG","PARTNER ID IS NULL");
		}
		return  new ModelAndView("sector", "command", model);
	}
	
	@RequestMapping(value = "/partnerReport.html", method = RequestMethod.POST)
	public ModelAndView downloadPartnerExcel(HttpServletRequest request, HttpServletResponse response) 
	{

		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=Partners.xls");
		List<Partner> PartnerList = partnerService.getPartnerList();
		return new ModelAndView("excelViewOfPartnerList", "partnerList", PartnerList);

	}
	
	@RequestMapping(value = "/show-report-download-form",method = RequestMethod.POST)
	public String showReportGenForm() 
	{
		return "reportsinfo";
	}

	@RequestMapping( value="/partnercourses.html", method = RequestMethod.POST)
	public ModelAndView showPartnerCourses(Model model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Partner partner = (Partner)session.getAttribute("PARTNER_INFO");
		if(partner != null)
		{
			Set<Course> courses = partner.getCourses();
			model.addAttribute("courseList", courses);
		}
		else
		{
			logger.info("COURSES NOT FOUND");
		}
		return  new ModelAndView("partnercourses", "command", model);
	}
	
	@RequestMapping( value="/partnerprofile.html", method = RequestMethod.GET)
	public ModelAndView showPartnerProfile(Model model)
	{
		return  new ModelAndView("partnerprofile", "command", model);
	}

}
