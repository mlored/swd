<div class="box-body">
	<div class="form-group ${hasErrors(bean: employeeInstance, field: 'number', 'error')}">
		<label for="name">
			<g:message code="employee.name.label" default="Nombre" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="name" class="form-control"  maxlength="50" minlength="2"  placeholder="Nombre" required="" value="${employeeInstance?.name}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: employeeInstance, field: 'number', 'error')}">
		<label for="surName">
			<g:message code="employee.surName.label" default="Apellido" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="surName" class="form-control"  maxlength="50" minlength="2" placeholder="Apellido" required="" value="${employeeInstance?.surName}"/>
	</div>
	<div class="form-group ${hasErrors(bean: employeeInstance, field: 'number', 'error')}">
		<label for="ruc">
			<g:message code="employee.ruc.label" default="Ruc" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="ruc" class="form-control" placeholder="Ruc" value="${employeeInstance?.ruc}"  maxlength="50" minlength="2" required=""/>
	</div>
	<div class="form-group ${hasErrors(bean: employeeInstance, field: 'number', 'error')}">
		<label for="address">
			<g:message code="employee.address.label" default="Dirección" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="address" class="form-control"  placeholder="Dirección" maxlength="80" value="${employeeInstance?.address}"/>
	</div>
	<div class="form-group ${hasErrors(bean: employeeInstance, field: 'number', 'error')}">
		<label for="cellphone">
			<g:message code="employee.cellphone.label" default="Telefono" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="cellphone" class="form-control"  placeholder="Telefono" maxlength="30"  value="${employeeInstance?.cellphone}"/>
	</div>
</div>
<!-- /.box-body -->