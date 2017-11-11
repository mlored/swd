package com.sd.isp.car

class Cars {
    String mark
    String model
    int number
    String color

    static constraints = {
        mark blank:false, size:3..50
        model blank: false, size:3..50
        number blank:false, size:1..10
        color blank:false, size:1..10
    }
}
