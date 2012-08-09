package medical.history

class LoginService {

	SystemUser doLogin(username, password){
		SystemUser su = SystemUser.findByusernameAndpassword(username, password)
		
		if(su)
		    su.setLastLogin(new Date())
	}
	
}
