package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class MeasureUnitController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [measureUnitInstanceList: MeasureUnit.list(params), measureUnitInstanceTotal: MeasureUnit.count()]
    }

    def create() {
        [measureUnitInstance: new MeasureUnit(params)]
    }

    def save() {
        def measureUnitInstance = new MeasureUnit(params)
        if (!measureUnitInstance.save(flush: true)) {
            render(view: "create", model: [measureUnitInstance: measureUnitInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), measureUnitInstance.id])
        redirect(action: "show", id: measureUnitInstance.id)
    }

    def show(Long id) {
        def measureUnitInstance = MeasureUnit.get(id)
        if (!measureUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "list")
            return
        }

        [measureUnitInstance: measureUnitInstance]
    }

    def edit(Long id) {
        def measureUnitInstance = MeasureUnit.get(id)
        if (!measureUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "list")
            return
        }

        [measureUnitInstance: measureUnitInstance]
    }

    def update(Long id, Long version) {
        def measureUnitInstance = MeasureUnit.get(id)
        if (!measureUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (measureUnitInstance.version > version) {
                measureUnitInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'measureUnit.label', default: 'MeasureUnit')] as Object[],
                        "Another user has updated this MeasureUnit while you were editing")
                render(view: "edit", model: [measureUnitInstance: measureUnitInstance])
                return
            }
        }

        measureUnitInstance.properties = params

        if (!measureUnitInstance.save(flush: true)) {
            render(view: "edit", model: [measureUnitInstance: measureUnitInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), measureUnitInstance.id])
        redirect(action: "show", id: measureUnitInstance.id)
    }

    def delete(Long id) {
        def measureUnitInstance = MeasureUnit.get(id)
        if (!measureUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "list")
            return
        }

        try {
            measureUnitInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'measureUnit.label', default: 'MeasureUnit'), id])
            redirect(action: "show", id: id)
        }
    }
}
