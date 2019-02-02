<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'supplier.label', default: 'Proveedor')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title"><g:message code="default.edit.label" args="[entityName]" /></h3>
                </div>
            <!-- /.box-header -->
            <!-- form start -->
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:hasErrors bean="${supplierInstance}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${supplierInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <g:form action="update" method="POST" id="${supplierInstance?.id}" novalidate="true" name="form_suppliers">
                    <g:hiddenField name="id" value="${supplierInstance?.id}" />

                    <fieldset class="form">
                        <g:render template="form"/>
                    </fieldset>
                    <fieldset class="box-footer">
                        <g:actionSubmit  class="btn btn-primary" value="Actualizar" action="update" />
                    </fieldset>
                </g:form>
            </div>
            <script>
                $( document ).ready(function() {
                    $("#form_suppliers").validate({
                    });
                });
            </script>
            <!-- /.box -->
        </div>
    </div>
</section>
</body>
</html>
