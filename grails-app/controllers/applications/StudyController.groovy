package applications

import medicalhistory.StudyTypes
import medicalhistory.StudyTypesDetail
import medicalhistory.StudyTypesValues
import medicalhistory.Antecedent
import medicalhistory.AntecedentDetail
import medicalhistory.Treatment
import medicalhistory.TreatmentDetail
import medicalhistory.AntecedentValue
import medicalhistory.Patient;

class StudyController {

	
	def loadStudyTypes() {

	}
	
	def saveStudyTypesValues() {
		println params
		//redirect(action:'index') grail

        StudyTypesValues stv =

        params.each {key, value ->

        }
	}

    def saveAntecedentValues() {
        println params
        //redirect(action:'index') grail

        Antecedent ant = Antecedent.findById(params.antecedentId)
        Patient patient = Patient.findById(request.getCookie("mhid"))

        params.each {key, value ->

            /*
            if (key.contains("PID_")){
                AntecedentDetail ant = AntecedentDetail.
                def antecedent1 = new AntecedentValue(patient:patient, antecedentDetail:antDet1, antecedentValue:1)

            }
            */
        }
    }


    def saveTreatmentsValues() {
        println params
        //redirect(action:'index') grail
        StudyTypesValues stv =
        params.each {key, value ->
        }
    }

    def listStudies() {
		
    }
	
	def listTreatments() {
		
	}
	
	def listAntecedents() {
	
	}
	
	//load del template
	def loadStudyTypesInputs() {

        //Id del studyType
		def studyTypeId = params['id']

        //Traigo el studyTpe
        StudyTypes studyType = StudyTypes.findById(studyTypeId)

        //Levanto details del studyType
		def studyTypeDetails = StudyTypesDetail.findAllByStudyTypes(studyType)

        //Listado de abbrevations
		def studyTypeDetailsAbbreviation = []

        studyTypeDetails.collect(studyTypeDetailsAbbreviation){
			it.abbreviation
		}
		
		//render(template:'result', model:[std: studyTypeDetails.collect{it.description}])
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



	//load del template
	def loadStudyTypesValues() {
		//render "test"
		def studyType = params['studyType']
		println "studyType --> " + studyType
 
		def studyTypeValues = StudyTypesValues.list()

		//render(template:'result', model:[std: studyTypeDetails.collect{it.description}])
		render (template: 'loadValues', model:[values: studyTypeValues])
	}

	
}
