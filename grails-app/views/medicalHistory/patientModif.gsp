<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs" class="tabref">
    <ul style="padding: 0; margin: 0;">
        <li><a id="patient-tab" href="#iframe1">Paciente</a></li>

    </ul>

    <iframe id="iframe1" src="/medical-history/patient/edit/${patient.id}" style="width:100%;">
    </iframe>

</div>