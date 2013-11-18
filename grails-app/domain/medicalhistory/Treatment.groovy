package medicalhistory

class Treatment {

    /* Patient link */
    Patient patient

    /* Treatment Frequency */
    TreatmentFrequency frequency

    /* Treatment Value */
    int treatmentValue

    /* Get all antecedent Details */
    static hasMany = [treatmentDetails:TreatmentDetail]

    static constraints = {

    }

}
