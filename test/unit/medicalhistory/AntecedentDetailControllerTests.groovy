package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(AntecedentDetailController)
@Mock(AntecedentDetail)
class AntecedentDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/antecedentDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.antecedentDetailInstanceList.size() == 0
        assert model.antecedentDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.antecedentDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.antecedentDetailInstance != null
        assert view == '/antecedentDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/antecedentDetail/show/1'
        assert controller.flash.message != null
        assert AntecedentDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentDetail/list'

        populateValidParams(params)
        def antecedentDetail = new AntecedentDetail(params)

        assert antecedentDetail.save() != null

        params.id = antecedentDetail.id

        def model = controller.show()

        assert model.antecedentDetailInstance == antecedentDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentDetail/list'

        populateValidParams(params)
        def antecedentDetail = new AntecedentDetail(params)

        assert antecedentDetail.save() != null

        params.id = antecedentDetail.id

        def model = controller.edit()

        assert model.antecedentDetailInstance == antecedentDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentDetail/list'

        response.reset()

        populateValidParams(params)
        def antecedentDetail = new AntecedentDetail(params)

        assert antecedentDetail.save() != null

        // test invalid parameters in update
        params.id = antecedentDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/antecedentDetail/edit"
        assert model.antecedentDetailInstance != null

        antecedentDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/antecedentDetail/show/$antecedentDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        antecedentDetail.clearErrors()

        populateValidParams(params)
        params.id = antecedentDetail.id
        params.version = -1
        controller.update()

        assert view == "/antecedentDetail/edit"
        assert model.antecedentDetailInstance != null
        assert model.antecedentDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/antecedentDetail/list'

        response.reset()

        populateValidParams(params)
        def antecedentDetail = new AntecedentDetail(params)

        assert antecedentDetail.save() != null
        assert AntecedentDetail.count() == 1

        params.id = antecedentDetail.id

        controller.delete()

        assert AntecedentDetail.count() == 0
        assert AntecedentDetail.get(antecedentDetail.id) == null
        assert response.redirectedUrl == '/antecedentDetail/list'
    }
}
