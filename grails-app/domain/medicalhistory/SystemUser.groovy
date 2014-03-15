package medicalhistory

class SystemUser {

    static searchable = {
        spellCheck "include"
    }

    String username
	String password

	String firstName
	String lastName
	String status  //activo/inactivo

    String role //3 roles

	Date lastLogin

//    static constraints = {
//    }
}
