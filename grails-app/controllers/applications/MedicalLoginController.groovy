package applications

import javax.servlet.http.Cookie

class MedicalLoginController {

    /*
    * Services and Dependency Injection, "autowiring"
    */
    def loginService

    def index() {
        redirect(action: "login")
    }

    def validate(){

        if (loginService.doLogin(params.username, params.password)) {

            Cookie loginCookie = loginService.getLoginCookie()
            response.addCookie(loginCookie)

            redirect(controller: "medicalHistory", action: "index")
        } else {
            redirect(action: "index")
        }
    }

    def login (){


    }
}
