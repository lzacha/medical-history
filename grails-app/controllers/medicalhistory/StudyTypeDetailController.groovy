package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypeDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypeDetailInstanceList: StudyTypeDetail.list(params), studyTypeDetailInstanceTotal: StudyTypeDetail.count()]
    }

    def create() {
        [studyTypeDetailInstance: new StudyTypeDetail(params)]
    }

    def save() {
        def studyTypeDetailInstance = new StudyTypeDetail(params)
        if (!studyTypeDetailInstance.save(flush: true)) {
            render(view: "create", model: [studyTypeDetailInstance: studyTypeDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), studyTypeDetailInstance.id])
        redirect(action: "show", id: studyTypeDetailInstance.id)
    }

    def show(Long id) {
        def studyTypeDetailInstance = StudyTypeDetail.get(id)
        if (!studyTypeDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "list")
            return
        }

        [studyTypeDetailInstance: studyTypeDetailInstance]
    }

    def edit(Long id) {
        def studyTypeDetailInstance = StudyTypeDetail.get(id)
        if (!studyTypeDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "list")
            return
        }

        [studyTypeDetailInstance: studyTypeDetailInstance]
    }

    def update(Long id, Long version) {
        def studyTypeDetailInstance = StudyTypeDetail.get(id)
        if (!studyTypeDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypeDetailInstance.version > version) {
                studyTypeDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail')] as Object[],
                          "Another user has updated this StudyTypeDetail while you were editing")
                render(view: "edit", model: [studyTypeDetailInstance: studyTypeDetailInstance])
                return
            }
        }

        studyTypeDetailInstance.properties = params

        if (!studyTypeDetailInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypeDetailInstance: studyTypeDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), studyTypeDetailInstance.id])
        redirect(action: "show", id: studyTypeDetailInstance.id)
    }

    def delete(Long id) {
        def studyTypeDetailInstance = StudyTypeDetail.get(id)
        if (!studyTypeDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypeDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
