package org.rooman.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.rooman.student.entity.Account;
import org.rooman.student.entity.Student;
import org.rooman.student.services.AccountService;
import org.rooman.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private StudentService studentService;
	
	private static final Logger logger = Logger.getLogger(AccountController.class);
	
	@RequestMapping( value = "/updateAccount.html", method = RequestMethod.POST )
	public ModelAndView updateAccountInfo(@ModelAttribute("account") Account account, Model model , HttpServletRequest request)
	{
		if(account != null)
		{
			HttpSession session = request.getSession();
			String candidateId = (String) session.getAttribute("candidateID"); 
			
			boolean updated = accountService.updateAccountInfo(account);
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
					logger.info("CANDIDATE ID IS NULL, SESSION WAS CLOSED");
					if(session != null)
					{
						session.removeAttribute("USER_NAME");
						session.removeAttribute("USER_ROLE");
						session.removeAttribute("PartnerName");
						session.removeAttribute("PartnerID");
						session.removeAttribute("candidateID");
						session.removeAttribute("batchID");
					}
					session.invalidate();
					return new ModelAndView("login-form", "command", model);
				}
			}
			else
			{
				logger.error("ACCOUNT UPDATION FAILED");
				Student student = studentService.getStudentById(candidateId);
				model.addAttribute("AccountInfo",student.getAccount());
				model.addAttribute("AssessmentFees",student.getAssessmentFee());
				model.addAttribute("AssessmentResults",student.getAssessmentResult());
				model.addAttribute("GovtRemits", student.getGovtRemits());
			}
		}
		else
		{
			logger.info("ACCOUNT OBJECT IS NULL");
		}
		return new ModelAndView("studentinfo", "command", model);
	}
}
