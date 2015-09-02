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
import org.rooman.student.entity.Partner;
import org.springframework.web.servlet.view.document.AbstractExcelView;


public class PartnerListReport extends AbstractExcelView 
{

	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		List<Partner> partnerList = (List<Partner>) model.get("partnerList");
		HSSFSheet sheet = workbook.createSheet("partners");
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
		
		header.createCell(0).setCellValue("PartnerId");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("PartnerName");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("Address");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("ContactNo");
		header.getCell(3).setCellStyle(style);
		
		header.createCell(4).setCellValue("Email");
		header.getCell(4).setCellStyle(style);
		
		header.createCell(5).setCellValue("PanNo");
		header.getCell(5).setCellStyle(style);
		
		header.createCell(6).setCellValue("ContactPerson");
		header.getCell(6).setCellStyle(style);
		
		header.createCell(7).setCellValue("Mou Signed");
		header.getCell(7).setCellStyle(style);
		
		header.createCell(8).setCellValue("Tds");
		header.getCell(8).setCellStyle(style);
		
		header.createCell(9).setCellValue("Share");
		header.getCell(9).setCellStyle(style);
		
		// create data rows
		int rowCount = 1;
		for (Partner p : partnerList) 
		{
			HSSFRow row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(p.getPartnerID());
			row.createCell(1).setCellValue(p.getPartnerName());
			row.createCell(2).setCellValue(p.getAddress());
			row.createCell(3).setCellValue(p.getContactNumber());
			row.createCell(4).setCellValue(p.getEmailID());
			row.createCell(5).setCellValue(p.getPanNumber());
			row.createCell(6).setCellValue(p.getContactPerson());
			row.createCell(7).setCellValue(p.getMouSigned());
			row.createCell(8).setCellValue(p.getTds());
			row.createCell(9).setCellValue(p.getPartnerShare());
		}
	}
}
