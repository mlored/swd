package com.sd.isp.service.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.item.IItemDao;
import com.sd.isp.dao.item.ItemDaoImpl;
import com.sd.isp.domain.part.ItemDomain;
import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.item.ItemResult;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class ItemServiceImpl extends BaseServiceImpl<ItemDTO, ItemDomain, ItemDaoImpl, ItemResult> implements IItemService {

	@Autowired
	private IItemDao itemDao;

	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION,key = "'api_parts'")
    @CachePut(value=CACHE_REGION, key="'api_parts' + #dto.id")
	public ItemDTO save(ItemDTO dto) {
		final ItemDomain domain = convertDtoToDomain(dto);
		final ItemDomain ItemDomain =  itemDao.save(domain);
		return convertDomainToDto(ItemDomain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_parts' + #id")
	public ItemDTO getById(Integer id) {
		final ItemDomain domain = itemDao.getById(id);
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_parts'")
	public ItemResult getAll() {
		final List<ItemDTO> items = new ArrayList<>();
		for (ItemDomain domain : itemDao.findAll()) {
			final ItemDTO item = convertDomainToDto(domain);
			items.add(item);
		}

		final ItemResult itemResult = new ItemResult();
		itemResult.setItems(items);
		return itemResult;
	}

	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION, key = "'api_parts'")
    @CachePut(value=CACHE_REGION, key="'api_parts' + #id")
	public ItemDTO updateById(Integer id, ItemDTO dto) {
		final ItemDomain newDomain = convertDtoToDomain(dto);
		final ItemDomain domain = itemDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setDescription(newDomain.getDescription());
		domain.setPrice(newDomain.getPrice());
		domain.setQuantity(newDomain.getQuantity());
		final ItemDomain ItemDomain = itemDao.save(domain);
		return convertDomainToDto(ItemDomain);
	}

	@Override
	@Transactional
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_parts'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_parts' + #id")})
	public ItemDTO delete(Integer id) {
		final ItemDomain domain = (ItemDomain) itemDao.delete(id);
		return convertDomainToDto(domain);
	}
	
	@Override
	protected ItemDTO convertDomainToDto(ItemDomain domain) {
		final ItemDTO part = new ItemDTO();
		part.setId(domain.getId());
		part.setName(domain.getName());
		part.setDescription(domain.getDescription());
		part.setPrice(domain.getPrice());
		part.setQuantity(domain.getQuantity());
		return part;
	}

	@Override
	protected ItemDomain convertDtoToDomain(ItemDTO dto) {
		final ItemDomain item = new ItemDomain();
		item.setId(dto.getId());
		item.setName(dto.getName());
		item.setDescription(dto.getDescription());
		item.setPrice(dto.getPrice());
		item.setQuantity(dto.getQuantity());
		return item;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemResult find(String textToFind, int page, int maxItems) throws Exception {
		final List<ItemDTO> items = new ArrayList<>();
		for (ItemDomain domain : itemDao.find(textToFind, page, maxItems)) {
			final ItemDTO dto = convertDomainToDto(domain);
			items.add(dto);
		}
		final ItemResult itemResult = new ItemResult();
		itemResult.setItems(items);
		return itemResult;
	}

}
