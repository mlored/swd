package com.sd.isp.supplier

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.supplier.SupplierB
import com.sd.isp.service.supplier.ISupplierService

import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

class SupplierController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    ISupplierService supplierService

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def list(Integer max) {
        //def suppliers = supplierService.getAll()
        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text

        def search = ""
        def suppliers = null

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
            suppliers = supplierService.find(search,10,page)
            siguiente = supplierService.find(search,10,page+1)
        }else{
            suppliers = supplierService.find(null,10,page)
            siguiente = supplierService.find(null,10,page+1)
        }


        [supplierInstanceList: suppliers, supplierInstanceTotal: suppliers?.size(),
         page: page,
         siguiente: siguiente?.size(),
         ssupplierInstanceList: supplierService.getAll(),
         text: text/*,
										  user:authService.getName()*/]

        //[supplierInstanceList: suppliers, supplierInstanceTotal: suppliers?.size()]
    }

    /* def show(Supplier supplierInstance) {
         respond supplierInstance
     }*/

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def create() {
        [supplierInstance: new SupplierB(params)]
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def save() {
        def supplierInstance = new SupplierB(params)
        def newSupplier = supplierService.save(supplierInstance)
        if (!newSupplier?.getId()) {
            render(view: "create", model: [supplierInstance: supplierInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'supplier.label', default: 'Supplier'),
                newSupplier.getId()
        ])
        redirect(action: "index")
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def edit(Long id) {
        def supplierInstance = supplierService.getById(id.intValue())
        if (!supplierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'supplier.label', default: 'Supplier'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [supplierInstance: supplierInstance]
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def update(Long id) {
        def supplierB= new SupplierB(params)
        def supplierInstance = supplierService.update(id.intValue(), supplierB)
        if (supplierInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'supplier.label', default: 'Supplier'),
                    id
            ])
            redirect(action: "list")
            return
        }

        /*if (!supplierInstance.save(flush: true)) {
            render(view: "edit", model: [supplierInstance: supplierInstance])
            return
        }*/

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'supplier.label', default: 'Supplier'),
                supplierInstance.id
        ])
        redirect(action: "list")
    }
    @Secured(["ROLE_ADMIN"])
    def delete(Long id) {

        try {
            supplierService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'supplier.label', default: 'Supplier'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'supplier.label', default: 'Supplier'),
                    id
            ])
            redirect(action: "show", id: id)
        }

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'supplier.label', default: 'Supplier'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
