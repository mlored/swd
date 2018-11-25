package com.sd.isp.supplier

import com.sd.isp.beans.supplier.SupplierB

class Supplier {
    String  name
    String  surName
    String  ruc
    String  address
    Integer cellphone

    static constraints = {
        name 	  blank:false, size:3..50
        surName   blank: false, size:3..50
        ruc       blank:false, size:1..10
        address   blank:false, size:1..100
        cellphone blank:false, size:1..10
    }

    public Supplier(SupplierB supplier){
        this.id 	   = supplier.getId()
        this.name 	   = supplier.getName()
        this.surName   = supplier.getSurName()
        this.ruc       = supplier.getRuc()
        this.address   = supplier.getAddress()
        this.cellphone = Integer.parseInt(supplier.getCellphone())
    }

}
