package org.ndt.student.controller;

import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Student;
import org.ndt.student.services.GovtRemitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GovtRemitsController 
{
	@Autowired
	private GovtRemitsService govtRemitsService;
	
	 @RequestMapping(value = "/studentList.html",method = RequestMethod.POST)
	 public ModelAndView showAllStudentList(@RequestParam("batchID") String batchID,Model model)
	 {
		 System.out.println("Welcome "+batchID);
		 model.addAttribute("govtRemitsList", govtRemitsService.getAllStudentList(batchID));
		// model.addAttribute("assessmentResult", studentService.getAllAssessmentResult());
		 return new ModelAndView("student","command",model);
	 }
	 
	 @RequestMapping(value = "editgovtremits",method=RequestMethod.POST)
	 public ModelAndView showGovtRemits(@ModelAttribute("govtRemits") GovtRemits govtRemits ,Student student,Model model)
	 {
		 String batchID=null;
		govtRemitsService.editGovtRemits(student,govtRemits);
		 model.addAttribute("govtRemitsList", govtRemitsService.getAllStudentList(batchID));
		 return new ModelAndView("student","command",model);
	 }
}
