package org.rooman.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rooman.student.entity.Batch;
import org.rooman.student.entity.Student;
import org.rooman.student.services.BatchService;
import org.rooman.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportGeneratorController
{
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/getBatchByTestStatus", method = RequestMethod.POST)
	public ModelAndView downloadBatchByTestStatusExcel(@ModelAttribute("testStatus") String testStatus,HttpServletRequest request, HttpServletResponse response) 
	{
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=Batches.xls");
		List<Batch> batchList = batchService.getBatchByTestStatus(testStatus);

		return new ModelAndView("excelViewBatchList", "batchList", batchList);
	}
	
	@RequestMapping(value = "/getStudentByAadharVal", method = RequestMethod.POST)
	public ModelAndView downloadStudentByAadharValExcel(@ModelAttribute("aadharVal") String aadharVal,HttpServletRequest request, HttpServletResponse response) 
	{
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=Student.xls");
		List<Student> StudentList = studentService.getStudentByAadharVal(aadharVal);
		return new ModelAndView("excelViewStudentList", "studentList", StudentList);
	}
	/*	
	@RequestMapping(value = "/getStudentByBatch", method = RequestMethod.POST)
	public ModelAndView downloadgetStudentByBatchExcel(@ModelAttribute("studentByBatch") String studentByBatch, HttpServletRequest request, HttpServletResponse response) 
	{
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=StudentList.xls");
		List<Student> StudentList = studentService.getStudentByBatch(studentByBatch);
		return new ModelAndView("excelViewStudentList", "studentList", StudentList);
	}
*/
}
