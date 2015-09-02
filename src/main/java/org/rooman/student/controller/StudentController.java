package org.rooman.student.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Student;
import org.rooman.student.services.BatchService;
import org.rooman.student.services.StudentService;
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
@SessionAttributes({"candidateID","pcandidateID"})
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BatchService batchService;
	
	@RequestMapping( value = "/student-info.html", method = RequestMethod.POST )
	public ModelAndView getStudentInfo(@RequestParam("candidateID") String candidateID, Model model)
	{
		if(!candidateID.isEmpty())
		{
			Student student = studentService.getStudentById(candidateID); 
			model.addAttribute("candidateID", candidateID);
			model.addAttribute("AccountInfo",student.getAccount());
			model.addAttribute("AssessmentFees",student.getAssessmentFee());
			model.addAttribute("AssessmentResults",student.getAssessmentResult());
			model.addAttribute("GovtRemits", student.getGovtRemits());
		}
		else
		{
			return new ModelAndView("student","command",model);
		}
		return new ModelAndView("studentinfo","command",model);
	}
	
	@RequestMapping( value = "/updatestudent.html", method = RequestMethod.POST )
	public ModelAndView updateStudentInfo(@ModelAttribute("student") Student student, Model model, HttpServletRequest request)
	{
		if(student != null)
		{
			studentService.updateStudent(student);
			HttpSession session = request.getSession();
			String batchId = (String)session.getAttribute("batchID");
			if(!batchId.isEmpty())
			{
				Batch batch = batchService.getBatchById(batchId);
				Set<Student> students = batch.getStudents();
				model.addAttribute("StudentList", students);
			}
		}
		else
		{
			return new ModelAndView("student","command",model);
		}
		return new ModelAndView("student","command",model);
	}

	@RequestMapping( value = "/partnerstudentinfo.html", method = RequestMethod.POST )
	public ModelAndView getPartnerStudentInfo(@RequestParam("candidateID") String candidateID, Model model)
	{
		if(!candidateID.isEmpty())
		{
			Student student = studentService.getStudentById(candidateID); 
			model.addAttribute("pcandidateID", candidateID);
			model.addAttribute("AccountInfo",student.getAccount());
			model.addAttribute("AssessmentFees",student.getAssessmentFee());
			model.addAttribute("AssessmentResults",student.getAssessmentResult());
			model.addAttribute("GovtRemits", student.getGovtRemits());
		}
		else
		{
			return new ModelAndView("partnerstudentinfo","command",model);
		}
		return new ModelAndView("partnerstudentinfo","command",model);
	}
	
}
