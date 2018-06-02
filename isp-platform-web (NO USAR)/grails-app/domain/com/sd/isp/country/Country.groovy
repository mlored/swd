package com.sd.isp.country

import com.sd.isp.state.State

class Country {

	String name;
	static hasMany = [states:State]
	static constraints = {
		name blank:false, size:3..50
	}
}
