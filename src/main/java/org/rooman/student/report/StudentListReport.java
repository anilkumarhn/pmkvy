package org.rooman.student.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.rooman.student.entity.Student;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class StudentListReport extends AbstractExcelView
{
	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		List<Student> studentList = (List<Student>) model.get("studentList");
		HSSFSheet sheet = workbook.createSheet("students");
		sheet.setDefaultColumnWidth(30);
		
		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		
		// create header row
		HSSFRow header = sheet.createRow(0);		
		
		header.createCell(0).setCellValue("CANDIDATE_ID");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("CANDIDATE_NAME");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("ENROLLMENT_NO");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("CONTACT_NO");
		header.getCell(3).setCellStyle(style);
		
		header.createCell(4).setCellValue("EMAIL_ID");
		header.getCell(4).setCellStyle(style);
		
		header.createCell(5).setCellValue("AADHAR_NO");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("AADHAR_NO_VALIDATED");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("ADDRESS");
		header.getCell(7).setCellStyle(style);
		// create data rows
		int rowCount = 1;
		for (Student student : studentList) 
		{
			HSSFRow row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(student.getCandidateID());
			row.createCell(1).setCellValue(student.getCandidateName());
			row.createCell(2).setCellValue(student.getEnrollmentNo());
			row.createCell(3).setCellValue(student.getContactNo());
			row.createCell(4).setCellValue(student.getEmailID());
			row.createCell(5).setCellValue(student.getAadharNo());
			row.createCell(6).setCellValue(student.getAadharValidated());
			row.createCell(7).setCellValue(student.getAddress());
		}
	}
}
