package com.sd.isp.service

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.service.ServiceB
import com.sd.isp.service.service.IServiceService;

import grails.transaction.Transactional

import org.springframework.dao.DataIntegrityViolationException

@Secured(["ROLE_ADMIN"])
class ServiceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    IServiceService serviceService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        //def service = serviceService.getAll()

        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text

        def search = ""
        def services = null

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
            services  = serviceService.find(search,10,page)
            siguiente = serviceService.find(search,10,page+1)
        }else{
            services  = serviceService.find(null,10,page)
            siguiente = serviceService.find(null,10,page+1)
        }


        [serviceInstanceList: services, serviceInstanceTotal: services?.size(),
         page: page,
         siguiente: siguiente?.size(),
         sserviceInstanceList: serviceService.getAll(),
         text: text/*,
										  user:authService.getName()*/]
    }

    /*def show(Long id) {
         def serviceInstance = serviceService.getById(id.intValue())
         if (!serviceInstance) {
             flash.message = message(code: 'default.not.found.message', args: [
                     message(code: 'service.label', default: 'Service'),
                     id
             ])
             redirect(action: "list")
             return
         }

         [serviceInstance: serviceInstance]
    }*/

    def create() {
        [serviceInstance: new ServiceB(params)]
    }

    def save(){
        def serviceInstance = new ServiceB(params)
        def newService = serviceService.save(serviceInstance)
        if (!newService?.getId()) {
            render(view: "create", model: [serviceInstance: serviceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'service.label', default: 'Service'),
                newService.getId()
        ])
        redirect(action: "index")

    }

    def edit(Long id) {
        def serviceInstance = serviceService.getById(id.intValue())
        if (!serviceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [serviceInstance: serviceInstance]
    }

    def update(Long id) {
        def serviceB= new ServiceB(params)
        def serviceInstance = serviceService.update(id.intValue(), serviceB)
        if (serviceInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'service.label', default: 'Service'),
                serviceInstance.id
        ])
        redirect(action: "list")
    }

    def delete(Long id) {

        try {
            serviceService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "show", id: id)
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'service.label', default: 'Service'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
