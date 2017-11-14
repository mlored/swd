
<!-- <%@ page import="com.sd.isp.employee.Employee" %>-->
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employee" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employee">
			
				<g:if test="${employeeInstance?.number}">
					<li class="fieldcontain">
						<span id="number-label" class="property-label"><g:message code="employee.number.label" default="Number" /></span>
						
						   <span class="property-value" aria-labelledby="number-label"><g:fieldValue bean="${employeeInstance}" field="number"/></span>
						
					</li>
			    </g:if>
			
				<g:if test="${employeeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="employee.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${employeeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.surName}">
				<li class="fieldcontain">
					<span id="surName-label" class="property-label"><g:message code="employee.surName.label" default="SurName" /></span>
					
						<span class="property-value" aria-labelledby="surName-label"><g:fieldValue bean="${employeeInstance}" field="surName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.ruc}">
				<li class="fieldcontain">
					<span id="ruc-label" class="property-label"><g:message code="employee.ruc.label" default="Ruc" /></span>
					
						<span class="property-value" aria-labelledby="ruc-label"><g:fieldValue bean="${employeeInstance}" field="ruc"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${employeeInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="employee.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${employeeInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.cellphone}">
				<li class="fieldcontain">
					<span id="cellphone-label" class="property-label"><g:message code="employee.cellphone.label" default="Cellphone" /></span>
					
						<span class="property-value" aria-labelledby="cellphone-label"><g:fieldValue bean="${employeeInstance}" field="cellphone"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:employeeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${employeeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
