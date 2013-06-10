package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class AgeRangeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [ageRangeInstanceList: AgeRange.list(params), ageRangeInstanceTotal: AgeRange.count()]
    }

    def create() {
        [ageRangeInstance: new AgeRange(params)]
    }

    def save() {
        def ageRangeInstance = new AgeRange(params)
        if (!ageRangeInstance.save(flush: true)) {
            render(view: "create", model: [ageRangeInstance: ageRangeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), ageRangeInstance.id])
        redirect(action: "show", id: ageRangeInstance.id)
    }

    def show(Long id) {
        def ageRangeInstance = AgeRange.get(id)
        if (!ageRangeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "list")
            return
        }

        [ageRangeInstance: ageRangeInstance]
    }

    def edit(Long id) {
        def ageRangeInstance = AgeRange.get(id)
        if (!ageRangeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "list")
            return
        }

        [ageRangeInstance: ageRangeInstance]
    }

    def update(Long id, Long version) {
        def ageRangeInstance = AgeRange.get(id)
        if (!ageRangeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ageRangeInstance.version > version) {
                ageRangeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ageRange.label', default: 'AgeRange')] as Object[],
                          "Another user has updated this AgeRange while you were editing")
                render(view: "edit", model: [ageRangeInstance: ageRangeInstance])
                return
            }
        }

        ageRangeInstance.properties = params

        if (!ageRangeInstance.save(flush: true)) {
            render(view: "edit", model: [ageRangeInstance: ageRangeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), ageRangeInstance.id])
        redirect(action: "show", id: ageRangeInstance.id)
    }

    def delete(Long id) {
        def ageRangeInstance = AgeRange.get(id)
        if (!ageRangeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "list")
            return
        }

        try {
            ageRangeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ageRange.label', default: 'AgeRange'), id])
            redirect(action: "show", id: id)
        }
    }
}
