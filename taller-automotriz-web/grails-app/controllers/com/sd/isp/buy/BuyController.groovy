package com.sd.isp.buy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BuyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Buy.list(params), model:[buyCount: Buy.count()]
    }

    def show(Buy buy) {
        respond buy
    }

    def create() {
        respond new Buy(params)
    }

    @Transactional
    def save(Buy buy) {
        if (buy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (buy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond buy.errors, view:'create'
            return
        }

        buy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'buy.label', default: 'Buy'), buy.id])
                redirect buy
            }
            '*' { respond buy, [status: CREATED] }
        }
    }

    def edit(Buy buy) {
        respond buy
    }

    @Transactional
    def update(Buy buy) {
        if (buy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (buy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond buy.errors, view:'edit'
            return
        }

        buy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'buy.label', default: 'Buy'), buy.id])
                redirect buy
            }
            '*'{ respond buy, [status: OK] }
        }
    }

    @Transactional
    def delete(Buy buy) {

        if (buy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        buy.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'buy.label', default: 'Buy'), buy.id])
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
