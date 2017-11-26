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
        redirect(action: "index")
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def cars = carService.getAll()
        [carInstanceList: cars, carInstanceTotal: cars?.size()]
    }

    /*def show(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [carInstance: carInstance]
    }*/

    def edit(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [carInstance: carInstance]
    }

    def update(Long id) {
        def carB= new CarB(params)
        def carInstance = carService.update(id.intValue(), carB)
        if (carInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        /*if (!carInstance.save(flush: true)) {
            render(view: "edit", model: [carInstance: carInstance])
            return
        }*/

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'car.label', default: 'Car'),
                carInstance.id
        ])
        redirect(action: "list")
    }

    def delete(Long id) {
        def carInstance = carService.getById(id.intValue())
        if (!carInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        try {
            carService.delete(carInstance?.id)
            carInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'car.label', default: 'Car'),
                    id
            ])
            redirect(action: "show", id: id)
        }
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
