<h3 id="message-boxes">Encuentre a su paciente</h3>
    <g:form id="searchPatientFormId" name="searchPatientFormName" method="get" url="[action:'patient',controller:'medicalHistory']">
       <div class="ch-form-row">
           <label for="patients">Paciente:</label>
           <input id="patients" type="text" name="as_word" placeholder="Juan Perez" class="autocomplete" aria-autocomplete="list" aria-haspopup="true" aria-owns="ch-popover-2" autocomplete="off" data-side="bottom" data-align="left">



           <g:if test="${g.cookie(name: "mhid")}">
               (Ultima busqueda --> <a href="/medical-history/medicalHistory/patient?hiddenPatient=${g.cookie(name: "mhid")}&webCtx=${webCtx}&submit=submit"><g:cookie name="mhn"/></a>)
           </g:if>


           <p class="ch-form-hint">Coloque nombre o apellido</p>

           <g:hiddenField id="hiddenPatient" name="hiddenPatient" value="" />
           <g:hiddenField id="webCtx" name="webCtx" value="${webCtx}" />
       </div>
       <p class="ch-form-actions">
       <g:submitButton name="Buscar" id= "searchPatientSubmit" class="ch-btn ch-btn-big"/></p>

   </g:form>


