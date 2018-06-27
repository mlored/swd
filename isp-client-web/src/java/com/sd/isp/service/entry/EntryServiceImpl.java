package com.sd.isp.service.entry;

import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.beans.entry_details.EntryDetailsB;
import com.sd.isp.beans.item.ItemB;
import com.sd.isp.beans.service.ServiceB;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.rest.entry.IEntryResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.car.CarServiceImpl;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.client.IClientService;
import com.sd.isp.service.client.ClientServiceImpl;

import com.sd.isp.service.client.IClientService;
import com.sd.isp.service.car.ICarService;
import com.sd.isp.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;


@Service("entryService")
public class EntryServiceImpl extends BaseServiceImpl<EntryB, EntryDTO>
        implements IEntryService {

    @Autowired
    private IEntryResource entryResource;
    @Autowired
    private ICarService carResource;
    @Autowired
    private IClientService clientResource;


    public EntryServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'entries'")
    @CachePut(value=CACHE_REGION, key="'entries' + #bean.id")
    public EntryB save(EntryB bean) {
        final EntryDTO entry = convertBeanToDto(bean);
        final EntryDTO dto = entryResource.save(entry);
        final EntryB entryB = convertDtoToBean(dto);
        return entryB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'entries'")
    public List<EntryB> getAll() {
        final EntryResult result = entryResource.getAll();
        final List<EntryDTO> cList = null == result.getEntry() ? new ArrayList<EntryDTO>()
                : result.getEntry();
        final List<EntryB> entries = new ArrayList<EntryB>();
        for (EntryDTO dto : cList) {
            final EntryB bean = convertDtoToBean(dto);
            bean.setCar(carResource.getById(dto.getCarId()));
            bean.setCliente(clientResource.getById(dto.getClientId()));
            entries.add(bean);
        }
        return entries;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'entries' + #id")
    public EntryB getById(Integer id) {
        final EntryDTO dto = entryResource.getById(id);
        final EntryB bean = convertDtoToBean(dto);
        bean.setCar(carResource.getById(dto.getCarId()));
        bean.setCliente(clientResource.getById(dto.getClientId()));

        return bean;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'entries'")
    @CachePut(value=CACHE_REGION, key="'entries' + #id")
	public EntryB update(Integer id,  EntryB entryB) {
    	final EntryDTO entry   = convertBeanToDto(entryB);
        final EntryDTO dto     = entryResource.update(id, entry);
        final EntryB bean      = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'entries'"),
            @CacheEvict(value=CACHE_REGION, key = "'entries' + #id")})
    public EntryB delete(Integer id) {
        final EntryDTO dto = entryResource.destroy(id);
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
        params.put("carId", String.valueOf(dto.getCarId()));
        params.put("clientId", String.valueOf(dto.getClientId()));

        final EntryB entryB = new EntryB(params);
        entryB.setCarId(dto.getCarId());
        entryB.setClientId(dto.getClientId());
        entryB.setDate(dto.getDate());

        ArrayList<EntryDetailsB> l = new ArrayList<EntryDetailsB>();
        for (EntryDetailsDTO d : dto.getEntryDetails()){
            l.add(convertDtoToBean(d));
        }
        entryB.setEntryDetails(l);

        return entryB;
    }

    protected EntryDetailsB convertDtoToBean(EntryDetailsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", String.valueOf(dto.getDate()));
        params.put("itemId", String.valueOf(dto.getItemId()));

        final EntryDetailsB entryDetailsB = new EntryDetailsB(params);
        entryDetailsB.setDate(dto.getDate());
        entryDetailsB.setItem(convertDtoToBean(dto.getItem()));
        entryDetailsB.setItemId(dto.getItemId());

        return entryDetailsB;
    }

    protected ItemB convertDtoToBean(ItemDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("description", dto.getDescription());
        params.put("price", String.valueOf(dto.getPrice()));
        params.put("quantity", String.valueOf(dto.getQuantity()));

        final ItemB itemB = new ItemB(params);

        return itemB;
    }

    @Override
    protected EntryDTO convertBeanToDto(EntryB bean) {
        final EntryDTO dto = new EntryDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());
        dto.setNumber(bean.getNumber());
        dto.setDiagnostic(bean.getDiagnostic());
        dto.setCarId(bean.getCarId());
        dto.setClientId(bean.getClientId());

        List<EntryDetailsDTO> l = new ArrayList();
        for (EntryDetailsB e : bean.getEntryDetails()){
           l.add(convertBeanToDto(e));
        }
        dto.setEntryDetails(l);

        return dto;
    }

    protected EntryDetailsDTO convertBeanToDto(EntryDetailsB bean) {
        final EntryDetailsDTO dto = new EntryDetailsDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());
        dto.setItemId(bean.getItemId());

        return dto;
    }

    public List<EntryB> find (String textToFind, int maxItems, int page) {
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
