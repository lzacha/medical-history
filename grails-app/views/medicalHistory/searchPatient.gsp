
   <h1>Busque el Paciente</h1>
   <g:form id="searchPatientFormId" name="searchPatientFormName" method="get" url="[action:'patient',controller:'medicalHistory']">
       <div class="ui-widget">
           <label for="patients">Paciente:</label><input id="patients">
           <g:hiddenField id="hiddenPatient" name="hiddenPatient" value="" />
           <g:hiddenField id="webCtx" name="webCtx" value="${webCtx}" />
       </div>
       <g:submitButton name="submit" id= "searchPatientSubmit"/>
       Ultima busqueda -->   <a href="/medical-history/medicalHistory/patient?hiddenPatient=${g.cookie(name: "mhid")}&webCtx=${webCtx}&submit=submit"><g:cookie name="mhn"/></a>
   </g:form>