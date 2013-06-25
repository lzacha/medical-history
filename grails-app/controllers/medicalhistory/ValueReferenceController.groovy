package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class ValueReferenceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [valueReferenceInstanceList: ValueReference.list(params), valueReferenceInstanceTotal: ValueReference.count()]
    }

    def create() {
        [valueReferenceInstance: new ValueReference(params)]
    }

    def save() {
        def valueReferenceInstance = new ValueReference(params)
        if (!valueReferenceInstance.save(flush: true)) {
            render(view: "create", model: [valueReferenceInstance: valueReferenceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), valueReferenceInstance.id])
        redirect(action: "show", id: valueReferenceInstance.id)
    }

    def show(Long id) {
        def valueReferenceInstance = ValueReference.get(id)
        if (!valueReferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "list")
            return
        }

        [valueReferenceInstance: valueReferenceInstance]
    }

    def edit(Long id) {
        def valueReferenceInstance = ValueReference.get(id)
        if (!valueReferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "list")
            return
        }

        [valueReferenceInstance: valueReferenceInstance]
    }

    def update(Long id, Long version) {
        def valueReferenceInstance = ValueReference.get(id)
        if (!valueReferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (valueReferenceInstance.version > version) {
                valueReferenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'valueReference.label', default: 'ValueReference')] as Object[],
                          "Another user has updated this ValueReference while you were editing")
                render(view: "edit", model: [valueReferenceInstance: valueReferenceInstance])
                return
            }
        }

        valueReferenceInstance.properties = params

        if (!valueReferenceInstance.save(flush: true)) {
            render(view: "edit", model: [valueReferenceInstance: valueReferenceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), valueReferenceInstance.id])
        redirect(action: "show", id: valueReferenceInstance.id)
    }

    def delete(Long id) {
        def valueReferenceInstance = ValueReference.get(id)
        if (!valueReferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "list")
            return
        }

        try {
            valueReferenceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'valueReference.label', default: 'ValueReference'), id])
            redirect(action: "show", id: id)
        }
    }
}
