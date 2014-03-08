package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class ReferenceValueController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [referenceValueInstanceList: ReferenceValue.list(params), referenceValueInstanceTotal: ReferenceValue.count()]
    }

    def create() {
        [referenceValueInstance: new ReferenceValue(params)]
    }

    def save() {
        def referenceValueInstance = new ReferenceValue(params)
        if (!referenceValueInstance.save(flush: true)) {
            render(view: "create", model: [referenceValueInstance: referenceValueInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), referenceValueInstance.id])
        redirect(action: "show", id: referenceValueInstance.id)
    }

    def show(Long id) {
        def referenceValueInstance = ReferenceValue.get(id)
        if (!referenceValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "list")
            return
        }

        [referenceValueInstance: referenceValueInstance]
    }

    def edit(Long id) {
        def referenceValueInstance = ReferenceValue.get(id)
        if (!referenceValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "list")
            return
        }

        [referenceValueInstance: referenceValueInstance]
    }

    def update(Long id, Long version) {
        def referenceValueInstance = ReferenceValue.get(id)
        if (!referenceValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (referenceValueInstance.version > version) {
                referenceValueInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'referenceValue.label', default: 'ReferenceValue')] as Object[],
                          "Another user has updated this ReferenceValue while you were editing")
                render(view: "edit", model: [referenceValueInstance: referenceValueInstance])
                return
            }
        }

        referenceValueInstance.properties = params

        if (!referenceValueInstance.save(flush: true)) {
            render(view: "edit", model: [referenceValueInstance: referenceValueInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), referenceValueInstance.id])
        redirect(action: "show", id: referenceValueInstance.id)
    }

    def delete(Long id) {
        def referenceValueInstance = ReferenceValue.get(id)
        if (!referenceValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "list")
            return
        }

        try {
            referenceValueInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'referenceValue.label', default: 'ReferenceValue'), id])
            redirect(action: "show", id: id)
        }
    }
}
