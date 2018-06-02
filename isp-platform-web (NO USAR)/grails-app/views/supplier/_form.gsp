
<div class="box-body">
	<div class="form-group ${hasErrors(bean: supplierInstance, field: 'number', 'error')}">
		<label for="name">
			<g:message code="supplier.name.label" default="Nombre" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="name" class="form-control" maxlength="50"  placeholder="Nombre" required="" value="${supplierInstance?.name}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: supplierInstance, field: 'number', 'error')}">
		<label for="surName">
			<g:message code="supplier.surName.label" default="Apellido" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="surName" class="form-control" maxlength="50" placeholder="Apellido" required="" value="${supplierInstance?.surName}"/>
	</div>
	<div class="form-group ${hasErrors(bean: supplierInstance, field: 'number', 'error')}">
		<label for="ruc">
			<g:message code="supplier.ruc.label" default="Ruc" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="ruc" class="form-control" placeholder="Ruc" value="${supplierInstance?.ruc}" required=""/>
	</div>
	<div class="form-group ${hasErrors(bean: supplierInstance, field: 'number', 'error')}">
		<label for="address">
			<g:message code="supplier.address.label" default="Dirección" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="address" class="form-control"  placeholder="Dirección" maxlength="80" required="" value="${supplierInstance?.address}"/>
	</div>
	<div class="form-group ${hasErrors(bean: supplierInstance, field: 'number', 'error')}">
		<label for="cellphone">
			<g:message code="supplier.cellphone.label" default="Telefono" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="cellphone" class="form-control"  placeholder="Telefono" maxlength="30" required="" value="${supplierInstance?.cellphone}"/>
	</div>
</div>
<!-- /.box-body -->