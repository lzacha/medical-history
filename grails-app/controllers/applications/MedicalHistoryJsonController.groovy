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


    def patients() {
        render Patient.findAll() as JSON
    }

    def studyTypeYearEvolution() {
        //def
    }

    /*
    def antecedentByPatien() {
        Patient p = Patient.get(params.id)
        AntecedentValue a = AntecedentValue.findBy(p.id)

        render p as JSON
    }
    */

}
