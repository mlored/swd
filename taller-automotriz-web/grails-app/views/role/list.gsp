<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-role" class="content scaffold-list" role="main">
    <h1>
        Roles
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
                <g:sortableColumn property="role" title="Rol" />
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${roleInstanceList}" status="i" var="roleInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td>
                        <g:link action="edit" id="${roleInstance?.id}"><g:message code="${fieldValue(bean: roleInstance, field: "authority")}" default="${fieldValue(bean: roleInstance, field: "authority")}" /></g:link>
                    </td>
                    <td>

                        <g:form controller="role" method="DELETE">
                            <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                        </g:form>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <g:paginate total="${roleInstanceTotal}" />
    </div>
</div>
</body>
</html>