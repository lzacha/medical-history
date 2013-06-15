package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(ObservationController)
@Mock(Observation)
class ObservationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/observation/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.observationInstanceList.size() == 0
        assert model.observationInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.observationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.observationInstance != null
        assert view == '/observation/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/observation/show/1'
        assert controller.flash.message != null
        assert Observation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/observation/list'

        populateValidParams(params)
        def observation = new Observation(params)

        assert observation.save() != null

        params.id = observation.id

        def model = controller.show()

        assert model.observationInstance == observation
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/observation/list'

        populateValidParams(params)
        def observation = new Observation(params)

        assert observation.save() != null

        params.id = observation.id

        def model = controller.edit()

        assert model.observationInstance == observation
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/observation/list'

        response.reset()

        populateValidParams(params)
        def observation = new Observation(params)

        assert observation.save() != null

        // test invalid parameters in update
        params.id = observation.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/observation/edit"
        assert model.observationInstance != null

        observation.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/observation/show/$observation.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        observation.clearErrors()

        populateValidParams(params)
        params.id = observation.id
        params.version = -1
        controller.update()

        assert view == "/observation/edit"
        assert model.observationInstance != null
        assert model.observationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/observation/list'

        response.reset()

        populateValidParams(params)
        def observation = new Observation(params)

        assert observation.save() != null
        assert Observation.count() == 1

        params.id = observation.id

        controller.delete()

        assert Observation.count() == 0
        assert Observation.get(observation.id) == null
        assert response.redirectedUrl == '/observation/list'
    }
}
