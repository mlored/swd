package com.sd.isp.zona

class Zona {
	String descripcion
	static constraints = {
		descripcion blank:false, unique:true
	}
}
