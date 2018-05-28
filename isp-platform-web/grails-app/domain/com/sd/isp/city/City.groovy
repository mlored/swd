package com.sd.isp.city

import com.sd.isp.state.State

class City {

	String name;
	static belongsTo = [state:State]
	static constraints = {
		name blank:false, size:3..50
	}
}
