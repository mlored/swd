package com.sd.isp.service.entry;

import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.entry.IEntryResource;
import com.sd.isp.service.base.BaseServiceImpl;

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

        final List<EntryB> entrys = new ArrayList<EntryB>();
        for (EntryDTO dto : cList) {
            final EntryB bean = convertDtoToBean(dto);
            entrys.add(bean);
        }
        return entrys;
    }

    @Override
    public EntryB getById(Integer id) {
        final EntryDTO dto = _entryResource.getById(id);
        final EntryB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public EntryB update(Integer id, EntryB bean) {
        return null;
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
        //params.put("carB", dto.getNumber());
        //params.put("clientB", dto.getNumber());


        final EntryB entryB = new EntryB(params);

        return entryB;
    }

    @Override
    protected EntryDTO convertBeanToDto(EntryB bean) {
        final EntryDTO dto = new EntryDTO();
        dto.setId(bean.getId());

        dto.setDate(bean.getDate());
        dto.setNumber(bean.getNumber());
        dto.setDiagnostic(bean.getDiagnostic());
        //dto.setCar(bean.getCarB());
        //dto.setClient(params.get("clientB"))

        return dto;
    }
}
