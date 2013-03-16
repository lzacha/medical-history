package medicalhistory

class SystemUser {

    static searchable = {
        spellCheck "include"
    }

    String username
	String password

	String firstName
	String lastName
	String status

	Date lastLogin

//    static constraints = {
//    }
}
