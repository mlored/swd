package com.sd.isp.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.support.SupportB;
import com.sd.isp.dto.support.SupportDTO;
import com.sd.isp.rest.support.SupportResourceImpl;
import com.sd.isp.rest.support.ISupportResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("supportService")
public class SupportServiceImpl extends BaseServiceImpl<SupportB, SupportDTO> implements ISupportService{
    @Autowired
    private ISupportResource _supportResource = new SupportResourceImpl();

    public SupportServiceImpl() {

    }

    @CacheEvict(value=CACHE_REGION,key = "'supports'")
    @CachePut(value=CACHE_REGION, key="'supports' + #bean.id")
    public SupportB save(SupportB bean) {
        final SupportDTO support = convertBeanToDto(bean);
        final SupportDTO dto = _supportResource.save(support);
        final SupportB supportB = convertDtoToBean(dto);
        return supportB;
    }



    public SupportB convertDtoToBean(SupportDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("userName", dto.getName());
        params.put("subject", dto.getSubject());
        params.put("message", dto.getMessage());
        params.put("email", dto.getEmail());
        params.put("phone", dto.getPhone());
        final SupportB supportB = new SupportB(params);
        return supportB;
    }

    public SupportDTO convertBeanToDto(SupportB bean) {
        final SupportDTO dto = new SupportDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getUserName());
        dto.setSubject(bean.getSubject());
        dto.setMessage(bean.getMessage());
        dto.setEmail(bean.getEmail());
        dto.setPhone(bean.getPhone());
        return dto;
    }

    @Override
    public List<SupportB> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public SupportB getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SupportB update(Integer id, SupportB bean) {
        return null;
    }

    @Override
    public SupportB delete(Integer id) {
        return null;
    }
    
    public List<SupportB> find (String textToFind, int maxItems, int page) {
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
