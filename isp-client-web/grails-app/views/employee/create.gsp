<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employees')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="create-employee" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${employeeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${employeeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:employeeInstance, action:'save']" >
				<fieldset class="form">
				<g:render template="form"/>
			<br>
				<button class="btn btn-primary"><i class="fa fa-floppy-o"></i> Crear</button>
		    </g:form>
		</div>
	</body>
</html>
