package applications

import medicalhistory.StudyTypes
import medicalhistory.StudyTypesDetails
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
		//render "test"
		//def country = params['id']

 
		def studyTypeDetails = StudyTypesDetails.list()
		def list = StudyTypesDetails.list()
		def list2 = []
		
		list.collect(list2){
			it.abbreviation
		}
		
		//render(template:'result', model:[std: studyTypeDetails.collect{it.description}])
		render (template: 'inputs', model:[inputs: list2])
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
