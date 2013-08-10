package medical.history

import medicalhistory.Patient
import grails.converters.JSON

class MedicalHistoryJsonsController {

    def index() { 
    //Patient p = ()
    //	render as Json
    }

    def stats(){
    	

    }
        

    def  patientAsJson() {
    	Patient p = Patient.get(params.id)
        render p as JSON
    	//MedicalHistoryJsonsController/patientAsJson/1
    }

    
}
