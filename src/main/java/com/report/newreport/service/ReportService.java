package com.report.newreport.service;

import java.io.IOException;

public interface ReportService {
	
	public void generateReportMap() throws IOException;
	public void generateReportJSON(String reportName) throws IOException;

}
