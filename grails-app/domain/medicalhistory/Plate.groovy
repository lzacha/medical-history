package medicalhistory

class Plate {

	static hasMany = [observations:Observation]
    Doctor doctor
     
    static constraints = {
    }
}
