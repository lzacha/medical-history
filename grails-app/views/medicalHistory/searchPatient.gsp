
   <h1>Busque el Paciente</h1>




   <g:form id="searchPatientFormId" name="searchPatientFormName" method="get" url="[action:'patient',controller:'medicalHistory']">
       <div class="ui-widget">
           <label for="patients">Paciente:</label><input id="patients">
           <g:hiddenField id="hiddenPatient" name="hiddenPatient" value="" />
       </div>
       <g:submitButton name="submit" id= "searchPatientSubmit"/>
   </g:form>