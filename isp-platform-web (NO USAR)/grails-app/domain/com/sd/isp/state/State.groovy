package com.sd.isp.state

import com.sd.isp.city.City
import com.sd.isp.country.Country

class State {

	static belongsTo = [country:Country]
	static hasMany = [cities:City]
	String name;
	static constraints = {
		name blank:false, size:3..50
	}
}
