package medicalhistory

/*
 * Antecedent Domain class
 */
class Antecedent {

	Boolean antecedentValue
    Patient patient
    
    static hasMany = [antecedentDetails:AntecedentDetail]
    
    static constraints = {
    }
}
