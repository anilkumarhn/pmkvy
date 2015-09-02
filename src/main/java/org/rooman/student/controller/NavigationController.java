package org.rooman.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.rooman.student.entity.Partner;
import org.rooman.student.entity.User;
import org.rooman.student.services.PartnerService;
import org.rooman.student.services.UserService;
import org.rooman.student.util.EncryptionDecryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"USER_NAME","PARTNER_INFO","USER_ROLE"})
public class NavigationController 
{
	private static final Logger logger = Logger.getLogger(NavigationController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping(value = "/login-form.html", method = RequestMethod.GET)
	public ModelAndView showUserAccountForm(Model model) 
	{	
		return new ModelAndView("login-form","command",model);
	}
		
	@RequestMapping(value = "/authentication.html", method = RequestMethod.POST)
	public ModelAndView userAuthenticate(@ModelAttribute("user") User user, BindingResult bindingResult, Model model)
	{
		ModelAndView mv = null;
		try
		{
			if(user.getUserName().isEmpty() || user.getPassword().isEmpty())
			{
				logger.debug("user name and password is empty..... ");
				model.addAttribute("ERROR_MSG", "NF");
				mv = new ModelAndView("login-form","command",model);
				return mv ; 
			}
			else
			{
				String encPwd = EncryptionDecryptionHelper.encrypt(user.getPassword());
				logger.debug(encPwd);
				user.setPassword(encPwd);
				User authenticatedUser = userService.authenticateUser(user);

				if(authenticatedUser == null)
				{
					logger.debug("user not foound.....");
					model.addAttribute("ERROR_MSG", "EF");
					mv = new ModelAndView("login-form","command",model);
					return mv ; 
				}
				
				if(authenticatedUser.getRole().getUserRole().equalsIgnoreCase("Super Admin"))
				{
					logger.debug("i am super admin.....");
					model.addAttribute("USER_NAME", authenticatedUser.getUserName());
					model.addAttribute("USER_ROLE", authenticatedUser.getRole().getUserRole());
					mv = new ModelAndView("contact","command",model); 
				}
				
				if(authenticatedUser.getRole().getUserRole().equalsIgnoreCase("Admin"))
				{
					logger.debug("i am admin.....");
					model.addAttribute("USER_NAME", authenticatedUser.getUserName());
					model.addAttribute("USER_ROLE", authenticatedUser.getRole().getUserRole());
					mv = new ModelAndView("contact","command",model); 
				}
				
				if(authenticatedUser.getRole().getUserRole().equalsIgnoreCase("Data Manager"))
				{
					logger.debug("i am  data manager.....");
					model.addAttribute("USER_NAME", authenticatedUser.getUserName());
					model.addAttribute("USER_ROLE", authenticatedUser.getRole().getUserRole());
					mv = new ModelAndView("contact","command",model); 
				}

				if(authenticatedUser.getRole().getUserRole().equalsIgnoreCase("Partner"))
				{
					logger.debug("i am  partner.....");
					
					Partner partner = partnerService.getPartnerByMail(user.getUserName());
					model.addAttribute("PARTNER_INFO",partner);
					model.addAttribute("USER_NAME", authenticatedUser.getUserName());
					model.addAttribute("USER_ROLE", authenticatedUser.getRole().getUserRole());
					mv = new ModelAndView("contact","command",model); 
				}
				
				if(authenticatedUser.getRole().getUserRole().equalsIgnoreCase("Account Manager"))
				{
					logger.debug("i am  account manager.....");
					model.addAttribute("USER_NAME", authenticatedUser.getUserName());
					model.addAttribute("USER_ROLE", authenticatedUser.getRole().getUserRole());
					mv = new ModelAndView("contact","command",model); 
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return mv; 
	}
	
	@RequestMapping( value="/signout.html", method = RequestMethod.GET )
	public ModelAndView signout(HttpServletRequest request, HttpServletResponse response)
	{
		//  invalidate the user and close the user session 
		HttpSession session = request.getSession(false);
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
		return new ModelAndView("login-form");
	}
}
