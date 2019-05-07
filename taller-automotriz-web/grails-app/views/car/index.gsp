<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'car.label', default: 'Cars')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-car" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>
<div id="list-car" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="mark" title="${message(code: 'car.mark.label', default: 'Mark')}" />

            <g:sortableColumn property="model" title="${message(code: 'car.model.label', default: 'Model')}" />

            <g:sortableColumn property="number" title="${message(code: 'car.number.label', default: 'Number')}" />

            <g:sortableColumn property="color" title="${message(code: 'car.color.label', default: 'Color')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${carInstanceList}" status="i" var="carInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${carInstance.id}">${fieldValue(bean: carInstance, field: "mark")}</g:link></td>

                <td>${fieldValue(bean: carInstance, field: "model")}</td>

                <td>${fieldValue(bean: carInstance, field: "number")}</td>

                <td>${fieldValue(bean: carInstance, field: "color")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
