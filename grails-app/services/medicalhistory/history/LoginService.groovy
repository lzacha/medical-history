package medicalhistory.history

import medicalhistory.Patient
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
    def getLoginCookieFor(username){
        Cookie cookie = new Cookie("isLogin", username)
        cookie.maxAge = 60 * 60 * 24  * 30
        cookie.setPath("/")
        cookie
    }

	/**
	 * Setting login cookie
	 * maxAge: 30 days
	 * path: /
	 * @return cookie
	 */
	def setCookiesPatient(patient, response){
		
		Cookie mhid = new Cookie("mhid", patient.patientId+"")
		mhid.maxAge = 60 * 60 * 24  * 30
		mhid.setPath("/")

		Cookie mhn = new Cookie("mhn", patient.firstName+" "+patient.lastName)
		mhn.maxAge = 60 * 60 * 24  * 30
		mhn.setPath("/")

		response.addCookie(mhid)
		response.addCookie(mhn)

	}


    def doLogout(response){
        response.deleteCookie('mhid')
        response.deleteCookie('mhn')
        response.deleteCookie('isLogin')
    }
	
}
