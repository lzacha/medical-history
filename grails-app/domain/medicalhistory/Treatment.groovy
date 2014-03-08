package medicalhistory

class Treatment {

    /* Patient link */
    Patient patient

    /* Treatment Frequency */
    TreatmentFrequency frequency    //No deberia ser todas las frecuencias?

    /* Treatment Value */
    int treatmentValue

    /* Get all antecedent Details */
    static hasMany = [treatmentDetails:TreatmentDetail]

    static constraints = {

    }

}
