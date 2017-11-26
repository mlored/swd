package com.sd.isp.service.entry_details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.isp.entry_details.EntryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.entry_details.EntryDetailsB;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.rest.entry_details.IEntryDetailsResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.entry_details.IEntryDetailsService;
//import com.sd.isp.service.materia.IMateriaService;
import com.sd.isp.service.entry.IEntryService;

@Service("entryDetailsService")
public class EntryDetailsServiceImpl extends BaseServiceImpl<EntryDetailsB, EntryDetailsDTO> implements
        IEntryDetailsService {

    @Autowired
    private IEntryDetailsResource _entryDetailsResource;
    //@Autowired
    //private IMateriaService _materiaService;
    @Autowired
    private IEntryService _entryService;

    public EntryDetailsServiceImpl() {
    }

    @Override
    public EntryDetailsB delete(Integer id) {
        final EntryDetailsDTO dto = _entryDetailsResource.getById(id);
        _entryDetailsResource.destroy(id);
        return convertDtoToBean(dto);
    }

    @Override
    public EntryDetailsB save(EntryDetailsB bean) {
        final EntryDetailsDTO dto = convertBeanToDto(bean);
        final EntryDetailsDTO profesorDetalleDTO = _entryDetailsResource.save(dto);
        return convertDtoToBean(profesorDetalleDTO);
    }

    @Override
    public List<EntryDetailsB> getAll() {
        final EntryDetailsResult result = _entryDetailsResource.getAll();
        final List<EntryDetailsDTO> cList = null == result.getEntryDetails() ? new ArrayList<EntryDetailsDTO>()
                : result.getEntryDetails();
        final List<EntryDetailsB> entry_details = new ArrayList<EntryDetailsB>();
        for (EntryDetailsDTO dto : cList) {
            final EntryDetailsB entry_detail = convertDtoToBean(dto);
            entry_details.add(entry_detail);
        }
        return entry_details;
    }

    @Override
    public EntryDetailsB getById(Integer id) {
        final EntryDetailsDTO dto = _entryDetailsResource.getById(id);
        return convertDtoToBean(dto);
    }

    @Override
    protected EntryDetailsB convertDtoToBean(EntryDetailsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", dto.getDate().toString());

        final EntryDetailsB entryDetails = new EntryDetailsB(params);
        //entryDetails.setMateria(_materiaService.getById(dto.getMateriaId()));
        //entryDetails.setProfesor(_profesorService.getById(dto.getProfesorId()));

        return entryDetails;
    }

    @Override
    protected EntryDetailsDTO convertBeanToDto(EntryDetailsB bean) {
        final EntryDetailsDTO dto = new EntryDetailsDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());


       // dto.setMateriaId(bean.getMateria().getId());
       // dto.setProfesorId(bean.getProfesor().getId());

        return dto;
    }

    @Override
    public List<EntryDetailsB> getAllBy(Map<String, String> args) {
        final EntryDetailsResult result = _entryDetailsResource.getAllBy(args);
        final List<EntryDetailsDTO> cList = null == result.getEntryDetails() ? new ArrayList<EntryDetailsDTO>()
                : result.getEntryDetails();
        final List<EntryDetailsB> entry_details = new ArrayList<EntryDetailsB>();
        for (EntryDetailsDTO dto : cList) {
            final EntryDetailsB entry_detail = convertDtoToBean(dto);
            entry_details.add(entry_detail);
        }
        return entry_details;
    }
}
