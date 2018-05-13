package com.sd.isp.service.report;

import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.entry.IEntryDao;
import com.sd.isp.dao.entry_details.IEntryDetailsDao;
import com.sd.isp.exception.AutomotiveException;
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
	private IEntryDao _entryDao;

	@Autowired
	private IEntryDetailsDao _diagnosticDao;
	/*
	@Autowired
	private IStatisticDao _statisticDao;*/

	//private static Logger logger = Logger.getLogger(ReportServiceImpl.class);

	@Override
	@Transactional
	//@CacheEvict(value = "lab-patologia-platform-cache", key = "'reports'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'report_' + #dto.id", condition = "#dto.id!=null")
	public ReportDTO save(ReportDTO dto) {
		try {
			// Lanzo exepcion de tipo runtime para realizar rollback
			final ReportDomain domain = convertDtoToDomain(dto);
			final ReportDomain report = _reportDao.save(domain);
			final ReportDTO newDto    = convertDomainToDto(report);
			if (dto.getId() == null) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("report_" + report.getId(), newDto);
			}
			return newDto;
		} catch (Exception ex) {
			//logger.error(ex);
			throw new RuntimeException("Error" + ReportServiceImpl.class + "" + ex.getMessage(), ex);
		}
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'report_' + #id")
	public ReportDTO getById(Integer id) {
		final ReportDomain domain = _reportDao.getById(id);
		final ReportDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'reports'")
	public ReportResult getAll(){
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : _reportDao.findAll()) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
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
	public ReportResult find(String textToFind) throws AutomotiveException {
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

	@Override
	protected ReportDTO convertDomainToDto(ReportDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ReportDomain convertDtoToDomain(ReportDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
