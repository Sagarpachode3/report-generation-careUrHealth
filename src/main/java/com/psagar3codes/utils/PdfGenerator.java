package com.psagar3codes.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.psagar3codes.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void generatePdf(HttpServletResponse response, List<CitizenPlan> plans,File file) throws Exception {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream()); 
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		Paragraph paragraph = new Paragraph("Citizen Plans Info", fontTiltle);
		document.add(paragraph);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		PdfPTable table = new PdfPTable(6);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3, 3, 3, 3 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);

		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start date");
		table.addCell("Plan End Date");

		

		for (CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			if (null != plan.getPlanStartDate()) {
				table.addCell(plan.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != plan.getPlanEndDate()) {
				table.addCell(plan.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
		}

		document.add(table);
		document.close();
	}
}
