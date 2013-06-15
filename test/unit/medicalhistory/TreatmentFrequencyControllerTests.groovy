package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(TreatmentFrequencyController)
@Mock(TreatmentFrequency)
class TreatmentFrequencyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/treatmentFrequency/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.treatmentFrequencyInstanceList.size() == 0
        assert model.treatmentFrequencyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.treatmentFrequencyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.treatmentFrequencyInstance != null
        assert view == '/treatmentFrequency/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/treatmentFrequency/show/1'
        assert controller.flash.message != null
        assert TreatmentFrequency.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentFrequency/list'

        populateValidParams(params)
        def treatmentFrequency = new TreatmentFrequency(params)

        assert treatmentFrequency.save() != null

        params.id = treatmentFrequency.id

        def model = controller.show()

        assert model.treatmentFrequencyInstance == treatmentFrequency
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentFrequency/list'

        populateValidParams(params)
        def treatmentFrequency = new TreatmentFrequency(params)

        assert treatmentFrequency.save() != null

        params.id = treatmentFrequency.id

        def model = controller.edit()

        assert model.treatmentFrequencyInstance == treatmentFrequency
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentFrequency/list'

        response.reset()

        populateValidParams(params)
        def treatmentFrequency = new TreatmentFrequency(params)

        assert treatmentFrequency.save() != null

        // test invalid parameters in update
        params.id = treatmentFrequency.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/treatmentFrequency/edit"
        assert model.treatmentFrequencyInstance != null

        treatmentFrequency.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/treatmentFrequency/show/$treatmentFrequency.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        treatmentFrequency.clearErrors()

        populateValidParams(params)
        params.id = treatmentFrequency.id
        params.version = -1
        controller.update()

        assert view == "/treatmentFrequency/edit"
        assert model.treatmentFrequencyInstance != null
        assert model.treatmentFrequencyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/treatmentFrequency/list'

        response.reset()

        populateValidParams(params)
        def treatmentFrequency = new TreatmentFrequency(params)

        assert treatmentFrequency.save() != null
        assert TreatmentFrequency.count() == 1

        params.id = treatmentFrequency.id

        controller.delete()

        assert TreatmentFrequency.count() == 0
        assert TreatmentFrequency.get(treatmentFrequency.id) == null
        assert response.redirectedUrl == '/treatmentFrequency/list'
    }
}
