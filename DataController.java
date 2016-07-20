package org.mahesh.controller;

import org.mahesh.entity.Employee;
import org.mahesh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;

	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public ModelAndView getForm(@ModelAttribute Employee employee) {
		return new ModelAndView("form","command",new Employee());
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute Employee employee, ModelMap modelMap) {
		dataService.insertRow(employee);
		return new ModelAndView("list","command", modelMap);
	}
	
	/*
	@RequestMapping(value="list.do", method=RequestMethod.POST)
	public ModelAndView getList() {
		List<Employee> employeeList = dataService.getList();
		return new ModelAndView("list","employeeList",employeeList);
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="edit.do", method=RequestMethod.POST)
	public ModelAndView editUser(@RequestParam int id,@ModelAttribute Employee employee) {
		Employee employeeObject = dataService.getRowById(id);
		return new ModelAndView("edit","employeeObject",employeeObject);
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute Employee employee) {
		dataService.updateRow(employee);
		return new ModelAndView("redirect:list");
	}*/
}
