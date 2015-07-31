package org.ndt.student.controller;



import org.ndt.student.entity.Student;
import org.ndt.student.services.GovtRemitsService;
import org.ndt.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController
{
	 @Autowired
	 private StudentService studentService ;
	  
	 @Autowired
	 private GovtRemitsService govtRemitsService;
	
	 @RequestMapping(value = "editstudent",method=RequestMethod.POST)
	 public ModelAndView showEditStudent(@ModelAttribute("student") Student student ,Model model)
	 {	
		 String batchID=null;
		 studentService.editStudent(student);
		 model.addAttribute("govtRemitsList", govtRemitsService.getAllStudentList(batchID));
		 return new ModelAndView("student","command",model);
	 }
	 
}
