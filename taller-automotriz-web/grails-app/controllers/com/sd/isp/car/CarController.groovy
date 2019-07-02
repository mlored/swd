package com.sd.isp.car

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.dao.DataIntegrityViolationException
import com.sd.isp.beans.car.CarB
import com.sd.isp.service.car.ICarService
import static org.springframework.http.HttpStatus.*
class CarController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    ICarService carService

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def create() {
        [carInstance: new CarB(params)]
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
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

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    @Secured(["ROLE_SECRETARIO","ROLE_MECANICO", "ROLE_ADMIN"])
    def list(Integer max) {
        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text

        def search = ""
        def cars = null

        if(null!=params.get("text") && !"".equals(params.get("text")) && !"null".equals(params.get("text"))){
            search += "text="+params.text+'&'
        }
        if(null!=params.get("sort") && !"".equals(params.get("sort")) && !"null".equals(params.get("sort"))){
            search +="sort="+params.get("sort")+'&'
        }
        if(null!=params.get("order") && !"".equals(params.get("order")) && !"null".equals(params.get("order"))){
            search +="order="+params.get("order")+'&'
        }

        if(null != search && !"".equals(search)){
            cars = carService.find(search,10,page)
            siguiente = carService.find(search,10,page+1)
        }else{
            cars = carService.find(null,10,page)
            siguiente = carService.find(null,10,page+1)
        }

        if (request.getHeader('X-Requested-With')) {
            respond cars, formats: ['json']
        } else {
            [carInstanceList: cars, carInstanceTotal: cars?.size(),
             page: page,
             siguiente: siguiente?.size(),
             ccarInstanceList: carService.getAll(),
             text: text/*,user:authService.getName()*/]
        }
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
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

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
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

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'car.label', default: 'Car'),
                carInstance.id
        ])
        redirect(action: "list")
    }

    @Secured(["ROLE_ADMIN"])
    def delete(Long id) {

        try {
            carService.delete(id.intValue())
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
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'car.label', default: 'Car'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
