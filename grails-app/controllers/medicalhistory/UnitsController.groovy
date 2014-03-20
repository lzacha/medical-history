package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class UnitsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [unitsInstanceList: Units.list(params), unitsInstanceTotal: Units.count()]
    }

    def create() {
        [unitsInstance: new Units(params)]
    }

    def save() {
        def unitsInstance = new Units(params)
        if (!unitsInstance.save(flush: true)) {
            render(view: "create", model: [unitsInstance: unitsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'units.label', default: 'Units'), unitsInstance.id])
        redirect(action: "show", id: unitsInstance.id)
    }

    def show(Long id) {
        def unitsInstance = Units.get(id)
        if (!unitsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "list")
            return
        }

        [unitsInstance: unitsInstance]
    }

    def edit(Long id) {
        def unitsInstance = Units.get(id)
        if (!unitsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "list")
            return
        }

        [unitsInstance: unitsInstance]
    }

    def update(Long id, Long version) {
        def unitsInstance = Units.get(id)
        if (!unitsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (unitsInstance.version > version) {
                unitsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'units.label', default: 'Units')] as Object[],
                        "Another user has updated this Units while you were editing")
                render(view: "edit", model: [unitsInstance: unitsInstance])
                return
            }
        }

        unitsInstance.properties = params

        if (!unitsInstance.save(flush: true)) {
            render(view: "edit", model: [unitsInstance: unitsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'units.label', default: 'Units'), unitsInstance.id])
        redirect(action: "show", id: unitsInstance.id)
    }

    def delete(Long id) {
        def unitsInstance = Units.get(id)
        if (!unitsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "list")
            return
        }

        try {
            unitsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'units.label', default: 'Units'), id])
            redirect(action: "show", id: id)
        }
    }
}
