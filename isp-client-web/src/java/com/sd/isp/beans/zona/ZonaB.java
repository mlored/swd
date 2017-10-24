/**
 * 
 */
package com.sd.isp.beans.zona;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class ZonaB extends BaseBean {

	public ZonaB(Map<String, String> params) {
		super(params);
	}

	private static final long serialVersionUID = 1L;
	private String _descripcion;

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (StringUtils.isBlank(params.get("id"))) {
			setId(generateId());
		} else {
			setId(Integer.valueOf(params.get("id")));
		}
		setDescripcion(params.get("description"));

	}

}
