package com.sd.isp.rest.report;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("reportResource")
public class ReportResourceImpl extends BaseResourceImpl<ReportDTO,ReportResult> implements
        IReportResource {

    public ReportResourceImpl() {
        super(ReportDTO.class, "/report" , ReportResult.class);
    }

    @Override
    public ReportDTO save(ReportDTO report) {
        ReportDTO newDto = super.save(report);
        if (null == report.getId()) {
            getCacheManager().getCache(CACHE_REGION).put(   //Add en rest/BaseResourceImpl
                    "report_" + newDto.getId(), newDto);
        }
        return newDto;
    }

    @Override

    public ReportDTO getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public ReportResult getAll() {
        //setWebResourceBasicAuthFilter();
        final ReportResult result = getWebResource().get(ReportResult.class);
        return result;
    }

    @Override
    public ReportResult find(String textToFind, int maxItems, int page) {
        //setWebResourceBasicAuthFilter();
        final ReportResult result = findWR(textToFind, maxItems, page);/*.get(ReportResult.class);*/
        return result;
        //return null;
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

