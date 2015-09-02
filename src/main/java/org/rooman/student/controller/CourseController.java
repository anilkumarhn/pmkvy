package org.rooman.student.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Course;
import org.rooman.student.entity.Partner;
import org.rooman.student.services.CourseService;
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
@SessionAttributes({"sectorName","courseID","psectorName","pcourseID"})
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping( value="/updatesector.html", method = RequestMethod.POST)
	public ModelAndView updateSectorInfo(@ModelAttribute("course") Course course, Model model, HttpServletRequest request)
	{
		if(course != null)
		{
			courseService.updateCourseInfo(course);
			HttpSession session = request.getSession();
			String partnerId = (String) session.getAttribute("PartnerID");
			Partner partnerfromDb = partnerService.getPartnerById(partnerId);
			Set<Course> courses = partnerfromDb.getCourses();
			model.addAttribute("CourseList", courses);
		}
		else
		{
			model.addAttribute("STATUS_MSG","COURSE ID IS NULL");
			return new ModelAndView("rooman", "command", model);
		}
		return new ModelAndView("sector", "command", model);
	}
	
	@RequestMapping( value="/batchinfo.html", method = RequestMethod.POST)
	public ModelAndView showBatchInfo(@RequestParam("courseID") String courseID, @RequestParam("sectorName") String sectorName, Model model)
	{
		if(!courseID.isEmpty())
		{
			Course course = courseService.getCourseById(courseID);
			if(course != null)
			{
				Set<Batch> batchs = course.getBatches();
				if( batchs != null )
				{
					 model.addAttribute("courseID", courseID);
					 model.addAttribute("sectorName",sectorName);
					 model.addAttribute("BatchList", batchs);
				}
				else
				{
					model.addAttribute("STATUS_MSG","NO BATCHES FOUND FOR THIS COURSE");
					return  new ModelAndView("sector", "command", model);
				}
			}
		}
		else
		{
			model.addAttribute("STATUS_MSG","COURSE ID IS NULL");
			return new ModelAndView("sector", "command", model);
		}
		return  new ModelAndView("batch", "command", model);
	}
	
	
	@RequestMapping( value="/partnerbatches.html", method = RequestMethod.POST)
	public ModelAndView showPartnerBatchInfo(@RequestParam("courseID") String courseID, @RequestParam("sectorName") String sectorName, Model model)
	{
		if(!courseID.isEmpty())
		{
			Course course = courseService.getCourseById(courseID);
			if(course != null)
			{
				Set<Batch> batchs = course.getBatches();
				if( batchs != null )
				{
					 model.addAttribute("pcourseID", courseID);
					 model.addAttribute("psectorName",sectorName);
					 model.addAttribute("BatchList", batchs); 
				}
				else
				{
					model.addAttribute("STATUS_MSG","NO BATCHES FOUND FOR THIS COURSE");
					return  new ModelAndView("partnerbatches", "command", model);
				}
			}
		}
		else
		{
			model.addAttribute("STATUS_MSG","COURSE ID IS NULL");
			return new ModelAndView("partnerbatches", "command", model);
		}
		return  new ModelAndView("partnerbatches", "command", model);
	}

}
