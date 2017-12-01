package com.sd.isp.entry_details

import com.sd.isp.entry.Entry
import com.sd.isp.part.Part

class EntryDetails {
    Date date

    static belongsTo = [part: Part, entry:Entry ]

    static constraints = {
        date blank: false, size: 1..10

    }
}
