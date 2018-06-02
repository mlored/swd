package com.sd.isp.buy

import com.sd.isp.beans.buy.BuyB
import com.sd.isp.beans.supplier.SupplierB

class Buy {
		Date    date
		Integer number
		Integer total
		 
	static constraints = {
		date    blank:false,  size:3..50
		number  blank: false, size:1..50
		total   blank:false,  size:1..10
	}
	
	public Buy(BuyB buy){
		this.id 	  = buy.getId()
		this.date 	  = buy.getDate()
		this.number   = Integer.parseInt(buy.getNumber())
		this.total    = Integer.parseInt(buy.getTotal())
	}

}
