package com.sd.isp.dto.supplier;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "supplierResult")
public class SupplierResult extends BaseResult<SupplierDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SupplierDTO> getSuppliers() {
		return getList();
	}

	public void setSuppliers(List<SupplierDTO> dtos) {
		super.setList(dtos);
	}
}
