package com.report.newreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.newreport.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

	Report findByReportName(String reportName);
	
}
