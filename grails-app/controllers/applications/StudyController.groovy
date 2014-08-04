package applications

import medicalhistory.StudyTypes
import medicalhistory.StudyTypesDetail
import medicalhistory.StudyTypesValues
import medicalhistory.Antecedent
import medicalhistory.AntecedentDetail
import medicalhistory.Treatment
import medicalhistory.TreatmentDetail
import medicalhistory.AntecedentValue
import medicalhistory.Patient
import medicalhistory.TreatmentValue
import medicalhistory.StudyTypesTable
import medicalhistory.history.StudyService;

class StudyController {

    StudyService studyService
	
	def loadStudyTypes() {

	}

	def saveStudyTypesValues() {
        Patient patient = Patient.findById(request.getCookie("mhid"))
        def list = []
        params.each {key, value ->
            if (key.contains("PID_")){
                def abbreviation = key.split("_")[1]
                StudyTypesDetail std = StudyTypesDetail.findByAbbreviation(abbreviation)
                def stv = new StudyTypesValues(patient:patient, studyTypesDetail:std, studyTypeValue:value).save()
                list.add(stv)
            }
        }

        studyService.saveStudyTypesFromPatient(patient, list)

        render (template: 'loadValues', model:[values: params])
	}

    def saveAntecedentValues() {
        Patient patient = Patient.findById(request.getCookie("mhid"))
        def list = []
        params.each {key, value ->
            if (key.contains("PID_")){
                def abbreviation = key.split("_")[1]
                AntecedentDetail ad = AntecedentDetail.findByAbbreviation(abbreviation)
                def av = new AntecedentValue(patient:patient, antecedentDetail:ad, antecedentValue:value).save()
                list.add(av)
            }
        }

        studyService.saveAntecedentsFromPatient(patient, list)

        render (template: 'loadValues', model:[values: params])
    }

    def saveTreatmentsValues() {
        Patient patient = Patient.findById(request.getCookie("mhid"))
        def list = []
        params.each {key, value ->
            if (key.contains("PID_")){
                def abbreviation = key.split("_")[1]
                TreatmentDetail td = TreatmentDetail.findByAbbreviation(abbreviation)
                def tv = new TreatmentValue(patient:patient, treatmentDetail: td, treatmentValue: value).save()
                list.add(tv)
            }
        }

        studyService.saveTreatmentsFromPatient(patient, list)

        render (template: 'loadValues', model:[values: params])
    }

    def listStudies() {
		
    }
	
	def listTreatments() {
		
	}
	
	def listAntecedents() {
	
	}
	
	//load del template
	def loadStudyTypesInputs() {
		def studyTypeId = params['id']
        StudyTypes studyType = StudyTypes.findById(studyTypeId)
		def studyTypeDetails = StudyTypesDetail.findAllByStudyTypes(studyType)
		def studyTypeDetailsAbbreviation = []
        studyTypeDetails.collect(studyTypeDetailsAbbreviation){
			it.abbreviation
		}
		render (template: 'inputs', model:[inputs: studyTypeDetailsAbbreviation])
	}

    //load del template
    def loadAntecedentsInputs() {
        def antecedentId = params['id']
        Antecedent ant = Antecedent.findById(antecedentId)
        def antecedentsDetails = AntecedentDetail.findAllByAntecedent(ant)
        def antecedentsDetailsAbbreviation = []
        antecedentsDetails.collect(antecedentsDetailsAbbreviation){
            it.abbreviation
        }
        render (template: 'inputs', model:[inputs: antecedentsDetailsAbbreviation])
    }

    //load del template
    def loadTreatmentsInputs() {
        def treatmentId = params['id']
        Treatment trt = Treatment.findById(treatmentId)
        def treatmentDetail = TreatmentDetail.findAllByTreatment(trt)
        def treatmentsDetailsAbbreviation = []
        treatmentDetail.collect(treatmentsDetailsAbbreviation){
            it.abbreviation
        }
        render (template: 'inputs', model:[inputs: treatmentsDetailsAbbreviation])
    }

}
