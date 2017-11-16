package com.sd.isp.service.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.part.PartB;
import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.rest.part.IPartResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.part.IPartService;

@Service("partService")
public class PartServiceImpl extends BaseServiceImpl<PartB, PartDTO>
        implements IPartService {

    @Autowired
    private IPartResource _partResource;


    public PartServiceImpl() {
    }

    @Override
    public PartB save(PartB bean) {
        final PartDTO part = convertBeanToDto(bean);
        final PartDTO dto = _partResource.save(part);
        final PartB partB = convertDtoToBean(dto);
        return partB;
    }

    @Override
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
    public PartB getById(Integer id) {
        final PartDTO dto = _partResource.getById(id);
        final PartB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public PartB delete(Integer id) {
        return null;
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
    
}