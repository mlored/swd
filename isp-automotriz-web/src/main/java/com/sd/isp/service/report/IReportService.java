package com.sd.isp.service.report;

import java.util.List;

import com.sd.isp.beans.report.ReportB;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.service.base.IBaseService;

public interface IReportService extends IBaseService<ReportB, ReportDTO> {
    public List <ReportB> find(String textToFind);
}
