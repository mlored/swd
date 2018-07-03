package com.sd.isp.beans.report;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.employee.EmployeeB;
import com.sd.isp.beans.report.ReportB;

public class ReportB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private Date 		  _date;
	private EmployeeB	  _employee;
	private Boolean 	  _isActived;

	public ReportB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public EmployeeB getEmployee() {
		return _employee;
	}

	public void setEmployee(EmployeeB employee) {
		_employee = employee;
	}
	
	public Boolean getIsActived() {
		return _isActived;
	}

	public void setIsActived(Boolean isActived) {
		_isActived = isActived;
	}
	
  
}
