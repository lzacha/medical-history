package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(PlateDetailController)
@Mock(PlateDetail)
class PlateDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/plateDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.plateDetailInstanceList.size() == 0
        assert model.plateDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.plateDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.plateDetailInstance != null
        assert view == '/plateDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/plateDetail/show/1'
        assert controller.flash.message != null
        assert PlateDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/plateDetail/list'

        populateValidParams(params)
        def plateDetail = new PlateDetail(params)

        assert plateDetail.save() != null

        params.id = plateDetail.id

        def model = controller.show()

        assert model.plateDetailInstance == plateDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/plateDetail/list'

        populateValidParams(params)
        def plateDetail = new PlateDetail(params)

        assert plateDetail.save() != null

        params.id = plateDetail.id

        def model = controller.edit()

        assert model.plateDetailInstance == plateDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/plateDetail/list'

        response.reset()

        populateValidParams(params)
        def plateDetail = new PlateDetail(params)

        assert plateDetail.save() != null

        // test invalid parameters in update
        params.id = plateDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/plateDetail/edit"
        assert model.plateDetailInstance != null

        plateDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/plateDetail/show/$plateDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        plateDetail.clearErrors()

        populateValidParams(params)
        params.id = plateDetail.id
        params.version = -1
        controller.update()

        assert view == "/plateDetail/edit"
        assert model.plateDetailInstance != null
        assert model.plateDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/plateDetail/list'

        response.reset()

        populateValidParams(params)
        def plateDetail = new PlateDetail(params)

        assert plateDetail.save() != null
        assert PlateDetail.count() == 1

        params.id = plateDetail.id

        controller.delete()

        assert PlateDetail.count() == 0
        assert PlateDetail.get(plateDetail.id) == null
        assert response.redirectedUrl == '/plateDetail/list'
    }
}
