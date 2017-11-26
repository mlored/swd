package com.sd.isp.entry_details

import com.sd.isp.entry.Entry

class EntryDetails {
    Date date

    static belongsTo = [entry:Entry]

    static constraints = {
        date blank: false, size: 1..10

    }
}
