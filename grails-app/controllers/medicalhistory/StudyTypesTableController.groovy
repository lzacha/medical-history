package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypesTableController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypesTableInstanceList: StudyTypesTable.list(params), studyTypesTableInstanceTotal: StudyTypesTable.count()]
    }

    def create() {
        [studyTypesTableInstance: new StudyTypesTable(params)]
    }

    def save() {
        def studyTypesTableInstance = new StudyTypesTable(params)
        if (!studyTypesTableInstance.save(flush: true)) {
            render(view: "create", model: [studyTypesTableInstance: studyTypesTableInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), studyTypesTableInstance.id])
        redirect(action: "show", id: studyTypesTableInstance.id)
    }

    def show(Long id) {
        def studyTypesTableInstance = StudyTypesTable.get(id)
        if (!studyTypesTableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "list")
            return
        }

        [studyTypesTableInstance: studyTypesTableInstance]
    }

    def edit(Long id) {
        def studyTypesTableInstance = StudyTypesTable.get(id)
        if (!studyTypesTableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "list")
            return
        }

        [studyTypesTableInstance: studyTypesTableInstance]
    }

    def update(Long id, Long version) {
        def studyTypesTableInstance = StudyTypesTable.get(id)
        if (!studyTypesTableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypesTableInstance.version > version) {
                studyTypesTableInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'studyTypesTable.label', default: 'StudyTypesTable')] as Object[],
                        "Another user has updated this StudyTypesTable while you were editing")
                render(view: "edit", model: [studyTypesTableInstance: studyTypesTableInstance])
                return
            }
        }

        studyTypesTableInstance.properties = params

        if (!studyTypesTableInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypesTableInstance: studyTypesTableInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), studyTypesTableInstance.id])
        redirect(action: "show", id: studyTypesTableInstance.id)
    }

    def delete(Long id) {
        def studyTypesTableInstance = StudyTypesTable.get(id)
        if (!studyTypesTableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypesTableInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypesTable.label', default: 'StudyTypesTable'), id])
            redirect(action: "show", id: id)
        }
    }
}
