package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class DoctorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [doctorInstanceList: Doctor.list(params), doctorInstanceTotal: Doctor.count()]
    }

    def create() {
        [doctorInstance: new Doctor(params)]
    }

    def save() {
        def doctorInstance = new Doctor(params)
        if (!doctorInstance.save(flush: true)) {
            render(view: "create", model: [doctorInstance: doctorInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'doctor.label', default: 'Doctor'), doctorInstance.id])
        redirect(action: "show", id: doctorInstance.id)
    }

    def show(Long id) {
        def doctorInstance = Doctor.get(id)
        if (!doctorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "list")
            return
        }

        [doctorInstance: doctorInstance]
    }

    def edit(Long id) {
        def doctorInstance = Doctor.get(id)
        if (!doctorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "list")
            return
        }

        [doctorInstance: doctorInstance]
    }

    def update(Long id, Long version) {
        def doctorInstance = Doctor.get(id)
        if (!doctorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (doctorInstance.version > version) {
                doctorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'doctor.label', default: 'Doctor')] as Object[],
                          "Another user has updated this Doctor while you were editing")
                render(view: "edit", model: [doctorInstance: doctorInstance])
                return
            }
        }

        doctorInstance.properties = params

        if (!doctorInstance.save(flush: true)) {
            render(view: "edit", model: [doctorInstance: doctorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'doctor.label', default: 'Doctor'), doctorInstance.id])
        redirect(action: "show", id: doctorInstance.id)
    }

    def delete(Long id) {
        def doctorInstance = Doctor.get(id)
        if (!doctorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "list")
            return
        }

        try {
            doctorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
            redirect(action: "show", id: id)
        }
    }
}
