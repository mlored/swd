package com.sd.isp.supplier
import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.supplier.SupplierB
//import com.sd.isp.supplier.Supplier;
import com.sd.isp.service.supplier.ISupplierService;
import com.sd.isp.service.supplier.ISupplierService

import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class SupplierController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	ISupplierService supplierService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		redirect(action: "list", params: params)
    }
	
	def list(Integer max) {
		def suppliers = supplierService.getAll()

		[supplierInstanceList: suppliers, supplierInstanceTotal: suppliers?.size()]
	}

   /* def show(Supplier supplierInstance) {
        respond supplierInstance
    }*/

    def create() {
        [supplierInstance: new SupplierB(params)]
    }

    @Transactional
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

    @Transactional
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
    @Transactional
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
