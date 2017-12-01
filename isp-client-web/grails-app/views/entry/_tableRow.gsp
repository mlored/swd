<td>

    <div class="form-group">
        <label class="col-sm-2 col-sm-2 control-label">Item*</label>
        <div class="col-sm-10">

            <g:select id="client" name="clientId" from="${clients}" optionKey="id" optionValue="name" required="" value="${entryInstance?.client?.id}" class="many-to-one"/>

        </div>
    </div>

</td>

<td>

    <div class="form-group">
        <label class="col-sm-2 col-sm-2 control-label">Fecha*</label>
        <div class="col-sm-10">
            <g:textField class="form-control"  name="${date}"  required=""/>
        </div>
    </div>

</td>