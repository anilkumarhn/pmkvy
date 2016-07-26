package org.ict.crudex.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.ict.crudex.entity.Address;
import org.ict.crudex.entity.Department;
import org.ict.crudex.entity.Designation;
import org.ict.crudex.entity.Employee;
import org.ict.crudex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public ModelAndView showForm(ModelMap map) {
		List<Employee> list = employeeService.getEmployeeList();
		map.addAttribute("employeeList", list);
		return new ModelAndView("welcome", "command",map);
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public ModelAndView showCreateForm() {
		return new ModelAndView("create", "command", new Employee());
	}
	
	@RequestMapping(value="/saverecord.do", method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute Employee employee, ModelMap map, HttpServletRequest request) {
		
		if(employee.getIsActive() == null) {
			employee.setIsActive("off");
		}
		ModelAndView mv= null;
		Set<Address> address = new HashSet<Address>();
		address.add(new Address(request.getParameter("primaryAddress"), request.getParameter("corrsAddress")));
		employee.setAddress(address);
		employee.setDepartment(new Department(request.getParameter("department")));
		employee.setDesignation(new Designation(request.getParameter("designation")));
		long statusFlag = employeeService.createEmloyee(employee);
		if(statusFlag >=1L){
			map.addAttribute("statusFlag", "Employee Record Created Sussessfully");
			mv =  new ModelAndView("welcome", "command", map);
		} else {
			
			map.addAttribute("statusFlag", "Employee Record Creation Failed....!!!");
			mv =  new ModelAndView("welcome", "command", map);
		}
		List<Employee> list = employeeService.getEmployeeList();
		map.addAttribute("employeeList", list);
		return mv;
	}
	
	@RequestMapping(value="/showupdateform.do", method=RequestMethod.POST)
	public ModelAndView showUpdateForm(@RequestParam("empId") String empId, ModelMap map) {
		
		ModelAndView mv = null;
		System.out.println("Emp Id: "+ empId);
		Employee employee = employeeService.getEmployeeById(Long.parseLong(empId));
		if(employee != null) {
			System.out.println("Employee Record Found For EmpId: "+ empId);
			System.out.println("Employee Record: "+ employee);
				Set<Address> address = new HashSet<Address>();
				address.addAll(employee.getAddress());
				Address addr = null;
				for(Address s: address){
					addr = s;
				}
				
				Designation designation = employee.getDesignation();
				Department department = employee.getDepartment();
				map.addAttribute("addressObj", addr);
				map.addAttribute("designationObj", designation);
				map.addAttribute("departmentObj", department);
				map.addAttribute("employeeObj", employee);
				mv = new ModelAndView("update", "command", map);
		} else {
			System.out.println("No Such Record Found For EmpId: "+ empId);
				mv = new ModelAndView("welcome", "command", map);
		}
		return mv;
	}
	
	@RequestMapping(value="/updateEmployee.do", method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee,
			ModelMap map, HttpServletRequest request, ModelAndView mv) {
	
		if(employee.getIsActive() == null) {
			employee.setIsActive("off");
		}
	
		List<Employee> list = null;
		
		Set<Address> address = new HashSet<Address>();
		address.add(new Address(Long.valueOf(request.getParameter("addressId")),request.getParameter("primaryAddress"), 
				request.getParameter("corrsAddress")));
		employee.setAddress(address);
		
		employee.setDepartment(new Department(Long.valueOf(request.getParameter("deptId")),request.getParameter("department")));
		employee.setDesignation(new Designation(Long.valueOf(request.getParameter("desgId")),  request.getParameter("designation")));

		System.out.println("Employee After Setting Address, Designation & Department:"+employee);

		String statusFlag = employeeService.updateEmployee(employee);
		list = employeeService.getEmployeeList();
		//map.addAttribute("statusFlag", "Employee Record Updation Failed....!!!");
		map.addAttribute("employeeList", list);
		return  new ModelAndView("welcome", "command", map);
	}
	
}
