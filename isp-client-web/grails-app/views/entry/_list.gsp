<table class="table table-condensed">
    <thead>
    <tr>
        <th>#</th>
        <th>Numero</th>
        <th>Cliente</th>
        <th>Fecha</th>
        <th>Automovil</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:set var="x" value="${1}"/>
    <g:each in="${entryList}" status="i" var="entryInstance">
        <tr>
            <th scope="row">${x++}</th>
            <td>
                ${fieldValue(bean: entryInstance, field: "number")}
            </td>

            <td>
                ${fieldValue(bean: entryInstance, field: "client")}
            </td>

            <td>
                ${fieldValue(bean: profesorInstance, field: "date")}
            </td>

            <td>
                ${fieldValue(bean: profesorInstance, field: "car")}
            </td>

            <td>
                <g:remoteLink class="edit glyphicon glyphicon-info-sign icon-large" controller="entry" action="show" id="${entryInstance?.id}" update="modal-content"></g:remoteLink>
                <g:remoteLink class="edit glyphicon glyphicon-edit icon-large" controller="entry" action="edit" id="${entryInstance?.id}" update="modal-content"></g:remoteLink>
                <g:remoteLink class="delete glyphicon glyphicon-trash icon-large" controller="entry" action="delete" id="${entryInstance?.id}" before="if(!confirm('Estas seguro?')) return false" update="body"></g:remoteLink>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>