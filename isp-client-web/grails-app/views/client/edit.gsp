<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'client.label', default: 'Cliente')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="edit-client" class="content scaffold-edit" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${clientInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${clientInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements -->
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title"><g:message code="default.edit.label" args="[entityName]" /></h3>
							</div>
							<g:form url="[resource:clientInstance, action:'update']" method="PUT"  name="form" novalidate="true" >
								<fieldset class="form">
									<g:render template="form"/>
								</fieldset>
								<fieldset class="box-footer">
									<g:actionSubmit  class="btn btn-primary" value="Actualizar" action="update" />
								</fieldset>
							</g:form>
						<!-- /.box-header -->
						<!-- form start -->
						</div>
						<!-- /.box -->
					</div>
				</div>
			</section>
		</div>
	</body>
</html>
