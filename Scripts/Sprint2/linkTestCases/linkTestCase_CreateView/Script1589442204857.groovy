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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if(fromHamburger.equals('true'))
{
	'Navigate through Hamburger menu'
	WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : libraryName],
		FailureHandling.STOP_ON_FAILURE)
}

if(libraryName.equals('Season'))
{
	WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)
	
		WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)
	
		WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Brand Change'), 0)
	
		WebUI.verifyElementPresent(findTestObject('Sprint8/p_BrandChange_Confirmation', [('brandName') : Brand]), 0)
	
		WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))
	
		WebUI.waitForPageLoad(0)
	
		WebUI.verifyOptionPresentByLabel(findTestObject('Sprint8/Select_Division'), Division, true, 0)
	
		WebUI.selectOptionByLabel(findTestObject('Sprint8/Select_Division'), Division, true)
	
		WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Division Change'), 0)
	
		WebUI.verifyElementPresent(findTestObject('Sprint8/p_DivisionChangeConfirmation', [('divisionName') : Division]), 0)
	
		WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))
	
}

if(libraryName.equals('Merch List'))
{
	WebUI.waitForElementPresent(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)
	
		WebUI.waitForElementVisible(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)
	
		WebUI.waitForElementPresent(findTestObject('Object Repository/Sprint6/select_Library_optionParameterized',[('option'):Brand]), 0)
	
		WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)
	
		WebUI.delay(5)
	
		WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)
	
		WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/span_Select Department'), 0)
	
		WebUI.delay(5)
	
		WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)
	
		WebUI.waitForPageLoad(0)
	
		WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)
	
		WebUI.click(findTestObject('Object Repository/Sprint8/span_Select Department'))
	
		WebUI.waitForPageLoad(0)
	
		WebUI.delay(5)
	
		WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Division]))
	
		WebUI.click(findTestObject('Sprint8/img_Select_Department_dropdown'))
	
		WebUI.waitForElementClickable(findTestObject('Sprint8/Select_Season_dropdown'), 0)
	
		WebUI.click(findTestObject('Sprint8/Select_Season_dropdown'))
	
		WebUI.click(findTestObject('Object Repository/Sprint8/span_parameterized', [('param') : Season]))
	
		WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))
	
}

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Seasons')

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Verify Manage Views title'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Views'), 0)

'Verify the in popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_Select a view to make changes to its defi_80fece'), 
    0)

'Verify New View button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_New View'), 0)

'Verify Copy View button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Copy View'), 0)

'Verify Edit View button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Edit View'), 0)

'Verify Share button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Share'), 0)

'Verify Delete button'
WebUI.verifyElementPresent(findTestObject('Sprint6/img_DeleteViewIcon'), 0)

'Verify UP button'
WebUI.verifyElementPresent(findTestObject('Sprint6/img_UP'), 0)

'Verify Down button'
WebUI.verifyElementPresent(findTestObject('Sprint6/img_Down'), 0)

'Verify Cancel button'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_Cancel'), 0)

'Verify New View button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_New View'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Views  Create new view'), 0)

'Verify in popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h6_Which type of view are you creating'), 0)

if (viewType.equals('System')) {
    'Verify Custom View radio button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), 0)

    'Click System View radio button'
    WebUI.click(findTestObject('Object Repository/Sprint6/span_System View'))
} else if (viewType.equals('Custom')) {
    'Click Custom View radio button'
    WebUI.click(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), FailureHandling.STOP_ON_FAILURE)

    'Verify System View radio button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_System View'), 0)
}

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

if (viewType.equals('System')) {
    'Verify the popup header'
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Create new System View'))

    'Verify the System View Name Label'
    WebUI.verifyElementVisible(findTestObject('Sprint6/label_System View Name'))
} else if (viewType.equals('Custom')) {
    'Verify the popup header'
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views  Create new Custom View'))

    'Verify the Custom View Name label'
    WebUI.verifyElementVisible(findTestObject('Sprint6/label_Custom View Name'))
}

'Enter View Name'
WebUI.setText(findTestObject('Sprint6/input__ViewName'), viewName)

'Verify library : Season Visible'
WebUI.verifyElementVisible(findTestObject('Sprint6/div_Type_parameterized',[('libraryName'):libraryName]))

'Click Save Views at Highest level label'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Save views at Highest Type Level'))

'Verify Configure View Settings section'
WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/strong_Configure View Settings'))

'Verify Available fields section'
WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/strong_Available Fields'))

for(String attr : attributesList)
{
	WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : attr]))
}

/*'Click Brand Label'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Brand'))

'Click Division label'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Division'))

'Click In Store Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint6/label_In Store Launch End Date'))

'Click In Store Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint6/label_In Store Launch Start Date'))

'Click Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Internet Launch Start Date'))

'Click Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Internet Launch End Date'))

'Click Name'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Name'))

'Click Season'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Season'))

'Click Type'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Type'))

'Click Year'
WebUI.click(findTestObject('Object Repository/Sprint6/label_Year'))
*/
'Click Move to Right button'
WebUI.click(findTestObject('Sprint6/button_moveToRightAttributes'))

for(String attr : attributesList)
{
	WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : attr]), 0)
}

