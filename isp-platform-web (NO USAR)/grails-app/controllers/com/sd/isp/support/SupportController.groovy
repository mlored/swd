package com.sd.isp.support


import com.sd.isp.beans.support.SupportB
import com.sd.isp.service.support.ISupportService


class SupportController {

    static allowedMethods = [save: "POST"]
    //services
    def ISupportService supportService
    //def ILaboratoryService laboratoryService
    //@Autowired def IAuthService authService

    def create(){

    }


    def save() {
        def supportInstance = new SupportB(params)
        def newSupport = supportService.save(supportInstance)
        if (!newSupport?.getId()) {
            render(view: "create", model: [supportInstance: supportInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'support.label', default: 'Support'), newSupport.getId()])
        redirect(uri: "/")
    }

}
