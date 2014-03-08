package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class AgeRangesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [ageRangesInstanceList: AgeRanges.list(params), ageRangesInstanceTotal: AgeRanges.count()]
    }

    def create() {
        [ageRangesInstance: new AgeRanges(params)]
    }

    def save() {
        def ageRangesInstance = new AgeRanges(params)
        if (!ageRangesInstance.save(flush: true)) {
            render(view: "create", model: [ageRangesInstance: ageRangesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), ageRangesInstance.id])
        redirect(action: "show", id: ageRangesInstance.id)
    }

    def show(Long id) {
        def ageRangesInstance = AgeRanges.get(id)
        if (!ageRangesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "list")
            return
        }

        [ageRangesInstance: ageRangesInstance]
    }

    def edit(Long id) {
        def ageRangesInstance = AgeRanges.get(id)
        if (!ageRangesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "list")
            return
        }

        [ageRangesInstance: ageRangesInstance]
    }

    def update(Long id, Long version) {
        def ageRangesInstance = AgeRanges.get(id)
        if (!ageRangesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ageRangesInstance.version > version) {
                ageRangesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ageRanges.label', default: 'AgeRanges')] as Object[],
                          "Another user has updated this AgeRanges while you were editing")
                render(view: "edit", model: [ageRangesInstance: ageRangesInstance])
                return
            }
        }

        ageRangesInstance.properties = params

        if (!ageRangesInstance.save(flush: true)) {
            render(view: "edit", model: [ageRangesInstance: ageRangesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), ageRangesInstance.id])
        redirect(action: "show", id: ageRangesInstance.id)
    }

    def delete(Long id) {
        def ageRangesInstance = AgeRanges.get(id)
        if (!ageRangesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "list")
            return
        }

        try {
            ageRangesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ageRanges.label', default: 'AgeRanges'), id])
            redirect(action: "show", id: id)
        }
    }
}
