package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(TreatmentDetailController)
@Mock(TreatmentDetail)
class TreatmentDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/treatmentDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.treatmentDetailInstanceList.size() == 0
        assert model.treatmentDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.treatmentDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.treatmentDetailInstance != null
        assert view == '/treatmentDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/treatmentDetail/show/1'
        assert controller.flash.message != null
        assert TreatmentDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentDetail/list'

        populateValidParams(params)
        def treatmentDetail = new TreatmentDetail(params)

        assert treatmentDetail.save() != null

        params.id = treatmentDetail.id

        def model = controller.show()

        assert model.treatmentDetailInstance == treatmentDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentDetail/list'

        populateValidParams(params)
        def treatmentDetail = new TreatmentDetail(params)

        assert treatmentDetail.save() != null

        params.id = treatmentDetail.id

        def model = controller.edit()

        assert model.treatmentDetailInstance == treatmentDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/treatmentDetail/list'

        response.reset()

        populateValidParams(params)
        def treatmentDetail = new TreatmentDetail(params)

        assert treatmentDetail.save() != null

        // test invalid parameters in update
        params.id = treatmentDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/treatmentDetail/edit"
        assert model.treatmentDetailInstance != null

        treatmentDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/treatmentDetail/show/$treatmentDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        treatmentDetail.clearErrors()

        populateValidParams(params)
        params.id = treatmentDetail.id
        params.version = -1
        controller.update()

        assert view == "/treatmentDetail/edit"
        assert model.treatmentDetailInstance != null
        assert model.treatmentDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/treatmentDetail/list'

        response.reset()

        populateValidParams(params)
        def treatmentDetail = new TreatmentDetail(params)

        assert treatmentDetail.save() != null
        assert TreatmentDetail.count() == 1

        params.id = treatmentDetail.id

        controller.delete()

        assert TreatmentDetail.count() == 0
        assert TreatmentDetail.get(treatmentDetail.id) == null
        assert response.redirectedUrl == '/treatmentDetail/list'
    }
}
