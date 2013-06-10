package applications

import grails.converters.JSON
import org.compass.core.engine.SearchEngineQueryParseException

class MedicalHistoryController {

    def searchableService

    def index() { }

    def stats() {}

    def admin() {}

    //Patient Views
    def patient() {


    }

    def searchPatient(){}

    def addPatient() {
        //render(template: "/src/templates/scaffolding/form")

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

        } catch (SearchEngineQueryParseException ex) {
            return [parseException: true]
        }

     }

}
