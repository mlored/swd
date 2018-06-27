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

import com.sd.isp.dao.car.ICarDao;
import com.sd.isp.dao.client.IClientDao;
import com.sd.isp.dao.entry.EntryDaoImpl;
import com.sd.isp.dao.entry.IEntryDao;
import com.sd.isp.dao.entry_details.IEntryDetailsDao;
import com.sd.isp.dao.item.IItemDao;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.domain.part.ItemDomain;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.cliente.IClientService;

@Service
public class EntryServiceImpl extends BaseServiceImpl<EntryDTO, EntryDomain, EntryDaoImpl, EntryResult> implements IEntryService {

	@Autowired
	private IEntryDao entryDao;
	
	@Autowired
	private ICarDao carDao;
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IItemDao itemDao;
	
	@Autowired
	private IEntryDetailsDao entryDetailDao;
	
	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION,key = "'api_entries'")
    @CachePut(value=CACHE_REGION, key="'api_entries' + #dto.id")
	public EntryDTO save(EntryDTO dto) {
		final EntryDomain entryDomain = convertDtoToDomain(dto);
		final EntryDomain entry = entryDao.save(entryDomain);
		for (EntryDetailsDomain e : entryDomain.getEntryDetailsDomains()){
			e.setEntryDomain(entry);
			entryDetailDao.save(e);
		}
		return convertDomainToDto(entry);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_entries' + #id")
	public EntryDTO getById(Integer id) {
		final EntryDomain entryDomain = entryDao.getById(id);
		final EntryDTO entryDTO = convertDomainToDto(entryDomain);
		
		return entryDTO;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_entries'")
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
	@Transactional
	@CacheEvict(value=CACHE_REGION, key = "'api_entries'")
    @CachePut(value=CACHE_REGION, key="'api_entries' + #id")
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
	@Transactional
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_entries'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_entries' + #id")})
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
		entry.setCarId(domain.getCarDomain().getId());
		entry.setClientId(domain.getClientDomain().getId());

		ArrayList<EntryDetailsDTO> l = new ArrayList<EntryDetailsDTO>();
		for (EntryDetailsDomain e1 : domain.getEntryDetailsDomains()){
			l.add(convertDtoToDomain(e1));
		}
		entry.setEntryDetails(l);
		
		return entry;
	}
	
	protected ItemDTO convertDomainToDto(ItemDomain domain) {
		final ItemDTO item = new ItemDTO();
		item.setId(domain.getId());
		item.setName(domain.getName());
		item.setDescription(domain.getDescription());
		item.setPrice(domain.getPrice());
		item.setQuantity(domain.getQuantity());
		
		return item;
	}
	
	protected EntryDetailsDTO convertDtoToDomain(EntryDetailsDomain domainD) {
		final EntryDetailsDTO entryD = new EntryDetailsDTO();
		entryD.setId(domainD.getId());
		entryD.setDate(domainD.getDate());
		entryD.setItemId(domainD.getItemDomain().getId());
		entryD.setItem(convertDomainToDto(domainD.getItemDomain()));
		
		return entryD;
	}

	@Override
	protected EntryDomain convertDtoToDomain(EntryDTO dto) {
		final EntryDomain entry = new EntryDomain();
		entry.setId(dto.getId());
		entry.setDate(dto.getDate());
		entry.setNumber(dto.getNumber());
		entry.setDiagnostic(dto.getDiagnostic());

		entry.setClientDomain(clientDao.getById(dto.getClientId()));
		entry.setCarDomain(carDao.getById(dto.getCarId()));
		
		ArrayList<EntryDetailsDomain> l = new ArrayList();
		for (EntryDetailsDTO e : dto.getEntryDetails()){
			l.add(convertDtoToDomain(e));
		}
		
		entry.setEntryDetailsDomains(l);
		return entry;
	}

	
	protected EntryDetailsDomain convertDtoToDomain(EntryDetailsDTO dto) {
		final EntryDetailsDomain entryD = new EntryDetailsDomain();
		entryD.setId(dto.getId());
		entryD.setDate(dto.getDate());
		entryD.setItemDomain(itemDao.getById(dto.getItemId()));
		
		return entryD;
	}
	
	@Override
	@Transactional(readOnly = true)
	public EntryResult find(String textToFind, int page, int maxItems) throws Exception {
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