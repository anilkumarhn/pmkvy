package org.rooman.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.rooman.student.entity.AssessmentResult;
import org.rooman.student.entity.Student;
import org.rooman.student.services.AssessmentResultService;
import org.rooman.student.services.StudentService;
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
	private StudentService studentService;

	@Autowired
	private AssessmentResultService assessmentResultService;
	
	private static final Logger logger = Logger.getLogger(AssessmentResultController.class);
	
	@RequestMapping( value = "/updateassmtresult.html", method = RequestMethod.POST )
	public ModelAndView updateAssmtResultInfo(@ModelAttribute("assessmentResult") AssessmentResult assessmentResult, Model model, HttpServletRequest request)
	{
		if(assessmentResult != null)
		{
			HttpSession session = request.getSession();
			String candidateId = (String) session.getAttribute("candidateID");
			
			boolean updated = assessmentResultService.updateAssmtResultInfo(assessmentResult);
			if(updated == true)
			{
				if(!candidateId.isEmpty())
				{
					Student student = studentService.getStudentById(candidateId);
					model.addAttribute("AccountInfo",student.getAccount());
					model.addAttribute("AssessmentFees",student.getAssessmentFee());
					model.addAttribute("AssessmentResults",student.getAssessmentResult());
					model.addAttribute("GovtRemits", student.getGovtRemits());
				}
				else
				{
					logger.info("CANDIDATE ID IS NULL");
				}
			}
			else
			{
				logger.error("ASSESSMEENT RESULT UPDATION FAILED");
				Student student = studentService.getStudentById(candidateId);
				model.addAttribute("AccountInfo",student.getAccount());
				model.addAttribute("AssessmentFees",student.getAssessmentFee());
				model.addAttribute("AssessmentResults",student.getAssessmentResult());
				model.addAttribute("GovtRemits", student.getGovtRemits());
			}
		}
		else
		{
			logger.info("ASSESSMENT RESULT OBJECT IS NULL");
		}
		return new ModelAndView("studentinfo", "command", model);
	}

}
