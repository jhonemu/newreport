package com.report.newreport.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.newreport.model.Report;
import com.report.newreport.repository.ReportRepository;
import com.report.newreport.service.DataService;
import com.report.newreport.service.ReportService;


@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private ReportRepository repo;
	@Override
	public void generateReportMap() throws IOException {
	
		List<Map<String,Object>> employees = null ;
		
		
		
		
	}

	@Override
	public void generateReportJSON(String reportName) throws IOException {
		Report report = repo.findByReportName(reportName);
		JSONArray data = dataService.generateJSONData();
		generateReport(data,report.getVariable());
		
	}
	
	
	private void generateReport(Object data,String variableName) throws IOException {
		try (InputStream is = getClass().getResourceAsStream("/prueba.xlsx")) {
			try (OutputStream os = new FileOutputStream("C:\\ExcelTest\\pruebaR.xlsx")) {
				Context context = new Context();
				context.putVar(variableName, data);
				JxlsHelper.getInstance().processTemplate(is, os, context);
			}
		}
	}

}
