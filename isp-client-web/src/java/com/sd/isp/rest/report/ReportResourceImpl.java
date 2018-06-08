package com.sd.isp.rest.report;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("reportResource")
public class ReportResourceImpl extends BaseResourceImpl<ReportDTO,ReportResult> implements
		IReportResource {

	public ReportResourceImpl() {
		super(ReportDTO.class, "/report", ReportResult.class);
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'reports'")
	//@CachePut(value = CACHE_REGION, key = "'report_' + #report.id", condition = "#report.id!=null")
	public ReportDTO save(ReportDTO report) {
		ReportDTO newDto = super.save(report);
		/*if (null == report.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"report_" + newDto.getId(), newDto);
		}*/
		return newDto;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'report_' + #id")
	public ReportDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'reports'")
	public ReportResult getAll() {
		//setWebResourceBasicAuthFilter();
		final ReportResult result = getWebResource().get(ReportResult.class);
		return result;
	}

	@Override
	public ReportResult find(String textToFind, int maxItems, int page) {
		//setWebResourceBasicAuthFilter();
		//final ReportResult result = findWR(textToFind, maxItems, page).get(ReportResult.class);
		//return result;
		return null;
	}
	

	public ReportResult find(String textToFind) {
		//setWebResourceBasicAuthFilter();
		final ReportResult result = getWebResource().path("/search/" + textToFind).get(ReportResult.class);
		return result;
	}

	@Override
	public ReportDTO update(Integer id, ReportDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportDTO destroy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

