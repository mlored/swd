<div class="box-body">
    <div class="form-group ${hasErrors(bean: partInstance, field: 'number', 'error')} required">
        <label for="name">
            <g:message code="part.name.label" default="Nombre" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="name" class="form-control" maxlength="50"  placeholder="Nombre" required="" value="${partInstance?.name}" autofocus="autofocus" />
    </div>
    <div class="form-group ${hasErrors(bean: partInstance, field: 'number', 'error')} required">
        <label for="description">
            <g:message code="part.description.label" default="Descripción" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="description" class="form-control" maxlength="50" placeholder="Descripción" required="" value="${partInstance?.description}"/>
    </div>
    <div class="form-group ${hasErrors(bean: partInstance, field: 'number', 'error')} required">
        <label for="price">
            <g:message code="part.price.label" default="Precio" />
            <span class="required-indicator">*</span>
        </label>
        <g:field name="price" type="number" class="form-control" maxlength="15"  placeholder="Precio" value="${partInstance?.price}" required=""/>
    </div>
    <div class="form-group ${hasErrors(bean: partInstance, field: 'number', 'error')} required">
        <label for="quantity">
            <g:message code="part.quantity.label" default="Cantidad" />
            <span class="required-indicator">*</span>
        </label>
        <g:field name="quantity" type="number" class="form-control"  placeholder="Cantidad" maxlength="10" value="${partInstance?.quantity}" required=""/>
    </div>
</div>
<!-- /.box-body -->