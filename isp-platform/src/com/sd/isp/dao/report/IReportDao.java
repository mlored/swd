package com.sd.isp.dao.report;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
//import com.sd.isp.exception.AutomotiveException;
import com.sd.isp.domain.report.ReportDomain;

public interface IReportDao extends IBaseDao<ReportDomain> {

	public abstract List<ReportDomain>find(String textToFind); /*throws AutomotiveException;*/
	
}