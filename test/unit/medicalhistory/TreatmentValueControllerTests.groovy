package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(TreatmentValueController)
@Mock(TreatmentValue)
class TreatmentValueControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/treatmentValue/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.treatmentValueInstanceList.size() == 0
        assert model.treatmentValueInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.treatmentValueInstance != null
    }

    void testSave() {
        controller.save()

        assert model.treatmentValueInstance != null
        assert view == '/treatmentValue/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/treatmentValue/show/1'
        assert controller.flash.message != null
        assert TreatmentValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentValue/list'

        populateValidParams(params)
        def treatmentValue = new TreatmentValue(params)

        assert treatmentValue.save() != null

        params.id = treatmentValue.id

        def model = controller.show()

        assert model.treatmentValueInstance == treatmentValue
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentValue/list'

        populateValidParams(params)
        def treatmentValue = new TreatmentValue(params)

        assert treatmentValue.save() != null

        params.id = treatmentValue.id

        def model = controller.edit()

        assert model.treatmentValueInstance == treatmentValue
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentValue/list'

        response.reset()

        populateValidParams(params)
        def treatmentValue = new TreatmentValue(params)

        assert treatmentValue.save() != null

        // test invalid parameters in update
        params.id = treatmentValue.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/treatmentValue/edit"
        assert model.treatmentValueInstance != null

        treatmentValue.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/treatmentValue/show/$treatmentValue.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        treatmentValue.clearErrors()

        populateValidParams(params)
        params.id = treatmentValue.id
        params.version = -1
        controller.update()

        assert view == "/treatmentValue/edit"
        assert model.treatmentValueInstance != null
        assert model.treatmentValueInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/treatmentValue/list'

        response.reset()

        populateValidParams(params)
        def treatmentValue = new TreatmentValue(params)

        assert treatmentValue.save() != null
        assert TreatmentValue.count() == 1

        params.id = treatmentValue.id

        controller.delete()

        assert TreatmentValue.count() == 0
        assert TreatmentValue.get(treatmentValue.id) == null
        assert response.redirectedUrl == '/treatmentValue/list'
    }
}
