package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class PlateDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [plateDetailInstanceList: PlateDetail.list(params), plateDetailInstanceTotal: PlateDetail.count()]
    }

    def create() {
        [plateDetailInstance: new PlateDetail(params)]
    }

    def save() {
        def plateDetailInstance = new PlateDetail(params)
        if (!plateDetailInstance.save(flush: true)) {
            render(view: "create", model: [plateDetailInstance: plateDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), plateDetailInstance.id])
        redirect(action: "show", id: plateDetailInstance.id)
    }

    def show(Long id) {
        def plateDetailInstance = PlateDetail.get(id)
        if (!plateDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "list")
            return
        }

        [plateDetailInstance: plateDetailInstance]
    }

    def edit(Long id) {
        def plateDetailInstance = PlateDetail.get(id)
        if (!plateDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "list")
            return
        }

        [plateDetailInstance: plateDetailInstance]
    }

    def update(Long id, Long version) {
        def plateDetailInstance = PlateDetail.get(id)
        if (!plateDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (plateDetailInstance.version > version) {
                plateDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'plateDetail.label', default: 'PlateDetail')] as Object[],
                          "Another user has updated this PlateDetail while you were editing")
                render(view: "edit", model: [plateDetailInstance: plateDetailInstance])
                return
            }
        }

        plateDetailInstance.properties = params

        if (!plateDetailInstance.save(flush: true)) {
            render(view: "edit", model: [plateDetailInstance: plateDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), plateDetailInstance.id])
        redirect(action: "show", id: plateDetailInstance.id)
    }

    def delete(Long id) {
        def plateDetailInstance = PlateDetail.get(id)
        if (!plateDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            plateDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'plateDetail.label', default: 'PlateDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
