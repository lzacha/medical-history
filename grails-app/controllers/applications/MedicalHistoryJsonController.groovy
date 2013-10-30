package applications

import medicalhistory.Patient
import grails.converters.JSON

class MedicalHistoryJsonController {

    def index() { 
        render "MedicalHistoryJsonController"
    }

    def stats(){

    }
        

    def patient() {
    	Patient p = Patient.get(params.id)
        render p as JSON
    }


    /*
    def antecedentByPatien() {
        Patient p = Patient.get(params.id)
        Antecedent a = Antecedent.findBy(p.id)

        render p as JSON
    }
    */

}
