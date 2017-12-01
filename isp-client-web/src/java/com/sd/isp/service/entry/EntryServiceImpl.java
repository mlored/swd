package com.sd.isp.service.entry;

import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.entry.IEntryResource;
import com.sd.isp.service.base.BaseServiceImpl;

import com.sd.isp.service.car.CarServiceImpl;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.client.IClientService;
import com.sd.isp.service.client.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("entryService")
public class EntryServiceImpl extends BaseServiceImpl<EntryB, EntryDTO>
        implements IEntryService {

    @Autowired
    private IEntryResource _entryResource;
    private ICarService _carService = new CarServiceImpl();
    private IClientService _clientService = new ClientServiceImpl();


    public EntryServiceImpl() {
    }

    @Override
    public EntryB save(EntryB bean) {
        final EntryDTO entry = convertBeanToDto(bean);
        final EntryDTO dto = _entryResource.save(entry);
        final EntryB entryB = convertDtoToBean(dto);
        return entryB;
    }

    @Override
    @Cacheable(value="isp-client-web-cache", key="'entry_getAll'")
    public List<EntryB> getAll() {
        final EntryResult result = _entryResource.getAll();
        final List<EntryDTO> cList = null == result.getEntry() ? new ArrayList<EntryDTO>()
                : result.getEntry();

        final List<EntryB> entries = new ArrayList<EntryB>();
        for (EntryDTO dto : cList) {
            final EntryB bean = convertDtoToBean(dto);
            entries.add(bean);
        }
        return entries;
    }

    @Override
    public EntryB getById(Integer id) {
        final EntryDTO dto = _entryResource.getById(id);
        final EntryB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
	public EntryB update(Integer id,  EntryB entryB) {
    	final EntryDTO entry   = convertBeanToDto(entryB);
        final EntryDTO dto     = _entryResource.update(id, entry);
        final EntryB bean      = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public EntryB delete(Integer id) {
        final EntryDTO dto = _entryResource.destroy(id);
        final EntryB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected EntryB convertDtoToBean(EntryDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", String.valueOf(dto.getDate()));
        params.put("number", String.valueOf(dto.getNumber()));
        params.put("diagnostic", dto.getDiagnostic());

        final EntryB entryB = new EntryB(params);

        entryB.setCar(_carService.getById(dto.getCar().getId()));
        entryB.setCliente(_clientService.getById(dto.getClient().getId()));
        entryB.setDate(dto.getDate());
        return entryB;
    }

    @Override
    protected EntryDTO convertBeanToDto(EntryB bean) {
        final EntryDTO dto = new EntryDTO();
        dto.setId(bean.getId());

        dto.setDate(bean.getDate());
        dto.setNumber(bean.getNumber());
        dto.setDiagnostic(bean.getDiagnostic());
        dto.getCar().setId(bean.getCar().getId());
        dto.getClient().setId(bean.getCliente().getId());

        return dto;
    }
}