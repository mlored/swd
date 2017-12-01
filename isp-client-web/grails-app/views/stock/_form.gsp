<%@ page import="com.sd.isp.stock.Stock" %>

<div class="box-body">
	<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'date', 'error')} required">
		<label for="name">
			<g:message code="part.name.label" default="Date" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="name" class="form-control" maxlength="50"  placeholder="Name" required="" value="${partInstance?.name}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: partInstance, field: 'description', 'error')} required">
		<label for="description">
			<g:message code="part.description.label" default="Description" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="description" class="form-control" maxlength="50" placeholder="Descripción" required="" value="${partInstance?.description}"/>
	</div>
	
	<div class="form-group ${hasErrors(bean: partInstance, field: 'price', 'error')} required">
		<label for="price">
			<g:message code="part.price.label" default="Price" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="price" class="form-control" placeholder="Precio" value="${partInstance?.price}" required=""/>
	</div>
	
	<div class="form-group ${hasErrors(bean: partInstance, field: 'quantity', 'error')} required">
		<label for="quantity">
			<g:message code="part.quantity.label" default="Quantity" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="quantity" class="form-control"  placeholder="Cantidad" maxlength="10" required="" value="${partInstance?.quantity}"/>
	</div>
</div>
<!-- /.box-body -->