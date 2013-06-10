package medicalhistory

/*
 * Antecedent Domain class
 */
class Antecedent {

    static hasMany = [antecedents:AntecedentDetail]
    
    static constraints = {
    }
}