/*'Verify the Seleted Label - Brand'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Brand']), 0)

'Verify the Seleted Label - Division'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Division']), 0)

'Verify the Seleted Label - In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'In Store Launch End Date']), 
    0)

'Verify the Seleted Label - In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'In Store Launch Start Date']), 
    0)

'Verify the Seleted Label - Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Internet Launch Start Date']), 
    0)

'Verify the Seleted Label - Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Internet Launch End Date']), 
    0)

'Verify the Seleted Label - Name'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

'Verify the Seleted Label - Season'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), 0)

'Verify the Seleted Label - Type'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Type']), 0)

'Verify the Seleted Label - Year'
WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), 0)
*/
if (viewType.equals('System')) {
    'Verify Assign User Groups section'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Seasons/Page_Merch Collaboration Platform/strong_Assign User Groups'), 
        0)

    'Verify Available Groups section'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Seasons/Page_Merch Collaboration Platform/strong_Available Groups'), 
        0)

    'Verify Assigned groups section'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Seasons/Page_Merch Collaboration Platform/strong_Assigned Groups'), 
        0)

    'Verify Search input field'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Seasons/Page_Merch Collaboration Platform/input_Available Groups_search-flelds'), 
        0)

    'Verify Roles section'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Seasons/Page_Merch Collaboration Platform/div_ROLES'), 
        0)

    if (!(roleToAssign.equals(''))) {
        'Click System Administrator label'
        WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : roleToAssign]))

        'Click Move to Right button'
        WebUI.click(findTestObject('Object Repository/Sprint6/button_moveToRightRoles'))

        'Verify Element Present'
        WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_AssignedGroups', [('label') : roleToAssign]), 0)
    }
}

'Verify the Lock Columns text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Lock Columns'), 0)

'Verify the Lock Columns sub text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_Locking columns will freeze the first sec_986106'), 
    0)

'Verify Lock Column Label'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Lock Column(s)'), 0)

if(!lockColumn.equals(""))
{
	'Verify Lock Column Label'
	WebUI.click(findTestObject('Object Repository/Sprint6/label_Lock Column(s)'), FailureHandling.STOP_ON_FAILURE)
	
	'Select the Lock Column  - 3'
	WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), lockColumn, true)
}

'Verify the Group By heading'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Group By'), 0)

if(!groupBy.equals(""))
{
	'Verify the Add additional field to group by span'
	WebUI.click(findTestObject('Object Repository/Sprint6/span_Add additional field to group by'))
	
	'Select the Group By'
	WebUI.selectOptionByLabel(findTestObject('Sprint6/select_GroupByDropDown'), groupBy, true)
	
	'Verify the selected Group By'
	WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_GroupByDropDown'), groupBy, true, 0)
	
	'Click Asc button'
	WebUI.click(findTestObject('Object Repository/Sprint6/button_ASC'))
}

'Verify Sort By heading'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Sort By'), 0)

if(!sortBy.equals(""))
{
	'Click Add additional field to sort by'
	WebUI.click(findTestObject('Object Repository/Sprint6/span_Add additional field to sort by'))
	
	'Select Sort By'
	WebUI.selectOptionByLabel(findTestObject('Sprint6/select_SortByDropDown'), sortBy, true)
	
	'Verify the selected Sort By'
	WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_SortByDropDown'), sortBy, true, 0)
	
	'Click Desc button'
	WebUI.click(findTestObject('Object Repository/Sprint6/button_SortBySortOrderClick', [('order') : 'DESC']))
	
}


'Click Save View button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

'Verify the popup header '
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

'Verify the in popup text'
WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]), 
    0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click the respective View'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.waitForPageLoad(60)

'Verify table header - ACTIONS '
not_run:WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint6/div_ACTIONS'), FailureHandling.STOP_ON_FAILURE)

GlobalVariable.stopTime  = System.currentTimeMillis();

long totalTime = GlobalVariable.stopTime - GlobalVariable.startTime;

WebUI.comment("Manage Season - Total Time for page load - "+totalTime)

WebUI.delay(2)

'Verify the selected view displayed'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Verify table header - ACTIONS '
not_run:WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ACTIONS'), 0)

if(lockColumn.equals("Column 1"))
{
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(0)]), 0)
	for (int i = 1; i < attributesList.size(); i++) {
		WebUI.verifyElementPresent(findTestObject('Sprint6/div_param',[('columnName'):attributesList.get(i)]), 0)
	}
}

if(lockColumn.equals("Column 2"))
{
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(0)]), 0)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(1)]), 0)
	for (int i = 2; i < attributesList.size(); i++) {
		WebUI.verifyElementPresent(findTestObject('Sprint6/div_param',[('columnName'):attributesList.get(i)]), 0)
	}
}

if(lockColumn.equals("Column 3"))
{
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(0)]), 0)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(1)]), 0)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_columnFreezed_param', [('param') : attributesList.get(2)]), 0)
	for (int i =3; i < attributesList.size(); i++) {
		WebUI.verifyElementPresent(findTestObject('Sprint6/div_param',[('columnName'):attributesList.get(i)]), 0)
	}
}

/*'Verify table header - Brand'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Brand'), 0)

'Verify table header - Division'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Division'), 0)

'Verify table header - In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch End Date'), 0)

'Verify table header - In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch Start Date'), 0)

'Verify table header - Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch Start Date'), 0)

'Verify table header - Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch End Date'), 0)

'Verify table header - Name'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_param',[('columnName'):'Name']), 0)

'Verify table header - Season'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Season'), 0)

'Verify table header - Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Type'), 0)

'Verify table header - Year'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Year'), 0)*/

