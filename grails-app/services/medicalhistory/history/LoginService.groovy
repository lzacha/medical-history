package medicalhistory.history

import medicalhistory.SystemUser
import javax.servlet.http.Cookie

/**
 * All services are singletons
 */
class LoginService {

	def doLogin(username, password){
		SystemUser su = SystemUser.findByUsernameAndPassword(username, password)

		if(su){
            su.setLastLogin(new Date())
            true
        }else{
            false
        }

	}

    /**
     * Setting login cookie
     * maxAge: 30 days
     * path: /
     * @return cookie
     */
    def getLoginCookie(){
        Cookie cookie = new Cookie("myCookie", "CookieMonster")
        cookie.maxAge = 60 * 60 * 24  * 30
        cookie.setPath("/")
        cookie
    }

}
