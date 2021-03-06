<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div id="list-employee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'employee.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="surName" title="${message(code: 'employee.surName.label', default: 'SurName')}" />
					
						<g:sortableColumn property="ruc" title="${message(code: 'employee.ruc.label', default: 'Ruc')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'employee.address.label', default: 'Address')}" />
					
					    <g:sortableColumn property="cellphone" title="${message(code: 'employee.cellphone.label', default: 'Cellphone')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeInstance.id}">${fieldValue(bean: employeeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: employeeInstance, field: "surName")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "ruc")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "address")}</td>
						
						<td>${fieldValue(bean: employeeInstance, field: "cellphone")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
