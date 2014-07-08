package medicalhistory

import grails.test.mixin.*

@TestFor(UnitsController)
@Mock(Units)
class UnitsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/units/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.unitsInstanceList.size() == 0
        assert model.unitsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.unitsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.unitsInstance != null
        assert view == '/units/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/units/show/1'
        assert controller.flash.message != null
        assert Units.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/units/list'

        populateValidParams(params)
        def units = new Units(params)

        assert units.save() != null

        params.id = units.id

        def model = controller.show()

        assert model.unitsInstance == units
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/units/list'

        populateValidParams(params)
        def units = new Units(params)

        assert units.save() != null

        params.id = units.id

        def model = controller.edit()

        assert model.unitsInstance == units
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/units/list'

        response.reset()

        populateValidParams(params)
        def units = new Units(params)

        assert units.save() != null

        // test invalid parameters in update
        params.id = units.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/units/edit"
        assert model.unitsInstance != null

        units.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/units/show/$units.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        units.clearErrors()

        populateValidParams(params)
        params.id = units.id
        params.version = -1
        controller.update()

        assert view == "/units/edit"
        assert model.unitsInstance != null
        assert model.unitsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/units/list'

        response.reset()

        populateValidParams(params)
        def units = new Units(params)

        assert units.save() != null
        assert Units.count() == 1

        params.id = units.id

        controller.delete()

        assert Units.count() == 0
        assert Units.get(units.id) == null
        assert response.redirectedUrl == '/units/list'
    }
}
