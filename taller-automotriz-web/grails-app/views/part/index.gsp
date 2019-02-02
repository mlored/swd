<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-part" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>
<div id="list-part" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'part.name.label', default: 'Name')}" />

            <g:sortableColumn property="description" title="${message(code: 'part.description.label', default: 'Description')}" />

            <g:sortableColumn property="price" title="${message(code: 'part.price.label', default: 'Price')}" />

            <g:sortableColumn property="quantity" title="${message(code: 'part.quantity.label', default: 'Quantity')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${partInstanceList}" status="i" var="partInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${partInstance.id}">${fieldValue(bean: partInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: partInstance, field: "description")}</td>

                <td>${fieldValue(bean: partInstance, field: "price")}</td>

                <td>${fieldValue(bean: partInstance, field: "quantity")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
