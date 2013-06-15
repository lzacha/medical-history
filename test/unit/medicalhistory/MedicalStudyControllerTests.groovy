package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(MedicalStudyController)
@Mock(MedicalStudy)
class MedicalStudyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/medicalStudy/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.medicalStudyInstanceList.size() == 0
        assert model.medicalStudyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.medicalStudyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.medicalStudyInstance != null
        assert view == '/medicalStudy/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/medicalStudy/show/1'
        assert controller.flash.message != null
        assert MedicalStudy.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudy/list'

        populateValidParams(params)
        def medicalStudy = new MedicalStudy(params)

        assert medicalStudy.save() != null

        params.id = medicalStudy.id

        def model = controller.show()

        assert model.medicalStudyInstance == medicalStudy
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudy/list'

        populateValidParams(params)
        def medicalStudy = new MedicalStudy(params)

        assert medicalStudy.save() != null

        params.id = medicalStudy.id

        def model = controller.edit()

        assert model.medicalStudyInstance == medicalStudy
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudy/list'

        response.reset()

        populateValidParams(params)
        def medicalStudy = new MedicalStudy(params)

        assert medicalStudy.save() != null

        // test invalid parameters in update
        params.id = medicalStudy.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/medicalStudy/edit"
        assert model.medicalStudyInstance != null

        medicalStudy.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/medicalStudy/show/$medicalStudy.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        medicalStudy.clearErrors()

        populateValidParams(params)
        params.id = medicalStudy.id
        params.version = -1
        controller.update()

        assert view == "/medicalStudy/edit"
        assert model.medicalStudyInstance != null
        assert model.medicalStudyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudy/list'

        response.reset()

        populateValidParams(params)
        def medicalStudy = new MedicalStudy(params)

        assert medicalStudy.save() != null
        assert MedicalStudy.count() == 1

        params.id = medicalStudy.id

        controller.delete()

        assert MedicalStudy.count() == 0
        assert MedicalStudy.get(medicalStudy.id) == null
        assert response.redirectedUrl == '/medicalStudy/list'
    }
}
