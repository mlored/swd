<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'supplier.label', default: 'Supplier')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-supplier" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div id="list-supplier" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'supplier.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="surName" title="${message(code: 'supplier.surName.label', default: 'SurName')}" />
					
						<g:sortableColumn property="ruc" title="${message(code: 'supplier.ruc.label', default: 'Ruc')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'supplier.address.label', default: 'Address')}" />
					
					    <g:sortableColumn property="cellphone" title="${message(code: 'supplier.cellphone.label', default: 'Cellphone')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${supplierInstanceList}" status="i" var="supplierInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${supplierInstance.id}">${fieldValue(bean: supplierInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: supplierInstance, field: "surName")}</td>
					
						<td>${fieldValue(bean: supplierInstance, field: "ruc")}</td>
					
						<td>${fieldValue(bean: supplierInstance, field: "address")}</td>
						
						<td>${fieldValue(bean: supplierInstance, field: "cellphone")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
