package medicalhistory

class Antecedent {

    /* Patient link */
    Patient patient

    /* Antecedent Value */
    int antecedentValue

    /* Get all antecedent Details */
    static hasMany = [antecedentDetails:AntecedentDetail]

    /* TODO: constraints definition */
    static constraints = {

    }
}
