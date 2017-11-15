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

    def save() {
        def carInstance = new CarB(params)
        def newCar = carService.save(carInstance)
        if (!newCar?.getId()) {
            render(view: "create", model: [carInstance: carInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'car.label', default: 'Car'),
                newCar.getId()
        ])
        redirect(action: "show", id: newCar.getId())
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def cars = carService.getAll()
        [carInstanceList: cars, carInstanceTotal: cars?.size()]
    }

    def show(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Country'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [carInstance: carInstance]
    }

    def edit(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Country'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [carInstance: carInstance]
    }

    def update(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Country'),
                    id
            ])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (carInstance.version > version) {
                carInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'car.label', default: 'Country')] as Object[],
                        "Another user has updated this Country while you were editing")
                render(view: "edit", model: [carInstance: carInstance])
                return
            }
        }

        carInstance.properties = params

        if (!carInstance.save(flush: true)) {
            render(view: "edit", model: [carInstance: carInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'car.label', default: 'Country'),
                carInstance.id
        ])
        redirect(action: "show", id: carInstance.id)
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
