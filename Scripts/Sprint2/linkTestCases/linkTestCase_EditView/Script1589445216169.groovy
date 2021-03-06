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

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

'Click Edit View'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Edit View'))

if (viewType.equals('System')) {
    'Verify popup header '
    WebUI.verifyElementPresent(findTestObject('Sprint6/h5_Manage Views Edit System View'), 0)
} else if (viewType.equals('Custom')) {
    'Verify popup header'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Views Edit Custom View'), 0)
}

viewName = (viewName + 'Edited')

WebUI.sendKeys(findTestObject('Sprint6/input__ViewName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Enter View Name'
WebUI.sendKeys(findTestObject('Sprint6/input__ViewName'), viewName)

for(String attr : editedAttributes)
{

'Select Label'
WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : attr]), FailureHandling.STOP_ON_FAILURE)
}

/*'Select Label - Year'
WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), FailureHandling.STOP_ON_FAILURE)
*/
'Click Move to Left button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_MoveToLeft'))

for(String attr : editedAttributes)
{
'Verify Element not present'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : attr]), 0)
}

/*'Verify Element not present - Year'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), 0)
*/

if(sortByGroupBy.equals("Yes"))
{
'Select Lock Column - 2'
WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), 'Column 2', true)

'Click Desc button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_DESC'))
}

'Click Save View button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Save View'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Modified'), 0)

'Verify in popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_parameterized has been modified successfully', [('viewName') : viewName]), 
    0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(2)

'Verify Selected View Name displayed or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Verify table header - ACTIONS'
not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ACTIONS'), 0)

for(String attr : editedAttributes)
{
	'Verify table header - Type'
	WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_param',[('columnName'):attr]), 0)
}


