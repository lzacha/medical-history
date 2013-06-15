package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(DoctorController)
@Mock(Doctor)
class DoctorControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/doctor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.doctorInstanceList.size() == 0
        assert model.doctorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.doctorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.doctorInstance != null
        assert view == '/doctor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/doctor/show/1'
        assert controller.flash.message != null
        assert Doctor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        populateValidParams(params)
        def doctor = new Doctor(params)

        assert doctor.save() != null

        params.id = doctor.id

        def model = controller.show()

        assert model.doctorInstance == doctor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        populateValidParams(params)
        def doctor = new Doctor(params)

        assert doctor.save() != null

        params.id = doctor.id

        def model = controller.edit()

        assert model.doctorInstance == doctor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        response.reset()

        populateValidParams(params)
        def doctor = new Doctor(params)

        assert doctor.save() != null

        // test invalid parameters in update
        params.id = doctor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/doctor/edit"
        assert model.doctorInstance != null

        doctor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/doctor/show/$doctor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        doctor.clearErrors()

        populateValidParams(params)
        params.id = doctor.id
        params.version = -1
        controller.update()

        assert view == "/doctor/edit"
        assert model.doctorInstance != null
        assert model.doctorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        response.reset()

        populateValidParams(params)
        def doctor = new Doctor(params)

        assert doctor.save() != null
        assert Doctor.count() == 1

        params.id = doctor.id

        controller.delete()

        assert Doctor.count() == 0
        assert Doctor.get(doctor.id) == null
        assert response.redirectedUrl == '/doctor/list'
    }
}
