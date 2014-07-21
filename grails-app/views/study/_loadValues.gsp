<%@ page import="medicalhistory.StudyTypesValues; medicalhistory.TreatmentValue; medicalhistory.AntecedentValue" %>

<g:each in="${values}" var="value">
        <p>${value.key}: ${value.value}</p>
</g:each>

