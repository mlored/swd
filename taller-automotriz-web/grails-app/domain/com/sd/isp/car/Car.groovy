package com.sd.isp.car
import com.sd.isp.beans.car.CarB

public class Car {
    String  mark
    String  model
    Integer  year
    String  color

    static constraints = {
        mark 	   blank:false, size:3..50
        model      blank:false, size:3..50
        year       blank:false, size:1..10
        color      blank:false, size:1..100
    }

    public Car(CarB car){
        this.id 	 = car.getId()
        this.mark 	 = car.getMark()
        this.model   = car.getModel()
        this.year    = Integer.parseInt(car.getYear())
        this.color   = car.color()

    }
}