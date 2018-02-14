package com.sd.isp.service.entry_details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.sd.isp.service.entry.EntryServiceImpl;
import com.sd.isp.service.part.IPartService;
import com.sd.isp.service.part.PartServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.entry_details.EntryDetailsB;
import com.sd.isp.beans.service.ServiceB;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.rest.entry_details.IEntryDetailsResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.entry_details.IEntryDetailsService;
import com.sd.isp.service.entry.IEntryService;

@Service("entryDetailsService")
public class EntryDetailsServiceImpl extends BaseServiceImpl<EntryDetailsB, EntryDetailsDTO> implements
        IEntryDetailsService {

    @Autowired
    private IEntryDetailsResource _entryDetailsResource;
    @Autowired
    private IPartService _partService;
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
        final EntryDetailsDTO entryDetailsDTO = _entryDetailsResource.save(dto);
        return convertDtoToBean(entryDetailsDTO);
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
    public EntryDetailsB update(Integer id, EntryDetailsB bean) {
        return null;
    }

    @Override
    protected EntryDetailsB convertDtoToBean(EntryDetailsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", dto.getDate().toString());

        final EntryDetailsB entryDetails = new EntryDetailsB(params);
        entryDetails.setPart(_partService.getById(dto.getPart().getId()));
        entryDetails.setEntry(_entryService.getById(dto.getEntryId()));


        return entryDetails;
    }

    @Override
    protected EntryDetailsDTO convertBeanToDto(EntryDetailsB bean) {
        final EntryDetailsDTO dto = new EntryDetailsDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());
        dto.getPart().setId(bean.getPart().getId());
        dto.setEntryId(bean.getEntry().getId());



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
    
    public List<EntryDetailsB> find (String textToFind, int maxItems, int page) {
		/*final ServiceResult result = _serviceResource.find(textToFind, maxItems, page);
		final List<ServiceDTO> rList = null == result.getServices() ? new ArrayList<ServiceDTO>()
				: result.getServices();

		final List<ServiceB> services = new ArrayList<ServiceB>();
		for (ServicetDTO dto : rList) {
			final ServiceB bean = convertDtoToBean(dto);
			services.add(bean);
		}*/
		return null;
	}
}
