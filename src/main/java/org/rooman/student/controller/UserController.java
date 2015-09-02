package org.rooman.student.controller;

import org.apache.log4j.Logger;
import org.rooman.student.entity.User;
import org.rooman.student.services.UserService;
import org.rooman.student.util.EncryptionDecryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
    private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping( value = "/create-user-account.html", method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws Exception
	{
		String encPwd = EncryptionDecryptionHelper.encrypt(user.getPassword());
		user.setPassword(encPwd);
		userService.createUser(user);
		model.addAttribute("userList", userService.getAllUsers());
		ModelAndView mv = new ModelAndView("manage-user-account","command",model);  
		return mv; 
	}
	

	@RequestMapping(value="/show-user-account.html", method = RequestMethod.POST)
	public ModelAndView getUsersList(@ModelAttribute("user") User user ,BindingResult bindingResult ,Model model)
	{
		model.addAttribute("userList", userService.getAllUsers());
		ModelAndView mv = new ModelAndView("manage-user-account","command",model);  
		return mv;  
	}
	
	@RequestMapping( value = "/update-user-account.html", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws Exception
	{
		userService.updateUser(user);
		model.addAttribute("userList", userService.getAllUsers());
		ModelAndView mv = new ModelAndView("manage-user-account","command",model);  
		return mv; 
	}
	
	@RequestMapping( value = "/reset-user-password.html", method=RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws Exception
	{
		String encPwd = EncryptionDecryptionHelper.encrypt(user.getPassword());
		user.setPassword(encPwd);
		userService.updateUser(user);
		model.addAttribute("userList", userService.getAllUsers());
		ModelAndView mv = new ModelAndView("manage-user-account","command",model);  
		return mv; 
	}
		
	@RequestMapping( value = "/show-my-profile.html", method=RequestMethod.GET)
	public ModelAndView showMyProfile(@RequestParam("userName") String userName, Model model)throws Exception
	{
		User user = null;
		if(!userName.isEmpty())
		{
			user = userService.getMyProfile(userName);
			if( user != null )
			{
				String decPwd = EncryptionDecryptionHelper.decrypt(user.getPassword());
				user.setPassword(decPwd);
				model.addAttribute("MY_PROFILE",user);
			}
			else
			{
				logger.debug("user not found.....");
			}
		}
		return new ModelAndView("my-profile","command",model);
	}
	
	@RequestMapping( value = "/update-my-profile.html")
	public ModelAndView updateMyProfile(@ModelAttribute("user") User user, BindingResult bindingResult, Model model)throws Exception
	{
		if( ((user.getPassword().length()>=6) && (user.getPassword().length()<=12)) && ((user.getFirstName().length()>=3)&&(user.getFirstName().length()<=25)) && ((user.getLastName().length()>=3)&&(user.getLastName().length()<=25)))
		{
			String encPwd = EncryptionDecryptionHelper.encrypt(user.getPassword());
			user.setPassword(encPwd);
			userService.updateUser(user);
			User updatedUser = userService.getMyProfile(user.getUserName());
			String decPwd = EncryptionDecryptionHelper.decrypt(updatedUser.getPassword());
			user.setPassword(decPwd);
			model.addAttribute("MY_PROFILE",user);
			model.addAttribute("SUCCESS_MSG","YES");
		}
		else
		{
			user = userService.getMyProfile(user.getUserName());
			if( user != null )
			{
				String decPwd = EncryptionDecryptionHelper.decrypt(user.getPassword());
				user.setPassword(decPwd);
				model.addAttribute("MY_PROFILE",user);
				model.addAttribute("SUCCESS_MSG","NO");
			}
			else
			{
				logger.debug("user not found.....");
			}
		}
		return new ModelAndView("my-profile","command",model);  
	}
}
