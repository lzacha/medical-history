package medicalhistory.history

import medicalhistory.SystemUser

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

}
