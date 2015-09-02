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
import org.rooman.student.entity.Batch;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class BatchListReport extends AbstractExcelView
{
	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		List<Batch> batchList = (List<Batch>) model.get("batchList");
		HSSFSheet sheet = workbook.createSheet("batches");
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
		
		header.createCell(0).setCellValue("BATCH_ID");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("BATCH_SIZE");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("START_DATE");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("END_DATE");
		header.getCell(3).setCellStyle(style);
		
		header.createCell(4).setCellValue("TEST_DATE");
		header.getCell(4).setCellStyle(style);
		
		header.createCell(5).setCellValue("TEST_CONDUCTED");
		header.getCell(5).setCellStyle(style);
		
		// create data rows
		int rowCount = 1;
		for (Batch batch : batchList) 
		{
			HSSFRow row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(batch.getBatchID());
			row.createCell(1).setCellValue(batch.getBatchSize());
			row.createCell(2).setCellValue(batch.getStartDate());
			row.createCell(3).setCellValue(batch.getEndDate());
			row.createCell(4).setCellValue(batch.getTestDate());
			row.createCell(5).setCellValue(batch.getTestConducted());
			
		}
	}


}
