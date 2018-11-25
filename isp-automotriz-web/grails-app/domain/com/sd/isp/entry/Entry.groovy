package com.sd.isp.entry

import com.sd.isp.beans.car.CarB
import com.sd.isp.beans.client.ClientB
import com.sd.isp.entry_details.EntryDetails

class Entry {
    Date date
    String diagnostic
    Integer number


    static hasMany = [entry_details:EntryDetails]

    static belongsTo = [car: CarB, client: ClientB]

    static constraints = {
        date blank: false, size: 2..10
        diagnostic blank: false, size: 2..50
        number nullable: false, size: 2..20

    }
}
