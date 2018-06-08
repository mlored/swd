package com.sd.isp.secure

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

class SecureController {

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def index() {

		if (SpringSecurityUtils.ifAllGranted('ROLE_SUPERUSER')) {
			redirect controller: 'secure', action: 'index_admin'
			return
		}

		if (SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')) {
			redirect controller: 'secure', action: 'index_admin'
			return
		}

	}

	@Secured(['permitAll'])
	def logout(){
		redirect uri: '/j_spring_security_logout'
	}

	@Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
	def index_admin() {
	}

}
