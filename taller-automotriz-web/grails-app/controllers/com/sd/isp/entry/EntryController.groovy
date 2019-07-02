package com.sd.isp.entry

import com.sd.isp.service.part.IPartService
import com.sd.isp.beans.entry.EntryB
import com.sd.isp.service.client.IClientService
import com.sd.isp.service.entry.IEntryService
import com.sd.isp.service.entry_details.IEntryDetailsService
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
class EntryController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    IEntryService 	     entryService
    IEntryDetailsService entryDetailsService
    IPartService 	     partService
    IClientService       clientService
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def index(Integer max){
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }
//@Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
  /*  def list(Integer max) {
        def entries = entryService.getAll()

        [entryInstanceList: entries, serviceInstanceTotal: entries?.size()]
    }*/

    @Secured(["ROLE_SECRETARIO","ROLE_MECANICO", "ROLE_ADMIN"])
    def list(Integer max) {
        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text

        def search = ""
        def entries = null

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
            entries = entryService.find(search,10,page)
            siguiente = entryService.find(search,10,page+1)
        }else{
            entries = entryService.find(null,10,page)
            siguiente = entryService.find(null,10,page+1)
        }

        if (request.getHeader('X-Requested-With')) {
            respond entries, formats: ['json']
        } else {
            [entryInstanceList: entries, entryInstanceTotal: entries?.size(),
             page: page,
             siguiente: siguiente?.size(),
             entryInstanceList: entryService.getAll(),
             text: text]
        }
    }

    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def create() {
        [entryInstance: new EntryB(params)]
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def save() {
        def newEntry = new EntryB(params)
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //newEntry.setDate(dateFormat.parse(dateFormat.format(new Date())));
        //newEntry.setDiagno
        def entryInstance = entryService.save(newEntry)

       // def entryDetailsInstance = new EntryDetailsB(params)
        


        if (!entryInstance.getId()) {
            render(view: "create", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'entry.label', default: 'Entry'),
                entryInstance.getId()
        ])
        redirect(action: "index")
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def show(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance, cars: entryService.getAll()]
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def edit(Long id) {
        def entryInstance = entryService.getById(id.intValue())

        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [entryInstance: entryInstance]
    }
    @Secured(["ROLE_ADMIN","ROLE_SECRETARIO","ROLE_MECANICO"])
    def update(Long id) {
        def entryB = new EntryB(params)
        def entryInstance = entryService.update(id.intValue(), entryB)
        if (entryInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entrada'),
                    id
            ])
            redirect(action: "list")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'entry.label', default: 'Entrada'),
                entryInstance.id
        ])
        redirect(action: "list")
    }
    @Secured(["ROLE_ADMIN"])
    def delete(Long id) {

        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
            return
        }

        try {
            entryService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
        }
        catch (Exception e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}




