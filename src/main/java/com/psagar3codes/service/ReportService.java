package com.psagar3codes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psagar3codes.entity.CitizenPlan;
import com.psagar3codes.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;


public interface ReportService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response)throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
