


<div class="box-body">
<div class="form-group ${hasErrors(bean: serviceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="service.name.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" class="form-control" maxlength="15"  placeholder="Nombre" required="" value="${serviceInstance?.name}"/>

</div>

<div class="form-group ${hasErrors(bean: serviceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="service.description.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" class="form-control" maxlength="15"  placeholder="Descripcion" required="" value="${serviceInstance?.description}"/>

</div>

<div class="form-group ${hasErrors(bean: serviceInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="service.price.label" default="Precio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" class="form-control" maxlength="15"  placeholder="Precio" value="${serviceInstance?.price}" required=""/>

</div>
	<div class="form-group ${hasErrors(bean: serviceInstance, field: 'quantity', 'error')} required">
		<label for="quantity">
			<g:message code="service.quantity.label" default="Cantidad" />
			<span class="required-indicator">*</span>
		</label>
		<g:field name="quantity" type="number" class="form-control"  placeholder="Cantidad" maxlength="10" value="${serviceInstance?.quantity}" required=""/>
	</div>	


</div>
