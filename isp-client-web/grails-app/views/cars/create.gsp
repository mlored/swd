<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'cars.label', default: 'Cars')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<!-- general form elements -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Nuevo Auto</h3>
						</div>
					<!-- /.box-header -->
					<!-- form start -->
						<g:if test="${flash.message}">
							<div class="message" role="status">${flash.message}</div>
						</g:if>
						<g:hasErrors bean="${carInstance}">
							<ul class="errors" role="alert">
								<g:eachError bean="${carInstance}" var="error">
									<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
								</g:eachError>
							</ul>
						</g:hasErrors>
						<g:form id="form_cars" url="[action:'save', method:'post']" novalidate="true">
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="box-footer">
								<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
							</fieldset>
						</g:form>
					</div>
					<script>
                        $( document ).ready(function() {
                            $("#form_cars").validate({
                                rules: {
                                    mark: {
                                        remote: {
                                            url: "find",
                                            type: "get",
                                            data: {
                                                mark: function() {
                                                    return $( "#mark" ).val();
                                                }
                                            }
                                        }
                                    }
                                }
							});
                        });
					</script>
					<!-- /.box -->
				</div>
			</div>
		</section>
	</body>

</html>
