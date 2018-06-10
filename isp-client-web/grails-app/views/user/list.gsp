<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-car" class="content scaffold-list" role="main">
    <h1>
         Usuarios
        <g:link class="btn btn-primary" action="create">Nuevo</g:link>
    </h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="box">
        <table class="table table-striped table-hover table-condensed">
            <thead>
            <tr>
                <th>#</th>
                <g:sortableColumn property="username" title="Usuario" />
                <g:sortableColumn property="name" title="Nombre" />
                <g:sortableColumn property="surName" title="Apellido" />
                <g:sortableColumn property="role" title="Rol" />
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${userInstanceList}" status="i" var="userInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td>
                        <g:link action="edit" id="${userInstance?.id}"><g:message code="${fieldValue(bean: userInstance, field: "username")}" default="${fieldValue(bean: userInstance, field: "username")}" /></g:link>
                    </td>
                    <td>${fieldValue(bean: userInstance, field: "name")}</td>
                    <td>${fieldValue(bean: userInstance, field: "surName")}</td>
                    <td>${fieldValue(bean: userInstance, field: "role")}</td>
                    <td>
                        <g:form controller="user" method="DELETE">
                            <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                        </g:form>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <g:paginate total="${userInstanceTotal}" />
    </div>
</div>
</body>
</html>