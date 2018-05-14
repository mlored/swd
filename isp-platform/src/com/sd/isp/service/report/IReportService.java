package com.sd.isp.service.report;


import com.sd.isp.dao.report.ReportDaoImpl;
import com.sd.isp.domain.report.ReportDomain;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.service.base.IBaseService;

public interface IReportService extends IBaseService<ReportDTO, ReportDomain, ReportDaoImpl, ReportResult> {
	
	public ReportResult find(String textToFind) throws Exception/*AutomotiveException*/;


}
