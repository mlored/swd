package com.sd.isp.stock

import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.part.PartB
import com.sd.isp.service.part.IPartService;

import grails.transaction.Transactional

@Transactional(readOnly = true)
class StockController {


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	IPartService partService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond Part.list(params), model:[partInstanceCount: Part.count()]
		redirect(action: "list", params: params)
    }
	
	def list(Integer max) {
		def parts = partService.getAll()

		[partInstanceList: parts, partInstanceTotal: parts?.size()]
	}
	
	def show(PartB partInstance) {
		respond partInstance
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
