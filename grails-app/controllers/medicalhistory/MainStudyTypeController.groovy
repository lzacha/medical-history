package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class MainStudyTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [mainStudyTypeInstanceList: MainStudyType.list(params), mainStudyTypeInstanceTotal: MainStudyType.count()]
    }

    def create() {
        [mainStudyTypeInstance: new MainStudyType(params)]
    }

    def save() {
        def mainStudyTypeInstance = new MainStudyType(params)
        if (!mainStudyTypeInstance.save(flush: true)) {
            render(view: "create", model: [mainStudyTypeInstance: mainStudyTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), mainStudyTypeInstance.id])
        redirect(action: "show", id: mainStudyTypeInstance.id)
    }

    def show(Long id) {
        def mainStudyTypeInstance = MainStudyType.get(id)
        if (!mainStudyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "list")
            return
        }

        [mainStudyTypeInstance: mainStudyTypeInstance]
    }

    def edit(Long id) {
        def mainStudyTypeInstance = MainStudyType.get(id)
        if (!mainStudyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "list")
            return
        }

        [mainStudyTypeInstance: mainStudyTypeInstance]
    }

    def update(Long id, Long version) {
        def mainStudyTypeInstance = MainStudyType.get(id)
        if (!mainStudyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (mainStudyTypeInstance.version > version) {
                mainStudyTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mainStudyType.label', default: 'MainStudyType')] as Object[],
                          "Another user has updated this MainStudyType while you were editing")
                render(view: "edit", model: [mainStudyTypeInstance: mainStudyTypeInstance])
                return
            }
        }

        mainStudyTypeInstance.properties = params

        if (!mainStudyTypeInstance.save(flush: true)) {
            render(view: "edit", model: [mainStudyTypeInstance: mainStudyTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), mainStudyTypeInstance.id])
        redirect(action: "show", id: mainStudyTypeInstance.id)
    }

    def delete(Long id) {
        def mainStudyTypeInstance = MainStudyType.get(id)
        if (!mainStudyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "list")
            return
        }

        try {
            mainStudyTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mainStudyType.label', default: 'MainStudyType'), id])
            redirect(action: "show", id: id)
        }
    }
}
