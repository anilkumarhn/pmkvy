package org.ndt.student.controller;


import org.ndt.student.services.CentreService;
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
@SessionAttributes 
public class RoomanController {

	/*@RequestMapping(value = "/addContact", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("rooman") Contact contact, BindingResult result) {  
        //write the code here to add contact  
        return "redirect:rooman.html";  
    }  */
      
}
