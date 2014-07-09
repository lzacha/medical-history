package applications

import medicalhistory.StudyTypes
import medicalhistory.StudyTypesDetail
import medicalhistory.StudyTypesValues;

class StudyController {

    def index() { 
		//[studyTypesInstance: StudyTypes.list()]
	}
	
	def loadStudyTypes() {

	}
	
	def saveStudyTypesValues() {
		println params
		redirect(action:'index')
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
	def loadStudyTypesValues() {
		//render "test"
		def studyType = params['studyType']
		println "studyType --> " + studyType
 
		def studyTypeValues = StudyTypesValues.list()

		//render(template:'result', model:[std: studyTypeDetails.collect{it.description}])
		render (template: 'loadValues', model:[values: studyTypeValues])
	}
	
	//load del template
	def loadTreatments() {
		//render "test"
		def studyType = params['studyType']
		println "studyType --> " + studyType
 
		def studyTypeValues = StudyTypesValues.list()

		//render(template:'result', model:[std: studyTypeDetails.collect{it.description}])
		render (template: 'loadTreatments', model:[values: studyTypeValues])
	}
	
}
