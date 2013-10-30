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

        log.info "cookie creada?"
        
        //Si tiene cookie creada
        if(request.getCookie("isLogin") != null && request.getCookie("isLogin") != ""){
            log.info "cookie creada"
            redirect(controller: "medicalHistory", action: "index")
        }
            

        //Si no tiramos login
        if (loginService.doLogin(params.username, params.password)) {

            Cookie loginCookie = loginService.getLoginCookieFor(params.username)
            response.addCookie(loginCookie)

            redirect(controller: "medicalHistory", action: "index")
        } else {
            redirect(action: "index")
        }
    }

    def login (){


    }
}
