package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(AgeRangesController)
@Mock(AgeRanges)
class AgeRangesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ageRanges/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ageRangesInstanceList.size() == 0
        assert model.ageRangesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ageRangesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ageRangesInstance != null
        assert view == '/ageRanges/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ageRanges/show/1'
        assert controller.flash.message != null
        assert AgeRanges.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRanges/list'

        populateValidParams(params)
        def ageRanges = new AgeRanges(params)

        assert ageRanges.save() != null

        params.id = ageRanges.id

        def model = controller.show()

        assert model.ageRangesInstance == ageRanges
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRanges/list'

        populateValidParams(params)
        def ageRanges = new AgeRanges(params)

        assert ageRanges.save() != null

        params.id = ageRanges.id

        def model = controller.edit()

        assert model.ageRangesInstance == ageRanges
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ageRanges/list'

        response.reset()

        populateValidParams(params)
        def ageRanges = new AgeRanges(params)

        assert ageRanges.save() != null

        // test invalid parameters in update
        params.id = ageRanges.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ageRanges/edit"
        assert model.ageRangesInstance != null

        ageRanges.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ageRanges/show/$ageRanges.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ageRanges.clearErrors()

        populateValidParams(params)
        params.id = ageRanges.id
        params.version = -1
        controller.update()

        assert view == "/ageRanges/edit"
        assert model.ageRangesInstance != null
        assert model.ageRangesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ageRanges/list'

        response.reset()

        populateValidParams(params)
        def ageRanges = new AgeRanges(params)

        assert ageRanges.save() != null
        assert AgeRanges.count() == 1

        params.id = ageRanges.id

        controller.delete()

        assert AgeRanges.count() == 0
        assert AgeRanges.get(ageRanges.id) == null
        assert response.redirectedUrl == '/ageRanges/list'
    }
}
