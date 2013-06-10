package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class MeasurementUnitController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [measurementUnitInstanceList: MeasurementUnit.list(params), measurementUnitInstanceTotal: MeasurementUnit.count()]
    }

    def create() {
        [measurementUnitInstance: new MeasurementUnit(params)]
    }

    def save() {
        def measurementUnitInstance = new MeasurementUnit(params)
        if (!measurementUnitInstance.save(flush: true)) {
            render(view: "create", model: [measurementUnitInstance: measurementUnitInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), measurementUnitInstance.id])
        redirect(action: "show", id: measurementUnitInstance.id)
    }

    def show(Long id) {
        def measurementUnitInstance = MeasurementUnit.get(id)
        if (!measurementUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "list")
            return
        }

        [measurementUnitInstance: measurementUnitInstance]
    }

    def edit(Long id) {
        def measurementUnitInstance = MeasurementUnit.get(id)
        if (!measurementUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "list")
            return
        }

        [measurementUnitInstance: measurementUnitInstance]
    }

    def update(Long id, Long version) {
        def measurementUnitInstance = MeasurementUnit.get(id)
        if (!measurementUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (measurementUnitInstance.version > version) {
                measurementUnitInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'measurementUnit.label', default: 'MeasurementUnit')] as Object[],
                          "Another user has updated this MeasurementUnit while you were editing")
                render(view: "edit", model: [measurementUnitInstance: measurementUnitInstance])
                return
            }
        }

        measurementUnitInstance.properties = params

        if (!measurementUnitInstance.save(flush: true)) {
            render(view: "edit", model: [measurementUnitInstance: measurementUnitInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), measurementUnitInstance.id])
        redirect(action: "show", id: measurementUnitInstance.id)
    }

    def delete(Long id) {
        def measurementUnitInstance = MeasurementUnit.get(id)
        if (!measurementUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "list")
            return
        }

        try {
            measurementUnitInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'measurementUnit.label', default: 'MeasurementUnit'), id])
            redirect(action: "show", id: id)
        }
    }
}
