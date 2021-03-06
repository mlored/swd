package com.sd.isp.part

import com.sd.isp.beans.part.PartB
import com.sd.isp.service.part.IPartService
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import org.springframework.dao.DataIntegrityViolationException
class PartController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    IPartService partService

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def create() {
        respond new PartB(params)
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def list(Integer max) {
        //def parts = partService.getAll()

        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text

        def search = ""
        def parts = null

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
            parts 	  = partService.find(search,10,page)
            siguiente = partService.find(search,10,page+1)
        }else{
            parts     = partService.find(null,10,page)
            siguiente = partService.find(null,10,page+1)
        }

        if (request.getHeader('X-Requested-With')) {
            respond parts, formats: ['json']
        } else {
            [partInstanceList: parts, partInstanceTotal: parts?.size(),
             page: page,
             siguiente: siguiente?.size(),
             ppartInstanceList: partService.getAll(),
             text: text/*,user:authService.getName()*/]
        }
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def save(){
        def partInstance = new PartB(params)
        def newPart = partService.save(partInstance)
        if (!newPart?.getId()) {
            render(view: "create", model: [partInstance: partInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'part.label', default: 'Part'),
                newPart.getId()
        ])
        redirect(action: "index")

    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def edit(Long id) {
        def partInstance = partService.getById(id.intValue())
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [partInstance: partInstance]
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO"])
    def update(Long id) {
        def partB= new PartB(params)
        def partInstance = partService.update(id.intValue(), partB)
        if (partInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'part.label', default: 'Part'),
                partInstance.id
        ])
        redirect(action: "list")
    }
    @Secured(["ROLE_ADMIN"])
    def delete(Long id) {

        try {
            partService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "show", id: id)
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
