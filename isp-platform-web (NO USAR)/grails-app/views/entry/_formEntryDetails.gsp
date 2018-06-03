<table class="table table-condensed profesor-detalle-table">
    <thead>
    <tr>
        <th>#</th>
        <th>Fecha</th>
        <th>Repuesto</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:set var="x" value="${1}"/>
    <g:each in="${entry_details}" status="i" var="entryDetailsInstance">
        <tr>
            <th scope="row">${x++}</th>
            <td class="col-md-3">
                <g:textFieldH labelFor="date"    inputName="Fecha " labelClass="hide"
                              inputMaxLength="10" inputValue="${entryDetailsInstance?.date}" inputClass="date" />
            </td>

            <td class="col-md-5">
                <g:selectH  labelFor="part"	labelClass="hide" id="part"	name="item.id" from="${items}"  optionKey ="id" optionValue ="nombre" value="${entryDetailsInstance?.item?.id}"/>
            </td>


            <td>
                <button type="button" class="btn btn-default btn-sm td" id="${entryDetailsInstance?.id}">
                    <span class="glyphicon glyphicon-minus icon-large" aria-hidden="true"></span>
                </button>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>



