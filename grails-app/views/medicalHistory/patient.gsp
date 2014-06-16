<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs" class="tabref">
    <ul style="padding: 0; margin: 0;">
        <li><a id="patient-tab" href="#iframe1">Paciente</a></li>
        <li><a id="medicalStudy-tab" href="#iframe2">Ingreso Estudio</a></li>
        <li><a id="history-tab" href="#iframe3">Estudios</a></li>
        <li><a id="treatment-tab" href="#iframe4">Tratamientos</a></li>
        <li><a id="antecedent-tab" href="#iframe5">Antecedentes</a></li>
        <li><a id="plate-tab" href="#iframe6">Placas</a></li>
    </ul>

    <iframe id="iframe1" src="/medical-history/patient/show/${patient.id}" class="frameref">
    </iframe>

    <iframe id="iframe2" src="/medical-history/medicalStudy/show/${patient.id}" style="width:100%;">
    </iframe>

    <iframe id="iframe3" src="/medical-history/" style="width:100%;">
    </iframe>

    <iframe id="iframe4" src="/medical-history/treatment/show/${patient.id}" style="width:100%;">
    </iframe>

    <iframe id="iframe5" src="/medical-history/antecedent/list" style="width:100%;">
    </iframe>

    <iframe id="iframe6" src="/medical-history/plate/show/${patient.id}" style="width:100%;">
    </iframe>

</div>