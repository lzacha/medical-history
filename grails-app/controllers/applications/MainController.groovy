package applications

import javax.servlet.http.Cookie

class MainController {

     def index() {
        redirect(action: "patient")
     }

    def patient() {
        //Cookie cookie = new Cookie("myCookie", "CookieMonster")
        //response.addCookie(cookie)
    }
}
