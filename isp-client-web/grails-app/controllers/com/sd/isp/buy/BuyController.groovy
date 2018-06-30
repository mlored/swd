package com.sd.isp.buy



import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.buy.BuyB
import com.sd.isp.service.buy.IBuyService
import com.sd.isp.service.car.ICarService;

import grails.transaction.Transactional

@Transactional(readOnly = true)
class BuyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	IBuyService buyService

    def list(Integer max) {
		def buys = buyService.getAll()

		[buyInstanceList: buys, buyInstanceTotal: buys?.size()]
	}

  /*  def show(Buy buyInstance) {
        respond buyInstance
    }*/

    def create() {
         [buyInstance: new BuyB(params)]
    }

    @Transactional
    def save(BuyB buyInstance) {
        if (buyInstance == null) {
            notFound()
            return
        }

        if (buyInstance.hasErrors()) {
            respond buyInstance.errors, view:'create'
            return
        }

        buyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'buy.label', default: 'Buy'), buyInstance.id])
                redirect buyInstance
            }
            '*' { respond buyInstance, [status: CREATED] }
        }
    }

    def edit(BuyB buyInstance) {
        respond buyInstance
    }

    @Transactional
    def update(BuyB buyInstance) {
        if (buyInstance == null) {
            notFound()
            return
        }

        if (buyInstance.hasErrors()) {
            respond buyInstance.errors, view:'edit'
            return
        }

        buyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Buy.label', default: 'Buy'), buyInstance.id])
                redirect buyInstance
            }
            '*'{ respond buyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BuyB buyInstance) {

        if (buyInstance == null) {
            notFound()
            return
        }

        buyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Buy.label', default: 'Buy'), buyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'buy.label', default: 'Buy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
