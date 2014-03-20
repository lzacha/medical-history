package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(MeasureUnitController)
@Mock(MeasureUnit)
class MeasureUnitControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/measureUnit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.measureUnitInstanceList.size() == 0
        assert model.measureUnitInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.measureUnitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.measureUnitInstance != null
        assert view == '/measureUnit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/measureUnit/show/1'
        assert controller.flash.message != null
        assert MeasureUnit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/measureUnit/list'

        populateValidParams(params)
        def measureUnit = new MeasureUnit(params)

        assert measureUnit.save() != null

        params.id = measureUnit.id

        def model = controller.show()

        assert model.measureUnitInstance == measureUnit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/measureUnit/list'

        populateValidParams(params)
        def measureUnit = new MeasureUnit(params)

        assert measureUnit.save() != null

        params.id = measureUnit.id

        def model = controller.edit()

        assert model.measureUnitInstance == measureUnit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/measureUnit/list'

        response.reset()

        populateValidParams(params)
        def measureUnit = new MeasureUnit(params)

        assert measureUnit.save() != null

        // test invalid parameters in update
        params.id = measureUnit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/measureUnit/edit"
        assert model.measureUnitInstance != null

        measureUnit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/measureUnit/show/$measureUnit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        measureUnit.clearErrors()

        populateValidParams(params)
        params.id = measureUnit.id
        params.version = -1
        controller.update()

        assert view == "/measureUnit/edit"
        assert model.measureUnitInstance != null
        assert model.measureUnitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/measureUnit/list'

        response.reset()

        populateValidParams(params)
        def measureUnit = new MeasureUnit(params)

        assert measureUnit.save() != null
        assert MeasureUnit.count() == 1

        params.id = measureUnit.id

        controller.delete()

        assert MeasureUnit.count() == 0
        assert MeasureUnit.get(measureUnit.id) == null
        assert response.redirectedUrl == '/measureUnit/list'
    }
}
