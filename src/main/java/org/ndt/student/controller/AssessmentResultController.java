package org.ndt.student.controller;

import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.ndt.student.services.AssessmentResultService;
import org.ndt.student.services.GovtRemitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssessmentResultController 
{
	@Autowired
	private AssessmentResultService assessmentResultService;
	
	@Autowired
	private GovtRemitsService govtRemitsService;
	
	 @RequestMapping(value = "editstudassmt",method=RequestMethod.POST)
	 public ModelAndView showEditStudent(@ModelAttribute("assessmentResult") AssessmentResult assessmentResult ,Student student,Model model)
	 {
		 String batchID=null;
		 System.out.println(student);
		 System.out.println("Welcome");
		 System.out.println(assessmentResult);
		 assessmentResultService.editAssessmentResult(student,assessmentResult);
		 model.addAttribute("govtRemitsList", govtRemitsService.getAllStudentList(batchID));
		 return new ModelAndView("student","command",model);
	 }
}
