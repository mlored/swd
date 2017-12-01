package com.sd.isp.service.entry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.entry.EntryDaoImpl;
import com.sd.isp.dao.entry.IEntryDao;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.cliente.IClientService;

@Service
public class EntryServiceImpl extends BaseServiceImpl<EntryDTO, EntryDomain, EntryDaoImpl, EntryResult> implements IEntryService {

	@Autowired
	private IEntryDao entryDao;
	
	@Autowired
	private ICarService carService;
	
	@Autowired
	private IClientService clientService;
	

	@Override
	@Transactional
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'entry_getAll'"),
                       @CacheEvict(value="isp-platform-cache", key="'entry_getById_'+#dto.getId()")})*/
  //  @CachePut(value = "isp-platform-cache",key="'entry_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@CachePut(value = "isp-platform-cache",key="'entry_save'")
	public EntryDTO save(EntryDTO dto) {
		final EntryDomain entryDomain = convertDtoToDomain(dto);
		final EntryDomain entry = entryDao.save(entryDomain);
		return convertDomainToDto(entry);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache", key = "'entry_' + #id'")
	//@Cacheable(value="isp-platform-cache", key="'entry_'+#root.methodName+'_'+#id")
	public EntryDTO getById(Integer id) {
		final EntryDomain entryDomain = entryDao.getById(id);
		final EntryDTO entryDTO = convertDomainToDto(entryDomain);
		return entryDTO;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache", key = "'entry_getAll'")
	public EntryResult getAll() {
		final List<EntryDTO> entries = new ArrayList<>();
		for (EntryDomain domain : entryDao.findAll()) {
			final EntryDTO entry = convertDomainToDto(domain);
			entries.add(entry);
		}

		final EntryResult entriesResult = new EntryResult();
		entriesResult.setEntry(entries);
		return entriesResult;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public EntryDTO updateById(Integer id, EntryDTO dto) {
		final EntryDomain newDomain = convertDtoToDomain(dto);
		final EntryDomain domain = entryDao.getById(id);
		domain.setDate(newDomain.getDate());
		domain.setNumber(newDomain.getNumber());
		domain.setDiagnostic(newDomain.getDiagnostic());
		final EntryDomain entryDomain = entryDao.save(domain);
		return convertDomainToDto(entryDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'entry_getAll'"),
	   		           @CacheEvict(value="isp-platform-cache", key="'entry_getById_'+#dto.getId()")})*/
	public EntryDTO delete(Integer id) {
		final EntryDomain domain = entryDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected EntryDTO convertDomainToDto(EntryDomain domain) {
		final EntryDTO entry = new EntryDTO();
		entry.setId(domain.getId());
		entry.setDate(domain.getDate());
		entry.setNumber(domain.getNumber());
		entry.setDiagnostic(domain.getDiagnostic());
		if (domain.getCarDomain() != null) {
			CarDTO car = carService.getById(domain.getCarDomain().getId());
			if (car != null)
				entry.setCar(car);
		}
		if (domain.getClientDomain() != null) {
			ClientDTO client = clientService.getById(domain.getClientDomain().getId());
			if (client != null)
				entry.setClient(client);
		}	
		
		
		return entry;
	}

	@Override
	protected EntryDomain convertDtoToDomain(EntryDTO dto) {
		final EntryDomain entry = new EntryDomain();
		entry.setId(dto.getId());
		entry.setDate(dto.getDate());
		entry.setNumber(dto.getNumber());
		entry.setDiagnostic(dto.getDiagnostic());
		
		return entry;
	}

}