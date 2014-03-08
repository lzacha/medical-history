package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypesDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypesDetailsInstanceList: StudyTypesDetails.list(params), studyTypesDetailsInstanceTotal: StudyTypesDetails.count()]
    }

    def create() {
        [studyTypesDetailsInstance: new StudyTypesDetails(params)]
    }

    def save() {
        def studyTypesDetailsInstance = new StudyTypesDetails(params)
        if (!studyTypesDetailsInstance.save(flush: true)) {
            render(view: "create", model: [studyTypesDetailsInstance: studyTypesDetailsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), studyTypesDetailsInstance.id])
        redirect(action: "show", id: studyTypesDetailsInstance.id)
    }

    def show(Long id) {
        def studyTypesDetailsInstance = StudyTypesDetails.get(id)
        if (!studyTypesDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "list")
            return
        }

        [studyTypesDetailsInstance: studyTypesDetailsInstance]
    }

    def edit(Long id) {
        def studyTypesDetailsInstance = StudyTypesDetails.get(id)
        if (!studyTypesDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "list")
            return
        }

        [studyTypesDetailsInstance: studyTypesDetailsInstance]
    }

    def update(Long id, Long version) {
        def studyTypesDetailsInstance = StudyTypesDetails.get(id)
        if (!studyTypesDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypesDetailsInstance.version > version) {
                studyTypesDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails')] as Object[],
                          "Another user has updated this StudyTypesDetails while you were editing")
                render(view: "edit", model: [studyTypesDetailsInstance: studyTypesDetailsInstance])
                return
            }
        }

        studyTypesDetailsInstance.properties = params

        if (!studyTypesDetailsInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypesDetailsInstance: studyTypesDetailsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), studyTypesDetailsInstance.id])
        redirect(action: "show", id: studyTypesDetailsInstance.id)
    }

    def delete(Long id) {
        def studyTypesDetailsInstance = StudyTypesDetails.get(id)
        if (!studyTypesDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypesDetailsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails'), id])
            redirect(action: "show", id: id)
        }
    }
}
