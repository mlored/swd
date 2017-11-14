package com.sd.isp.service
import com.sd.isp.beans.service.ServiceB
class Service {
    String  name
    String  description
    Integer  price
    Integer quantity

    static constraints = {
        name 	      blank:false, size:3..50
        description   blank: false, size:3..50
        price         blank:false, size:1..10
        quantity      blank:false, size:1..10
    }
    public Service(ServiceB service){
        this.id 	      = service.getId()
        this.name 	      = service.getName()
        this.description  = service.getDescription()
        this.price        = Integer.parseInt(service.getPrice())
        this.quantity     = Integer.parseInt(service.getQuantity())
    }
}
