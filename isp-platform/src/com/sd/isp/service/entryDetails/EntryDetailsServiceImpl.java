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
import com.sd.isp.dao.part.IPartDao;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.part.IPartService;

@Service
public class EntryDetailsServiceImpl extends BaseServiceImpl<EntryDetailsDTO, EntryDetailsDomain, EntryDetailsDaoImpl, EntryDetailsResult> implements IEntryDetailsService {

	@Autowired
	private IEntryDetailsDao entryDetailsDao;
	
	@Autowired
	private IPartDao partDao;
	
	@Autowired
	private IPartService partService;
	

	@Override
	@Transactional
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'entry_getAll'"),
                       @CacheEvict(value="isp-platform-cache", key="'entry_getById_'+#dto.getId()")})*/
  //  @CachePut(value = "isp-platform-cache",key="'entry_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@CachePut(value = "isp-platform-cache",key="'entryDetails_save'")
	public EntryDetailsDTO save(EntryDetailsDTO dto) {
		final EntryDetailsDomain entryDetailsDomain = convertDtoToDomain(dto);
		final EntryDetailsDomain entryDetails = entryDetailsDao.save(entryDetailsDomain);
		return convertDomainToDto(entryDetails);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'entryDetails_' + #id'")
	//@Cacheable(value="isp-platform-cache", key="'entry_'+#root.methodName+'_'+#id")
	public EntryDetailsDTO getById(Integer id) {
		final EntryDetailsDomain entryDetailsDomain = entryDetailsDao.getById(id);
		final EntryDetailsDTO entryDetailsDTO = convertDomainToDto(entryDetailsDomain);
		return entryDetailsDTO;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache", key = "'entryDetails_getAll'")
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
	public EntryDetailsDTO updateById(Integer id, EntryDetailsDTO dto) {
		final EntryDetailsDomain newDomain = convertDtoToDomain(dto);
		final EntryDetailsDomain domain = entryDetailsDao.getById(id);
		domain.setDate(newDomain.getDate());
		final EntryDetailsDomain entryDetailsDomain = entryDetailsDao.save(domain);
		return convertDomainToDto(entryDetailsDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'entry_getAll'"),
	   		           @CacheEvict(value="isp-platform-cache", key="'entry_getById_'+#dto.getId()")})*/
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
			PartDTO part = partService.getById(domain.getItemDomain().getId());
			if (part != null)
				entryDetails.setPart(part);
		}
			
		entryDetails.setEntryId(domain.getEntryDomain().getId());
		
		return entryDetails;
	}

	@Override
	protected EntryDetailsDomain convertDtoToDomain(EntryDetailsDTO dto) {
		final EntryDetailsDomain entryDetails = new EntryDetailsDomain();
		entryDetails.setId(dto.getId());
		entryDetails.setDate(dto.getDate());
		entryDetails.setItemDomain(partDao.getById(dto.getPart().getId()));
		
		return entryDetails;
	}

}