package com.sd.isp.service.report;

import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.employee.IEmployeeDao;
import com.sd.isp.dao.entry.IEntryDao;
import com.sd.isp.dao.entry_details.IEntryDetailsDao;
import com.sd.isp.dao.report.IReportDao;
import com.sd.isp.dao.report.ReportDaoImpl;
import com.sd.isp.domain.report.ReportDomain;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class ReportServiceImpl extends BaseServiceImpl<ReportDTO, ReportDomain, ReportDaoImpl, ReportResult>
		implements IReportService {
	@Autowired
	private IReportDao _reportDao;

	@Autowired
	private IEmployeeDao _employeeDao;


	@Override
	@Transactional
	
	public ReportDTO save(ReportDTO dto) {
		try {
			
			final ReportDomain domain = convertDtoToDomain(dto);
			final ReportDomain report = _reportDao.save(domain);
			final ReportDTO newDto    = convertDomainToDto(report);
			if (dto.getId() == null) {
				//getCacheManager().getCache("isp-platform-cache").put("report_" + report.getId(), newDto);
			}
			return newDto;
		} catch (Exception ex) {
		
			throw new RuntimeException("Error" + ReportServiceImpl.class + "" + ex.getMessage(), ex);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ReportDTO getById(Integer id) {
		final ReportDomain domain = _reportDao.getById(id);
		final ReportDTO dto 	  = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public ReportResult getAll(){
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : _reportDao.findAll()) {
			final ReportDTO dto  = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}
	
	@Override
	public ReportDTO convertDomainToDto(ReportDomain domain) {
		final ReportDTO dto = new ReportDTO();
		dto.setId(domain.getId());
		dto.setEmployeeId(domain.getEmployee().getId());
		dto.setDate(domain.getDate());
		dto.setIsActived(domain.getIsActived());
		
		return dto;
	}

	@Override
	public ReportDomain convertDtoToDomain(ReportDTO dto){
		final ReportDomain domain = new ReportDomain();
		domain.setId(dto.getId());
		domain.setEmployee(_employeeDao.getById(dto.getEmployeeId()));
		domain.setDate(dto.getDate());
		domain.setIsActived(dto.getIsActived());
		
		return domain;
	}

	@Override
	@Transactional(readOnly = true)
	public ReportResult find(String textToFind, int page, int maxItems) throws Exception {
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : _reportDao.find(textToFind, page, maxItems)) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}

	@Override
	public ReportResult find(String textToFind) throws Exception /*AutomotiveException*/ {
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : _reportDao.find(textToFind)) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}

	@Override
	public ReportDTO updateById(Integer id, ReportDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
