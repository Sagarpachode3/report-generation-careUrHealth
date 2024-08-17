package com.psagar3codes.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.psagar3codes.entity.CitizenPlan;
import com.psagar3codes.repository.CitizenPlanRepository;
import com.psagar3codes.request.SearchRequest;
import com.psagar3codes.utils.EmailUtils;
import com.psagar3codes.utils.ExcelGenerator;
import com.psagar3codes.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (request.getStartDate() != null && !request.getStartDate().isEmpty()) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// converting string to local date
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}

		if (request.getEndDate() != null && !request.getEndDate().isEmpty()) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// Converting string to LocalDate
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
		}

//		BeanUtils.copyProperties(request, entity);
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File file = new File("Plans.xls");
		List<CitizenPlan> records = planRepo.findAll();
		excelGenerator.generateExcel(response, records, file);
		
		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "sagarpachode3@gmail.com";

		emailUtils.sendEmail(subject, body, to, file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		File file = new File("Plans.pdf");
		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.generatePdf(response, plans, file);
		
		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "sagarpachode3@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, file);
		file.delete();
		return true;
	}

}
