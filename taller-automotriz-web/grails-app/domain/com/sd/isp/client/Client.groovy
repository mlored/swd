package com.sd.isp.client

import com.sd.isp.beans.client.ClientB

class Client {
    String  name
    String  surName
    String  ruc
    String  address
    Integer cellphone

    static constraints = {
        name 	   blank:false, size:3..50
        surName   blank: false, size:3..50
        ruc       blank:false, size:1..10
        address   blank:false, size:1..100
        cellphone blank:false, size:1..10
    }
    public Client(ClientB client){
        this.id 	    = client.getId()
        this.name 	    = client.getName()
        this.surName   = client.getSurName()
        this.ruc       = client.getRuc()
        this.address   = client.getAddress()
        this.cellphone = Integer.parseInt(client.getCellphone())
    }
}
