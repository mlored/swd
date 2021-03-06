package com.sd.isp.service.base;

import java.text.ParseException;
import java.util.List;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.dto.base.BaseDTO;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
    public BEAN save(BEAN bean);

    public List<BEAN> getAll();

    public BEAN getById(Integer id);

    public BEAN update(Integer id, BEAN bean);

    public List <BEAN> find(String textToFind, int maxItems, int page);

    public BEAN delete(Integer id);

    public abstract BEAN convertDtoToBean(DTO dto);

    public abstract DTO convertBeanToDto(BEAN bean);
}
