package com.sd.isp.service.entryDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.entry_details.EntryDetailsDaoImpl;
import com.sd.isp.dao.entry_details.IEntryDetailsDao;
import com.sd.isp.dao.item.IItemDao;
import com.sd.isp.dao.part.IPartDao;
import com.sd.isp.domain.employee.EmployeeDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.item.IItemService;
import com.sd.isp.service.part.IPartService;

@Service
public class EntryDetailsServiceImpl extends BaseServiceImpl<EntryDetailsDTO, EntryDetailsDomain, EntryDetailsDaoImpl, EntryDetailsResult> implements IEntryDetailsService {

	@Autowired
	private IEntryDetailsDao entryDetailsDao;
	
	@Autowired
	private IItemDao partDao;
	
	@Autowired
	private IItemService itemService;
	

	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION,key = "'api_entry_details'")
    @CachePut(value=CACHE_REGION, key="'api_entry_details' + #dto.id")
	public EntryDetailsDTO save(EntryDetailsDTO dto) {
		final EntryDetailsDomain entryDetailsDomain = convertDtoToDomain(dto);
		final EntryDetailsDomain entryDetails = entryDetailsDao.save(entryDetailsDomain);
		return convertDomainToDto(entryDetails);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_entry_details' + #id")
	public EntryDetailsDTO getById(Integer id) {
		final EntryDetailsDomain entryDetailsDomain = entryDetailsDao.getById(id);
		final EntryDetailsDTO entryDetailsDTO = convertDomainToDto(entryDetailsDomain);
		return entryDetailsDTO;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_entry_details'")
	public EntryDetailsResult getAll() {
		final List<EntryDetailsDTO> entries = new ArrayList<>();
		for (EntryDetailsDomain domain : entryDetailsDao.findAll()) {
			final EntryDetailsDTO entryDetails = convertDomainToDto(domain);
			entries.add(entryDetails);
		}

		final EntryDetailsResult entriesResult = new EntryDetailsResult();
		entriesResult.setEntryDetails(entries);
		return entriesResult;
	}
	
	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION, key = "'api_entry_details'")
    @CachePut(value=CACHE_REGION, key="'api_entry_details' + #id")
	public EntryDetailsDTO updateById(Integer id, EntryDetailsDTO dto) {
		final EntryDetailsDomain newDomain = convertDtoToDomain(dto);
		final EntryDetailsDomain domain = entryDetailsDao.getById(id);
		domain.setDate(newDomain.getDate());
		final EntryDetailsDomain entryDetailsDomain = entryDetailsDao.save(domain);
		return convertDomainToDto(entryDetailsDomain);
	}

	@Override
	@Transactional
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_entry_details'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_entry_details' + #id")})
	public EntryDetailsDTO delete(Integer id) {
		final EntryDetailsDomain domain = entryDetailsDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected EntryDetailsDTO convertDomainToDto(EntryDetailsDomain domain) {
		final EntryDetailsDTO entryDetails = new EntryDetailsDTO();
		entryDetails.setId(domain.getId());
		entryDetails.setDate(domain.getDate());
		if (domain.getItemDomain() != null) {
			ItemDTO part = itemService.getById(domain.getItemDomain().getId());
			if (part != null)
				entryDetails.setItem(part);
		}
			
		entryDetails.setEntryId(domain.getEntryDomain().getId());
		
		return entryDetails;
	}

	@Override
	protected EntryDetailsDomain convertDtoToDomain(EntryDetailsDTO dto) {
		final EntryDetailsDomain entryDetails = new EntryDetailsDomain();
		entryDetails.setId(dto.getId());
		entryDetails.setDate(dto.getDate());
		entryDetails.setItemDomain(partDao.getById(dto.getItem().getId()));
		
		return entryDetails;
	}
	
	@Override
	@Transactional(readOnly = true)
	public EntryDetailsResult find(String textToFind, int page, int maxItems) throws Exception {
		/*final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.find(textToFind, page, maxItems)) {
			final EmployeeDTO dto = convertDomainToDto(domain);
			employees.add(dto);
		}
		final EmployeeResult employeeResult = new EmployeeResult();
		employeeResult.setEmployees(employees);
		return employeeResult;*/
		return null;
	}

}