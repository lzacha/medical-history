package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class ObservationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [observationInstanceList: Observation.list(params), observationInstanceTotal: Observation.count()]
    }

    def create() {
        [observationInstance: new Observation(params)]
    }

    def save() {
        def observationInstance = new Observation(params)
        if (!observationInstance.save(flush: true)) {
            render(view: "create", model: [observationInstance: observationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'observation.label', default: 'Observation'), observationInstance.id])
        redirect(action: "show", id: observationInstance.id)
    }

    def show(Long id) {
        def observationInstance = Observation.get(id)
        if (!observationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "list")
            return
        }

        [observationInstance: observationInstance]
    }

    def edit(Long id) {
        def observationInstance = Observation.get(id)
        if (!observationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "list")
            return
        }

        [observationInstance: observationInstance]
    }

    def update(Long id, Long version) {
        def observationInstance = Observation.get(id)
        if (!observationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (observationInstance.version > version) {
                observationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'observation.label', default: 'Observation')] as Object[],
                          "Another user has updated this Observation while you were editing")
                render(view: "edit", model: [observationInstance: observationInstance])
                return
            }
        }

        observationInstance.properties = params

        if (!observationInstance.save(flush: true)) {
            render(view: "edit", model: [observationInstance: observationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'observation.label', default: 'Observation'), observationInstance.id])
        redirect(action: "show", id: observationInstance.id)
    }

    def delete(Long id) {
        def observationInstance = Observation.get(id)
        if (!observationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "list")
            return
        }

        try {
            observationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'observation.label', default: 'Observation'), id])
            redirect(action: "show", id: id)
        }
    }
}
