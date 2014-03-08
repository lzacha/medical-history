package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypesInstanceList: StudyTypes.list(params), studyTypesInstanceTotal: StudyTypes.count()]
    }

    def create() {
        [studyTypesInstance: new StudyTypes(params)]
    }

    def save() {
        def studyTypesInstance = new StudyTypes(params)
        if (!studyTypesInstance.save(flush: true)) {
            render(view: "create", model: [studyTypesInstance: studyTypesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), studyTypesInstance.id])
        redirect(action: "show", id: studyTypesInstance.id)
    }

    def show(Long id) {
        def studyTypesInstance = StudyTypes.get(id)
        if (!studyTypesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "list")
            return
        }

        [studyTypesInstance: studyTypesInstance]
    }

    def edit(Long id) {
        def studyTypesInstance = StudyTypes.get(id)
        if (!studyTypesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "list")
            return
        }

        [studyTypesInstance: studyTypesInstance]
    }

    def update(Long id, Long version) {
        def studyTypesInstance = StudyTypes.get(id)
        if (!studyTypesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypesInstance.version > version) {
                studyTypesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyTypes.label', default: 'StudyTypes')] as Object[],
                          "Another user has updated this StudyTypes while you were editing")
                render(view: "edit", model: [studyTypesInstance: studyTypesInstance])
                return
            }
        }

        studyTypesInstance.properties = params

        if (!studyTypesInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypesInstance: studyTypesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), studyTypesInstance.id])
        redirect(action: "show", id: studyTypesInstance.id)
    }

    def delete(Long id) {
        def studyTypesInstance = StudyTypes.get(id)
        if (!studyTypesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypes.label', default: 'StudyTypes'), id])
            redirect(action: "show", id: id)
        }
    }
}
