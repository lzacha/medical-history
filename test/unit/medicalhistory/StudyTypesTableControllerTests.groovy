package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypesTableController)
@Mock(StudyTypesTable)
class StudyTypesTableControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypesTable/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypesTableInstanceList.size() == 0
        assert model.studyTypesTableInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypesTableInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypesTableInstance != null
        assert view == '/studyTypesTable/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypesTable/show/1'
        assert controller.flash.message != null
        assert StudyTypesTable.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesTable/list'

        populateValidParams(params)
        def studyTypesTable = new StudyTypesTable(params)

        assert studyTypesTable.save() != null

        params.id = studyTypesTable.id

        def model = controller.show()

        assert model.studyTypesTableInstance == studyTypesTable
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesTable/list'

        populateValidParams(params)
        def studyTypesTable = new StudyTypesTable(params)

        assert studyTypesTable.save() != null

        params.id = studyTypesTable.id

        def model = controller.edit()

        assert model.studyTypesTableInstance == studyTypesTable
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesTable/list'

        response.reset()

        populateValidParams(params)
        def studyTypesTable = new StudyTypesTable(params)

        assert studyTypesTable.save() != null

        // test invalid parameters in update
        params.id = studyTypesTable.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypesTable/edit"
        assert model.studyTypesTableInstance != null

        studyTypesTable.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypesTable/show/$studyTypesTable.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypesTable.clearErrors()

        populateValidParams(params)
        params.id = studyTypesTable.id
        params.version = -1
        controller.update()

        assert view == "/studyTypesTable/edit"
        assert model.studyTypesTableInstance != null
        assert model.studyTypesTableInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesTable/list'

        response.reset()

        populateValidParams(params)
        def studyTypesTable = new StudyTypesTable(params)

        assert studyTypesTable.save() != null
        assert StudyTypesTable.count() == 1

        params.id = studyTypesTable.id

        controller.delete()

        assert StudyTypesTable.count() == 0
        assert StudyTypesTable.get(studyTypesTable.id) == null
        assert response.redirectedUrl == '/studyTypesTable/list'
    }
}
