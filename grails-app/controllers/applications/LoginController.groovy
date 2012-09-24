package applications

import grails.converters.XML
import grails.converters.JSON
import medicalhistory.SystemUser
import javax.servlet.http.Cookie
import redis.clients.jedis.Jedis

/**
 * /[controller]/[action]/[id]
 */
class LoginController{

    /*
     * Services and Dependency Injection, "autowiring"
     */
    def loginService

    /**
     * This view is in /views/login/index
     * @return redirect
     */
    def index() {
        redirect(action: "login")
    }

    /**
     * This view is in /views/login/index
     * @return
     */
    def login() {

    }

    /**
     * This view is in /views/login/validate
     * @return
     */
    def validate() {

        /* Jedis test
        Jedis j = new Jedis("localhost")
        j.set("foo1", "bar2");
         */

        if (loginService.doLogin(params.username, params.password)) {
            //Cookie cookie = new Cookie("myCookie", "CookieMonster")
            //response.addCookie(cookie)
            redirect(controller: "main", action: "patient")
        } else {
            redirect(action: "index")
        }
    }

    /**
     * This view is in /views/login/list
     * @return
     */
    def list() {

    }

    /**
     * http://localhost:8080/medicalhistory-history/login/userSystem?username=leozacha
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
