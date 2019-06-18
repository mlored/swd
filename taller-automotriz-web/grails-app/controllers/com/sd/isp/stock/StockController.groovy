package com.sd.isp.stock

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.part.PartB
import com.sd.isp.service.part.IPartService;

import grails.transaction.Transactional

class StockController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	IPartService partService

	@Secured(["ROLE_SECRETARIO","ROLE_MECANICO", "ROLE_ADMIN"])
	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond Part.list(params), model:[partInstanceCount: Part.count()]
		redirect(action: "list", params: params)
    }
	@Secured(["ROLE_SECRETARIO","ROLE_MECANICO", "ROLE_ADMIN"])
	def list(Integer max) {
		//def parts = partService.getAll()
		//[partInstanceList: parts, partInstanceTotal: parts?.size()]
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
	
	
			[partInstanceList: parts, partInstanceTotal: parts?.size(),
											  page: page,
											  siguiente: siguiente?.size(),
											  ppartInstanceList: partService.getAll(),
											  text: text/*,
											  user:authService.getName()*/]
		}

	/*def show(PartB partInstance) {
		respond partInstance
	}*/

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
