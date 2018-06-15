package com.sd.isp.service.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.part.PartB;
import com.sd.isp.beans.service.ServiceB;
import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.rest.part.IPartResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("partService")
public class PartServiceImpl extends BaseServiceImpl<PartB, PartDTO>
        implements IPartService {

    @Autowired
    private IPartResource _partResource;


    public PartServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'parts'")
    @CachePut(value=CACHE_REGION, key="'parts' + #bean.id")
    public PartB save(PartB bean) {
        final PartDTO part = convertBeanToDto(bean);
        final PartDTO dto = _partResource.save(part);
        final PartB partB = convertDtoToBean(dto);
        return partB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'parts'")
    public List<PartB> getAll() {
        final PartResult result = _partResource.getAll();
        final List<PartDTO> pList = null == result.getParts() ? new ArrayList<PartDTO>()
                : result.getParts();

        final List<PartB> parts = new ArrayList<PartB>();
        for (PartDTO dto : pList) {
            final PartB bean = convertDtoToBean(dto);
            parts.add(bean);
        }
        return parts;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'parts' + #id")
    public PartB getById(Integer id) {
        final PartDTO dto = _partResource.getById(id);
        final PartB bean = convertDtoToBean(dto);

        return bean;
    }

	@Override
    @CacheEvict(value=CACHE_REGION, key = "'parts'")
    @CachePut(value=CACHE_REGION, key="'parts' + #id")
	public PartB update(Integer id,  PartB partB) {
        final PartDTO part = convertBeanToDto(partB);
        final PartDTO dto  = _partResource.update(id, part);
        final PartB bean   = convertDtoToBean(dto);

        return bean;
    }
    
    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'parts'"),
            @CacheEvict(value=CACHE_REGION, key = "'parts' + #id")})
    public PartB delete(Integer id) {
        final PartDTO dto = _partResource.destroy(id);
        final PartB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected PartB convertDtoToBean(PartDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("description", dto.getDescription());
        params.put("price", String.valueOf(dto.getPrice()));
        params.put("quantity", String.valueOf(dto.getQuantity()));

        final PartB partB = new PartB(params);

        return partB;
    }

    @Override
    protected PartDTO convertBeanToDto(PartB bean) {
        final PartDTO dto = new PartDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        dto.setPrice(bean.getPrice());
        dto.setQuantity(bean.getQuantity());
        return dto;
    }
    
    public List<PartB> find (String textToFind, int maxItems, int page) {
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