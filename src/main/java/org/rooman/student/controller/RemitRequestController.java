package org.rooman.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rooman.student.entity.GovtRemits;
import org.rooman.student.entity.Partner;
import org.rooman.student.entity.RemitRequest;
import org.rooman.student.services.GovtRemitsService;
import org.rooman.student.services.RemitRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RemitRequestController 
{
	@Autowired
	private GovtRemitsService govtRemitsService;
	
	@Autowired
	private RemitRequestService remitRequestService;
	
	@RequestMapping( value = "/remitrequest.html" , method = RequestMethod.POST)
	public ModelAndView postRequestForRemit(String studentId, @RequestParam("transactionID") String transactionID, Model model, HttpServletRequest request )
	{
		GovtRemits remits = govtRemitsService.getGovtRemit(transactionID);
		//if((!remits.getTransactionID().isEmpty()) && (!remits.getTransactionDate().isEmpty()) && (!remits.getChequeNo().isEmpty()) && (!remits.getCreditDebit().isEmpty()) && (remits.getAmountINR() != 0))
		if(remits != null)
		{
			boolean available = remitRequestService.getRemitById(studentId);
			if(available == true)
			{
				model.addAttribute("STATUS_MSG", "found");
			}
			else
			{ 
				HttpSession session = request.getSession();
				Partner partner = (Partner)session.getAttribute("PARTNER_INFO");
				RemitRequest remitRequest = new RemitRequest(studentId, partner.getPartnerID());
				boolean status = remitRequestService.postRemitRequest(remitRequest);
				if(status == true)
				{
					model.addAttribute("STATUS_MSG", "success");
				}
				else
				{
					model.addAttribute("STATUS_MSG", "failed");
				}
			}
		}
		else
		{
			model.addAttribute("STATUS_MSG", "not eligible  ");
		}
		return new ModelAndView("partnerstudentinfo", "command", model);
	}
}
