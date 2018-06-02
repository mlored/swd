


<div class="box-body">
<div class="form-group ${hasErrors(bean: clientInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="client.name.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" class="form-control" maxlength="15"  placeholder="Nombre" required="" value="${clientInstance?.name}"/>

</div>

<div class="form-group ${hasErrors(bean: clientInstance, field: 'surName', 'error')} required">
	<label for="surName">
		<g:message code="client.surName.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="surName" class="form-control" maxlength="15"  placeholder="Apellido" required="" value="${clientInstance?.surName}"/>

</div>

<div class="form-group ${hasErrors(bean: clientInstance, field: 'ruc', 'error')} required">
	<label for="ruc">
		<g:message code="client.ruc.label" default="Ruc" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ruc" class="form-control" maxlength="10"  placeholder="RUC" required="" value="${clientInstance?.ruc}"/>

</div>

<div class="form-group ${hasErrors(bean: clientInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="client.address.label" default="Direccion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" class="form-control" maxlength="50"  placeholder="Direccion" required="" value="${clientInstance?.address}"/>

</div>

<div class="form-group ${hasErrors(bean: clientInstance, field: 'cellphone', 'error')} required">
	<label for="cellphone">
		<g:message code="client.cellphone.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cellphone" type="number" class="form-control" maxlength="15"  placeholder="Telefono" value="${clientInstance.cellphone}" required=""/>

</div>
</div>

