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

    def searchPatient(){


    }

    def addPatient() {}

    def suggest(){

        /*
        if (!params.q?.trim()) {
            return [:]
        }
        */

        try {

            def results = [searchResult: searchableService.search(params.q, params)]

            results.each { k,v -> print "$k = $v"}

            def teams = ["Boca Juniors", "River Plate", "Racing Club"]
            def json = teams as JSON
            render "autoComplete(" + json + ")"

        } catch (SearchEngineQueryParseException ex) {
            return [parseException: true]
        }

     }

}
