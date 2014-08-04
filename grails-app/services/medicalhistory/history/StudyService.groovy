package medicalhistory.history

import medicalhistory.Patient
import medicalhistory.StudyTypesTable

class StudyService {

    def serviceMethod() {

    }


    def saveStudyTypesFromPatient(Patient patient, details){
        StudyTypesTable stt = StudyTypesTable.findByPatientAndStudyDate(patient, new Date().clearTime())
        if(!stt) {
            StudyTypesTable sttNew = new StudyTypesTable(studyDate:new Date().clearTime(), studyType: "Htal", patient: patient, antecedents: null, treatments: null, studies: details, plates:null ).save()
        }else{
            stt.setStudies(details)
            stt.save()
        }
    }

    def saveAntecedentsFromPatient(Patient patient, details){
        StudyTypesTable stt = StudyTypesTable.findByPatientAndStudyDate(patient, new Date().clearTime())
        if(!stt) {
            StudyTypesTable sttNew = new StudyTypesTable(studyDate:new Date().clearTime(), studyType: "Htal", patient: patient, antecedents: details, treatments: null, studies: null, plates:null ).save()
        }else{
            stt.setAntecedents(details)
            stt.save()
        }
    }

    def saveTreatmentsFromPatient(Patient patient, details){
        StudyTypesTable stt = StudyTypesTable.findByPatientAndStudyDate(patient, new Date().clearTime())
        if(!stt) {
            StudyTypesTable sttNew = new StudyTypesTable(studyDate:new Date().clearTime(), studyType: "Htal", patient: patient, antecedents: null, treatments: details, studies: null, plates:null ).save()
        }else{
            stt.setTreatments(details)
            stt.save()
        }
    }
}
