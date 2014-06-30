<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs" class="tabref">
    <ul style="padding: 0; margin: 0;">

        <li><a id="study-tab" href="#iframe1">Estudio</a></li>
        <li><a id="treatment-tab" href="#iframe2">Tratamiento</a></li>
        <li><a id="antecedent-tab" href="#iframe3">Antecedente</a></li>
        <li><a id="palte-tab" href="#iframe4">Placa</a></li>


    </ul>

    <iframe id="iframe1" src="/medical-history/medicalStudy/show/${patient.id}" style="width:100%;">
    </iframe>

    <iframe id="iframe2" src="/medical-history/treatment/show/${patient.id}" style="width:100%;">
    </iframe>

    <iframe id="iframe3" src="/medical-history/antecedent/show/${patient.id}" style="width:100%;">
    </iframe>

    <iframe id="iframe4" src="/medical-history/plate/show/${patient.id}" style="width:100%;">
    </iframe>

</div>