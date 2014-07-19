package medical.history

class MhTagLib {

    static namespace = "mh"

    def userTitle = { attrs, body ->

        def id =  request.getCookie("mhid")
        def name = request.getCookie("mhn")

        if (id && name){
            out << "paciente : ${request.getCookie("mhid")} - ${request.getCookie("mhn")}"
        }
    }


}
