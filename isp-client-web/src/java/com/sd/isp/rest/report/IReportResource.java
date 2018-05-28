package com.sd.isp.rest.report;

import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IReportResource extends IBaseResource<ReportDTO, ReportResult>{
	
    public ReportResult getAll();
    public ReportResult find(String textToFind, int maxItems, int page);
    public ReportResult find(String textToFind);
}
