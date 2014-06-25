package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypesValuesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypesValuesInstanceList: StudyTypesValues.list(params), studyTypesValuesInstanceTotal: StudyTypesValues.count()]
    }

    def create() {
        [studyTypesValuesInstance: new StudyTypesValues(params)]
    }

    def save() {
        def studyTypesValuesInstance = new StudyTypesValues(params)
        if (!studyTypesValuesInstance.save(flush: true)) {
            render(view: "create", model: [studyTypesValuesInstance: studyTypesValuesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), studyTypesValuesInstance.id])
        redirect(action: "show", id: studyTypesValuesInstance.id)
    }

    def show(Long id) {
        def studyTypesValuesInstance = StudyTypesValues.get(id)
        if (!studyTypesValuesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "list")
            return
        }

        [studyTypesValuesInstance: studyTypesValuesInstance]
    }

    def edit(Long id) {
        def studyTypesValuesInstance = StudyTypesValues.get(id)
        if (!studyTypesValuesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "list")
            return
        }

        [studyTypesValuesInstance: studyTypesValuesInstance]
    }

    def update(Long id, Long version) {
        def studyTypesValuesInstance = StudyTypesValues.get(id)
        if (!studyTypesValuesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypesValuesInstance.version > version) {
                studyTypesValuesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyTypesValues.label', default: 'StudyTypesValues')] as Object[],
                          "Another user has updated this StudyTypesValues while you were editing")
                render(view: "edit", model: [studyTypesValuesInstance: studyTypesValuesInstance])
                return
            }
        }

        studyTypesValuesInstance.properties = params

        if (!studyTypesValuesInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypesValuesInstance: studyTypesValuesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), studyTypesValuesInstance.id])
        redirect(action: "show", id: studyTypesValuesInstance.id)
    }

    def delete(Long id) {
        def studyTypesValuesInstance = StudyTypesValues.get(id)
        if (!studyTypesValuesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypesValuesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypesValues.label', default: 'StudyTypesValues'), id])
            redirect(action: "show", id: id)
        }
    }
}
