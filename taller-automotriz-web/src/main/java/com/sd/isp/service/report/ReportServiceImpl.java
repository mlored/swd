package com.sd.isp.service.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.report.ReportB;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.rest.report.IReportResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.client.IClientService;
import com.sd.isp.service.entry.IEntryService;
import com.sd.isp.service.part.IPartService;

@Service("reportService")
public class ReportServiceImpl extends BaseServiceImpl<ReportB, ReportDTO>
        implements IReportService {

    @Autowired
    private IReportResource _reportResource;

    @Autowired
    private IEntryService   _entryService;

    @Autowired
    private IClientService  _clientService;

    @Autowired
    private ICarService     _carService;

    @Autowired
    private IPartService     _partService;

    public ReportServiceImpl() {
    }

    @Override
    public ReportB save(ReportB bean) {
        final ReportDTO report = convertBeanToDto(bean);
        final ReportDTO dto = _reportResource.save(report);
        final ReportB reportB = convertDtoToBean(dto);
        return reportB;
    }

    @Override

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
    public ReportB getById(Integer id) {
        final ReportDTO dto = _reportResource.getById(id);
        final ReportB bean  = convertDtoToBean(dto);
        return bean;
    }

    @Override
    public ReportB convertDtoToBean(ReportDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        final ReportB reportB = new ReportB(params);
        //reportB.setEntry(_entryService.getById(dto.getEntryDetails()));
        reportB.setDate(dto.getDate());
        reportB.setIsActived(dto.getIsActived());

        return reportB;
    }

    @Override
    public ReportDTO convertBeanToDto(ReportB bean) {
        final ReportDTO dto = new ReportDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());
        dto.setIsActived(bean.getIsActived());

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

