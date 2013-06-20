package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypeInstanceList: StudyType.list(params), studyTypeInstanceTotal: StudyType.count()]
    }

    def create() {
        [studyTypeInstance: new StudyType(params)]
    }

    def save() {
        def studyTypeInstance = new StudyType(params)
        if (!studyTypeInstance.save(flush: true)) {
            render(view: "create", model: [studyTypeInstance: studyTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyType.label', default: 'StudyType'), studyTypeInstance.id])
        redirect(action: "show", id: studyTypeInstance.id)
    }

    def show(Long id) {
        def studyTypeInstance = StudyType.get(id)
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "list")
            return
        }

        [studyTypeInstance: studyTypeInstance]
    }

    def edit(Long id) {
        def studyTypeInstance = StudyType.get(id)
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "list")
            return
        }

        [studyTypeInstance: studyTypeInstance]
    }

    def update(Long id, Long version) {
        def studyTypeInstance = StudyType.get(id)
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypeInstance.version > version) {
                studyTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyType.label', default: 'StudyType')] as Object[],
                          "Another user has updated this StudyType while you were editing")
                render(view: "edit", model: [studyTypeInstance: studyTypeInstance])
                return
            }
        }

        studyTypeInstance.properties = params

        if (!studyTypeInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypeInstance: studyTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyType.label', default: 'StudyType'), studyTypeInstance.id])
        redirect(action: "show", id: studyTypeInstance.id)
    }

    def delete(Long id) {
        def studyTypeInstance = StudyType.get(id)
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyType.label', default: 'StudyType'), id])
            redirect(action: "show", id: id)
        }
    }
}
