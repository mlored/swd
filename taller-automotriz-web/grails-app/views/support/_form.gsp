<div class="col-md-12">
    <div>
        <label>Nombre y Apellido</label>
        <div class="form-group">
            <input class="form-control letter" type="text" maxlength="50"
                   id="userName" name="userName" placeholder="Ingrese un Nombre" autofocus/>
        </div>
    </div>

    <div>
        <label>Teléfono<span class="required-indicator">*</span></label>
        <div class="form-group has-feedback has-success">
            <input class="form-control numeric" type="number" maxlength="17"
                   id="phone" name="phone" placeholder="Ingrese un Número"/>
        </div>
    </div>

    <div>
        <label>Correo<span class="required-indicator">*</span></label>
        <div class="form-group has-feedback">
            <input class="form-control" type="email" maxlength="50"
                   id="email" name="email" placeholder="ejemplo@correo.com"/>
        </div>
    </div>



    <div>
        <label>Asunto<span class="required-indicator">*</span></label>
        <div class="form-group">
            <input class="form-control letter" type="text" maxlength="50"
                   id="subject" name="subject" placeholder="Ingrese el asunto"/>
        </div>
    </div>

    <div>
        <label>Mensaje <span class="required-indicator">*</span></label>
        <div class="form-group">
            <g:textArea class="form-control" rows="5" cols="40" class="form-control"
                        id="message" name="message" maxlength="250"
                        placeholder="Ingrese su mensaje" />
        </div>
    </div>

</div>

