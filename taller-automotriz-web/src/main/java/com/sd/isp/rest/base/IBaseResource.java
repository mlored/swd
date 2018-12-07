package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.base.BaseResult;

public interface IBaseResource<DTO extends BaseDTO, Result extends BaseResult> {

    public Result getAll();

    public DTO save(DTO dto);

    public DTO getById(Integer id);

    public DTO update(Integer id, DTO dto);

    public DTO destroy(Integer id);

    public Result findWR(String textToFind, int maxItems, int page);

}
