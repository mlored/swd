<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="adminlte">
	<g:set var="entityName" value="${message(code: 'entry.label', default: 'Cars')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-entry" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li></li>
		<li></li>
	</ul>
</div>
<div id="list-entry" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="mark" title="${message(code: 'entry.date.label', default: 'Mark')}" />

			<g:sortableColumn property="model" title="${message(code: 'entry.number.label', default: 'Model')}" />

			<g:sortableColumn property="number" title="${message(code: 'entry.diagnostic.label', default: 'Number')}" />

			<g:sortableColumn property="color" title="${message(code: 'entry.client.label', default: 'Color')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${entryInstanceList}" status="i" var="entryInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${entryInstance.id}">${fieldValue(bean: entryInstance, field: "mark")}</g:link></td>

				<td>${fieldValue(bean: entryInstance, field: "date")}</td>

				<td>${fieldValue(bean: entryInstance, field: "number")}</td>

				<td>${fieldValue(bean: entryInstance, field: "diagnostic")}</td>

			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${EntryInstanceCount ?: 0}" />
	</div>
</div>
</body>
</html>
