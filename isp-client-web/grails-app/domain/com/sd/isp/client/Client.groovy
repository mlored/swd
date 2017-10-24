package com.sd.isp.client


class Client {
	String firstName
	String lastName
	String document

	static constraints = {
		firstName blank:false, size:3..50
		lastName blank: false, size:3..50
		document blank:false, size:1..10
	}
}
