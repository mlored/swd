package com.sd.isp.part
import com.sd.isp.beans.part.PartB

class Part {
    String  name
    String  description
    Integer price
    Integer quantity

    static constraints = {
        name 	      blank:false, size:3..50
        description   blank: false, size:3..50
        price         blank:false, size:1..10
        quantity      blank:false, size:1..10
    }
    public Part(PartB part){
        this.id 	      = part.getId()
        this.name 	      = part.getName()
        this.description  = part.getDescription()
        this.price        = Integer.parseInt(part.getPrice())
        this.quantity     = Integer.parseInt(part.getQuantity())
    }
}