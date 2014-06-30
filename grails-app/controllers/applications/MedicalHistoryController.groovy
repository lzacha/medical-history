package applications

import grails.converters.JSON
//import org.compass.core.engine.SearchEngineQueryParseException
import medicalhistory.Patient
import medicalhistory.Antecedent

import javax.servlet.http.Cookie

class MedicalHistoryController {

    def searchableService

    def index() { }

    def stats() {
    
    }

    def admin() {}

    def config() {}

    def listPatients() {

    }

    //Patient Views
    def patient() {
        Patient p = Patient.get(params.hiddenPatient	)

        Cookie mhid = new Cookie("mhid", p.patientId+"")
        mhid.maxAge = 60 * 60 * 24  * 30
        mhid.setPath("/")

        Cookie mhn = new Cookie("mhn", p.firstName+" "+p.lastName)
        mhn.maxAge = 60 * 60 * 24  * 30
        mhn.setPath("/")

        response.addCookie(mhid)
        response.addCookie(mhn)

        if(params.webCtx == "modif"){
            render(view: "patientModif", model: [patient:p])

        } else if (params.webCtx == "view"){
			render(view: "viewData", model: [patient:p])

        } else {
            render(view: "patient", model: [patient:p])
        }




    }

    def searchPatient(){

        //Search Modif
        if(params.webCtx == "modif"){
            [webCtx:"modif"]

        //Search View
		} else if (params.webCtx == "view"){
			[webCtx:"view"]
		}

    }

    def addPatient() {
        //render(template: "/src/templates/scaffolding/form")
    }

	def viewData() {
		Patient p = Patient.get(params.hiddenPatient)
		[patient:p]
	}
	
    def suggest(){

        /*
        if (!params.q?.trim()) {
            return [:]
        }
        */

        try {

            def search = searchableService.search(params.q, params)
            def patients = []

            search.results.each { it ->
                patients.add(it.firstName+" "+it.lastName)
            };

            def json = patients as JSON
            render "autoComplete(" + json + ")"

        } catch (Exception ex) {
            return [parseException: true]
        }

     }

    def listAntecedentsByPatient(){
        Patient p = Patient.get(params.id)
        def results = Antecedent.findAllByPatient(p)
        render (template:'listAntecedentsByPatient', model: [ants:results])
    }

    def listStudiesByPatient(){
        Patient p = Patient.get(params.id)
        def results = Antecedent.findAllByPatient(p)
        render (template:'listAntecedentsByPatient', model: [ants:results])
    }

    def systemConfig(){
        //Patient p = Patient.get(params.id)
    }

    def listSystemUsers(){

    }

    def studyEntry() {
    
    }

}
