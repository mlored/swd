package com.sd.isp.service.base;

import com.google.code.ssm.CacheFactory;
import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.dto.base.BaseDTO;
//import login.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

    public BaseServiceImpl() { }


    private String cacheName;

    //protected static MyBean myBean = new MyBean();

    protected static final String CACHE_REGION = "isp-client-web-cache";


}
