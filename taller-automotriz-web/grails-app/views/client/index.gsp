<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-client" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-client" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'client.name.label', default: 'Name')}" />

            <g:sortableColumn property="surName" title="${message(code: 'client.surName.label', default: 'Sur Name')}" />

            <g:sortableColumn property="ruc" title="${message(code: 'client.ruc.label', default: 'Ruc')}" />

            <g:sortableColumn property="address" title="${message(code: 'client.address.label', default: 'Address')}" />

            <g:sortableColumn property="cellphone" title="${message(code: 'client.cellphone.label', default: 'Cellphone')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${clientInstanceList}" status="i" var="clientInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${clientInstance.id}">${fieldValue(bean: clientInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: clientInstance, field: "surName")}</td>

                <td>${fieldValue(bean: clientInstance, field: "ruc")}</td>

                <td>${fieldValue(bean: clientInstance, field: "address")}</td>

                <td>${fieldValue(bean: clientInstance, field: "cellphone")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
