package org.rooman.student.controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Course;
import org.rooman.student.entity.Partner;
import org.rooman.student.entity.Student;
import org.rooman.student.services.BatchService;
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
@SessionAttributes({"batchID","pbatchID"})
public class BatchController 
{
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping( value="/updatebatch.html", method = RequestMethod.POST)
	public ModelAndView updateBatchInfo(@ModelAttribute("batch") Batch batch, Model model, HttpServletRequest request)
	{
		if(batch != null)
		{
			batchService.updateBatchInfo(batch);
			HttpSession session = request.getSession();
			String partnerId = (String) session.getAttribute("PartnerID");
			Partner partnerfromDb = partnerService.getPartnerById(partnerId);
			Set<Course> courses = partnerfromDb.getCourses();
			Course courseFromDb = null;
			Iterator<Course> iterator = courses.iterator();
			while (iterator.hasNext()) 
			{
				courseFromDb = (Course) iterator.next();
			}
			Set<Batch> batchs = courseFromDb.getBatches();
			model.addAttribute("BatchList", batchs);
		}
		else
		{
			return  new ModelAndView("batch", "command", model);
		}
		return  new ModelAndView("batch", "command", model);
	}

	@RequestMapping( value="/studentinfo.html", method = RequestMethod.POST)
	public ModelAndView getStudentList(@RequestParam("batchID") String batchID, Model model)
	{
		if(!batchID.isEmpty())
		{
			Batch batch = batchService.getBatchById(batchID);
			Set<Student> students = batch.getStudents();
			model.addAttribute("batchID", batchID);
			model.addAttribute("StudentList", students);
		}
		else
		{
			return  new ModelAndView("batch", "command", model);
		}
		return  new ModelAndView("student", "command", model);
	}


	@RequestMapping( value="/partnerstudents.html", method = RequestMethod.POST)
	public ModelAndView getPartnerStudents(@RequestParam("batchID") String batchID, Model model)
	{
		if(!batchID.isEmpty())
		{
			Batch batch = batchService.getBatchById(batchID);
			Set<Student> students = batch.getStudents();
			model.addAttribute("pbatchID", batchID);
			model.addAttribute("StudentList", students);
		}
		else
		{
			return  new ModelAndView("batch", "command", model);
		}
		return  new ModelAndView("partnerstudents", "command", model);
	}

}
