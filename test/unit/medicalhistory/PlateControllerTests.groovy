package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(PlateController)
@Mock(Plate)
class PlateControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/plate/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.plateInstanceList.size() == 0
        assert model.plateInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.plateInstance != null
    }

    void testSave() {
        controller.save()

        assert model.plateInstance != null
        assert view == '/plate/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/plate/show/1'
        assert controller.flash.message != null
        assert Plate.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/plate/list'

        populateValidParams(params)
        def plate = new Plate(params)

        assert plate.save() != null

        params.id = plate.id

        def model = controller.show()

        assert model.plateInstance == plate
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/plate/list'

        populateValidParams(params)
        def plate = new Plate(params)

        assert plate.save() != null

        params.id = plate.id

        def model = controller.edit()

        assert model.plateInstance == plate
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/plate/list'

        response.reset()

        populateValidParams(params)
        def plate = new Plate(params)

        assert plate.save() != null

        // test invalid parameters in update
        params.id = plate.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/plate/edit"
        assert model.plateInstance != null

        plate.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/plate/show/$plate.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        plate.clearErrors()

        populateValidParams(params)
        params.id = plate.id
        params.version = -1
        controller.update()

        assert view == "/plate/edit"
        assert model.plateInstance != null
        assert model.plateInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/plate/list'

        response.reset()

        populateValidParams(params)
        def plate = new Plate(params)

        assert plate.save() != null
        assert Plate.count() == 1

        params.id = plate.id

        controller.delete()

        assert Plate.count() == 0
        assert Plate.get(plate.id) == null
        assert response.redirectedUrl == '/plate/list'
    }
}
