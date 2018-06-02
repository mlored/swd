
<div class="box-body">
	<div class="form-group ${hasErrors(bean: buyInstance, field: 'number', 'error')}">
		<label for="date">
			<g:message code="buy.date.label" default="Fecha" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="date" class="form-control" maxlength="50"  placeholder="Fecha" required="" value="${buyInstance?.date}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: buyInstance, field: 'number', 'error')}">
		<label for="numero">
			<g:message code="buy.numero.label" default="Modelo" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="number" class="form-control" maxlength="50" placeholder="Numero" required="" value="${buyInstance?.number}"/>
	</div>
	<div class="form-group ${hasErrors(bean: buyInstance, field: 'number', 'error')}">
		<label for="number">
			<g:message code="buy.total.label" default="Total" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="total" class="form-control" placeholder="Total" value="${buyInstance?.total}" required=""/>
	</div>
</div>
<!-- /.box-body -->