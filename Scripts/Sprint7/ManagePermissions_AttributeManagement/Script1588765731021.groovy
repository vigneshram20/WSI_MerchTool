import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA AUT Role', 'ddMMMHHmmss')

roleName = roleName.toLowerCase();

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA', 'ss')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateRoleAlone'), [('roleDescription') : roleDescription, ('roleName') : roleName], 
    FailureHandling.STOP_ON_FAILURE)

'Assign Permission To Role'
WebUI.callTestCase(findTestCase('Sprint7/linkTestCases/linkTestCase_AssignPermissionToRoleForLibraryAlone'), [('roleName') : roleName
		, ('libraryName') : 'Season', ('permissionValues') : permissionValues], FailureHandling.STOP_ON_FAILURE)

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'mmss')

String libraryName = 'Root'

String listNameInternal = 'QAML' + dateFormat

String listNameDisplay = 'QA AUT ML ' + dateFormat

String listValue = 'QATest'

String RoleAccess = 'Create'

WebUI.callTestCase(findTestCase('Sprint5/linkTestCases/linkTesCase_CreateMasterList'), [('folderName') : libraryName, ('InternalName') : listNameInternal
        , ('DisplayName') : listNameDisplay, ('listItem') : listValue], FailureHandling.STOP_ON_FAILURE)

String singleListInternalName = 'QAAUTSL' + dateFormat
String singleListDisplayName = 'QA AUT SL ' + dateFormat

if (!(libraryName.equals('Root'))) {
    String Master_List_Full_Name = (libraryName + ' | ') + listNameDisplay
} else {
    Master_List_Full_Name = listNameDisplay
}

WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_CreateAttributeAlone'), [('DataType') : 'String', ('AttributeType') : 'Single List'
        , ('InternalName') : singleListInternalName, ('DisplayName') : singleListDisplayName, ('MasterList') : Master_List_Full_Name], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint7/linkTestCases/linkTestCase_AssignPermission_Attribute'), [('attributeName') : singleListDisplayName
        , ('paramName') : listValue, ('RoleName') : roleName, ('RoleAccess') : RoleAccess], FailureHandling.STOP_ON_FAILURE)

List<String> attrValues = new ArrayList<LinkedHashMap>()

attrValues.add(singleListInternalName)

WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_DeleteAttributeByInternalName'), [('InternalNames') : attrValues], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Manage Permissions'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_td_permission_table_verification', [('attributeName') : singleListDisplayName
            , ('paramName') : listValue, ('permission') : RoleAccess, ('roleName') : roleName]), 0)

