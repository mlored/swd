package com.sd.isp.support


import com.sd.isp.beans.support.SupportB
import com.sd.isp.service.support.ISupportService
import grails.plugin.springsecurity.annotation.Secured

class SupportController {

    static allowedMethods = [save: "POST"]
    ISupportService supportService

    def create(){}

    def save() {
        def supportInstance = new SupportB(params)
        def newSupport = supportService.save(supportInstance)
        if (!newSupport?.getId()) {
            render "Mensaje enviado"
        }
        //flash.message = message(code: 'default.created.message', args: [message(code: 'support.label', default: 'Support'), newSupport.getId()])
        render "Mensaje enviado"
    }

}
