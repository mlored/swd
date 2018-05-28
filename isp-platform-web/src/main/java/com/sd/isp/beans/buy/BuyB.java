package com.sd.isp.beans.buy;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class BuyB extends BaseBean {
	
	private static final long serialVersionUID = 1L;
    private Date _date;
    private Integer _number;
    private Integer _total;
    
	public BuyB(Map<String, String> params) {
        super(params);
    }
	
/*	@OneToMany(mappedBy = "invoiceDomain")
    private List<InvoiceDetailsDomain> invoiceDetailsDomains;*/
	
	public Date getDate() {
		return _date;
	}
	
	public void setDate(Date date) {
		_date = date;
	}
	
	public Integer getNumber() {
		return _number;
	}

	public void setNumber(Integer number) {
		_number = number;
	}

	public Integer getTotal() {
		return _total;
	}

	public void setTotal(Integer total) {
		_total = total;
	}
	
	 @Override
	    protected void create(Map<String, String> params) {
	        if (!StringUtils.isBlank(params.get("id"))) {
	            setId(Integer.valueOf(params.get("id")));
	        }
	      //  setDate(params.get("mark"));
	        setNumber(Integer.valueOf(params.get("number")));
	        setTotal(Integer.valueOf(params.get("total")));

	    }
}
