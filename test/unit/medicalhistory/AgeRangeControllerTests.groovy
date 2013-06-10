package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(AgeRangeController)
@Mock(AgeRange)
class AgeRangeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ageRange/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ageRangeInstanceList.size() == 0
        assert model.ageRangeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ageRangeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ageRangeInstance != null
        assert view == '/ageRange/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ageRange/show/1'
        assert controller.flash.message != null
        assert AgeRange.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRange/list'

        populateValidParams(params)
        def ageRange = new AgeRange(params)

        assert ageRange.save() != null

        params.id = ageRange.id

        def model = controller.show()

        assert model.ageRangeInstance == ageRange
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRange/list'

        populateValidParams(params)
        def ageRange = new AgeRange(params)

        assert ageRange.save() != null

        params.id = ageRange.id

        def model = controller.edit()

        assert model.ageRangeInstance == ageRange
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRange/list'

        response.reset()

        populateValidParams(params)
        def ageRange = new AgeRange(params)

        assert ageRange.save() != null

        // test invalid parameters in update
        params.id = ageRange.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ageRange/edit"
        assert model.ageRangeInstance != null

        ageRange.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ageRange/show/$ageRange.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ageRange.clearErrors()

        populateValidParams(params)
        params.id = ageRange.id
        params.version = -1
        controller.update()

        assert view == "/ageRange/edit"
        assert model.ageRangeInstance != null
        assert model.ageRangeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ageRange/list'

        response.reset()

        populateValidParams(params)
        def ageRange = new AgeRange(params)

        assert ageRange.save() != null
        assert AgeRange.count() == 1

        params.id = ageRange.id

        controller.delete()

        assert AgeRange.count() == 0
        assert AgeRange.get(ageRange.id) == null
        assert response.redirectedUrl == '/ageRange/list'
    }
}
