

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'buy.label', default: 'Buy')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-buy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div id="list-buy" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="date" title="${message(code: 'buy.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="number" title="${message(code: 'buy.number.label', default: 'Number')}" />
					
						<g:sortableColumn property="total" title="${message(code: 'buy.total.label', default: 'Total')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${buyInstanceList}" status="i" var="buyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${buyInstance.id}">${fieldValue(bean: buyInstance, field: "date")}</g:link></td>
					
						<td>${fieldValue(bean: buyInstance, field: "number")}</td>
					
						<td>${fieldValue(bean: buyInstance, field: "total")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${buyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
