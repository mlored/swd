package com.sd.isp.car

import org.springframework.dao.DataIntegrityViolationException

import com.sd.isp.beans.car.CarB
import com.sd.isp.service.car.ICarService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CarsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    ICarService carService


    def create() {
        [carInstance: new CarB(params)]
    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond Car.list(params), model:[carsInstanceCount: Cars.count()]
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def cars = carService.getAll()

        [carInstanceList: cars, carInstanceTotal: cars?.size()]
    }

    

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cars.label', default: 'Cars'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
