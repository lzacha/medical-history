package medical.history

import grails.converters.XML
import grails.converters.JSON

/**
 * /[controller]/[action]/[id]
 */
class LoginController {

      /**
     * This view is in /views/login/index
     * @return
     */
    def index() {

	}

    /**
     * This view is in /views/login/list
     * @return
     */
    def list() {

    }

    /**
     * http://localhost:8080/medical-history/login/userSystem?username=leozacha
     * @return
     */
    def XMLSystemUser() {
        def su = SystemUser.findByUsername(params.username)

        if (su)
            render su as XML
    }

    def JSONSystemUser() {
        def su = SystemUser.findByUsername(params.username)

        if (su)
            render su as JSON
    }

    def systemUser() {
        def su = SystemUser.findByUsername(params.username)

        if (su)
            render su
    }

}
