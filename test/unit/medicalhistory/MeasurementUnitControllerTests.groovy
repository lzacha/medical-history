package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(MeasurementUnitController)
@Mock(MeasurementUnit)
class MeasurementUnitControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/measurementUnit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.measurementUnitInstanceList.size() == 0
        assert model.measurementUnitInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.measurementUnitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.measurementUnitInstance != null
        assert view == '/measurementUnit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/measurementUnit/show/1'
        assert controller.flash.message != null
        assert MeasurementUnit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/measurementUnit/list'

        populateValidParams(params)
        def measurementUnit = new MeasurementUnit(params)

        assert measurementUnit.save() != null

        params.id = measurementUnit.id

        def model = controller.show()

        assert model.measurementUnitInstance == measurementUnit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/measurementUnit/list'

        populateValidParams(params)
        def measurementUnit = new MeasurementUnit(params)

        assert measurementUnit.save() != null

        params.id = measurementUnit.id

        def model = controller.edit()

        assert model.measurementUnitInstance == measurementUnit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/measurementUnit/list'

        response.reset()

        populateValidParams(params)
        def measurementUnit = new MeasurementUnit(params)

        assert measurementUnit.save() != null

        // test invalid parameters in update
        params.id = measurementUnit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/measurementUnit/edit"
        assert model.measurementUnitInstance != null

        measurementUnit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/measurementUnit/show/$measurementUnit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        measurementUnit.clearErrors()

        populateValidParams(params)
        params.id = measurementUnit.id
        params.version = -1
        controller.update()

        assert view == "/measurementUnit/edit"
        assert model.measurementUnitInstance != null
        assert model.measurementUnitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/measurementUnit/list'

        response.reset()

        populateValidParams(params)
        def measurementUnit = new MeasurementUnit(params)

        assert measurementUnit.save() != null
        assert MeasurementUnit.count() == 1

        params.id = measurementUnit.id

        controller.delete()

        assert MeasurementUnit.count() == 0
        assert MeasurementUnit.get(measurementUnit.id) == null
        assert response.redirectedUrl == '/measurementUnit/list'
    }
}
