package com.sd.isp.service.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.report.ReportB;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.rest.report.IReportResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.employee.IEmployeeService;
import com.sd.isp.service.entry.IEntryService;
import com.sd.isp.service.entry_details.IEntryDetailsService;
/*import com.sd.isp.service.request.IRequestService;
import com.sd.isp.service.statistic.IStatisticService;*/

@Service("reportService")
public class ReportServiceImpl extends BaseServiceImpl<ReportB, ReportDTO>
		implements IReportService {

	@Autowired
	private IReportResource _reportResource;
	@Autowired
	private IEmployeeService   _employeeService;
	/*@Autowired 
	private IEntryService   _diagnosticService;*/
	/*@Autowired
	private IEntryService   _clientDomain;
	@Autowired
	private IEntryService   _carDomain;*/
	/*@Autowired
	private IEntryDetailsService _entryDetailsService;*/

	public ReportServiceImpl() {
	}

	@Override
	@CacheEvict(value=CACHE_REGION,key = "'reports'")
	@CachePut(value=CACHE_REGION, key="'reports#{bean.id}'")
	public ReportB save(ReportB bean) {
		final ReportDTO report = convertBeanToDto(bean);
		final ReportDTO dto = _reportResource.save(report);
		final ReportB reportB = convertDtoToBean(dto);
		return reportB;
	}

	@Override
	@Cacheable(value=CACHE_REGION, key="'reports'")
	public List<ReportB> getAll() {
		final ReportResult result = _reportResource.getAll();
		final List<ReportDTO> rList = null == result.getReports() ? new ArrayList<ReportDTO>()
				: result.getReports();

		final List<ReportB> reports = new ArrayList<ReportB>();
		for (ReportDTO dto : rList) {
			final ReportB bean = convertDtoToBean(dto);
			reports.add(bean);
		}
		return reports;
	}

	@Override
	@Cacheable(value=CACHE_REGION, key="'reports' + #id")
	public ReportB getById(Integer id) {
		final ReportDTO dto = _reportResource.getById(id);
		final ReportB bean  = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected ReportB convertDtoToBean(ReportDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		//params.put("observations", dto.getObservations());
		final ReportB reportB = new ReportB(params);
		reportB.setEmployee(_employeeService.getById(dto.getEmployeeId()));
		reportB.setDate(dto.getDate());	
		reportB.setIsActived(dto.getIsActived());
		//reportB.setEntryDetails(_entryDetailsService.getById(dto.getEntryDetailsId()));
		//reportB.setIsFinished(dto.getIsFinished());
		//reportB.setAge(dto.getAge());
		//reportB.setDiagnosticDetail(dto.getDiagnosticDetail());
		/*if(null!=dto.getStatisticId()){
			reportB.setStatistic(_statisticService.getById(dto.getStatisticId()));
		}*/
		return reportB;
	}

	@Override
	protected ReportDTO convertBeanToDto(ReportB bean) {
		final ReportDTO dto = new ReportDTO();
		dto.setId(bean.getId());
		dto.setDate(bean.getDate());
		dto.setIsActived(bean.getIsActived());
		dto.setEmployeeId(bean.getEmployee().getId());
		//dto.setEntryDetailsId(bean.getEntry().getId());
		//dto.setObservations(bean.getObservations());
		//dto.setRequestId(bean.getRequest().getId());
		//dto.setAge(bean.getAge());
		/*if(null!=bean.getStatistic()){
			dto.setStatisticId(bean.getStatistic().getId());
		}*/
		
		return dto;
	}
	@Override
	public List<ReportB> find (String textToFind, int maxItems, int page) {
		final ReportResult result   = _reportResource.find(textToFind, maxItems, page);
		final List<ReportDTO> rList = null == result.getReports() ? new ArrayList<ReportDTO>()
				: result.getReports();

		final List<ReportB> reports = new ArrayList<ReportB>();
		for (ReportDTO dto : rList) {
			final ReportB bean = convertDtoToBean(dto);
			reports.add(bean);
		}
		return reports;
	}

	@Override
	public List<ReportB> find (String textToFind) {
		final ReportResult result   = _reportResource.find(textToFind, 0, 0);
		final List<ReportDTO> rList = null == result.getReports() ? new ArrayList<ReportDTO>()
				: result.getReports();

		final List<ReportB> reports = new ArrayList<ReportB>();
		for (ReportDTO dto : rList) {
			final ReportB bean = convertDtoToBean(dto);
			reports.add(bean);
		}
		return reports;
	}

	@Override
	public ReportB update(Integer id, ReportB bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportB delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}

