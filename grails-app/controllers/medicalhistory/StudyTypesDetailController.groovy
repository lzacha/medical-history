package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class StudyTypesDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [studyTypesDetailInstanceList: StudyTypesDetail.list(params), studyTypesDetailInstanceTotal: StudyTypesDetail.count()]
    }

    def create() {
        [studyTypesDetailInstance: new StudyTypesDetail(params)]
    }

    def save() {
        def studyTypesDetailInstance = new StudyTypesDetail(params)
        if (!studyTypesDetailInstance.save(flush: true)) {
            render(view: "create", model: [studyTypesDetailInstance: studyTypesDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), studyTypesDetailInstance.id])
        redirect(action: "show", id: studyTypesDetailInstance.id)
    }

    def show(Long id) {
        def studyTypesDetailInstance = StudyTypesDetail.get(id)
        if (!studyTypesDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "list")
            return
        }

        [studyTypesDetailInstance: studyTypesDetailInstance]
    }

    def edit(Long id) {
        def studyTypesDetailInstance = StudyTypesDetail.get(id)
        if (!studyTypesDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "list")
            return
        }

        [studyTypesDetailInstance: studyTypesDetailInstance]
    }

    def update(Long id, Long version) {
        def studyTypesDetailInstance = StudyTypesDetail.get(id)
        if (!studyTypesDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (studyTypesDetailInstance.version > version) {
                studyTypesDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail')] as Object[],
                          "Another user has updated this StudyTypesDetail while you were editing")
                render(view: "edit", model: [studyTypesDetailInstance: studyTypesDetailInstance])
                return
            }
        }

        studyTypesDetailInstance.properties = params

        if (!studyTypesDetailInstance.save(flush: true)) {
            render(view: "edit", model: [studyTypesDetailInstance: studyTypesDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), studyTypesDetailInstance.id])
        redirect(action: "show", id: studyTypesDetailInstance.id)
    }

    def delete(Long id) {
        def studyTypesDetailInstance = StudyTypesDetail.get(id)
        if (!studyTypesDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            studyTypesDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
