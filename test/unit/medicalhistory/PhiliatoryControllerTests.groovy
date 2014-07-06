package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(PhiliatoryController)
@Mock(Philiatory)
class PhiliatoryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/philiatory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.philiatoryInstanceList.size() == 0
        assert model.philiatoryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.philiatoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.philiatoryInstance != null
        assert view == '/philiatory/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/philiatory/show/1'
        assert controller.flash.message != null
        assert Philiatory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/philiatory/list'

        populateValidParams(params)
        def philiatory = new Philiatory(params)

        assert philiatory.save() != null

        params.id = philiatory.id

        def model = controller.show()

        assert model.philiatoryInstance == philiatory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/philiatory/list'

        populateValidParams(params)
        def philiatory = new Philiatory(params)

        assert philiatory.save() != null

        params.id = philiatory.id

        def model = controller.edit()

        assert model.philiatoryInstance == philiatory
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/philiatory/list'

        response.reset()

        populateValidParams(params)
        def philiatory = new Philiatory(params)

        assert philiatory.save() != null

        // test invalid parameters in update
        params.id = philiatory.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/philiatory/edit"
        assert model.philiatoryInstance != null

        philiatory.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/philiatory/show/$philiatory.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        philiatory.clearErrors()

        populateValidParams(params)
        params.id = philiatory.id
        params.version = -1
        controller.update()

        assert view == "/philiatory/edit"
        assert model.philiatoryInstance != null
        assert model.philiatoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/philiatory/list'

        response.reset()

        populateValidParams(params)
        def philiatory = new Philiatory(params)

        assert philiatory.save() != null
        assert Philiatory.count() == 1

        params.id = philiatory.id

        controller.delete()

        assert Philiatory.count() == 0
        assert Philiatory.get(philiatory.id) == null
        assert response.redirectedUrl == '/philiatory/list'
    }
}
