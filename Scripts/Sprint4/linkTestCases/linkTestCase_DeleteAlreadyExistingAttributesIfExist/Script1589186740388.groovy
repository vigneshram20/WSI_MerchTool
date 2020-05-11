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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.Keys as Keys

List<WebElement> listOfExistingElements = WebUI.findWebElements(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized',[('internalName'):InternalName]),
	1)

for (WebElement checkbox : listOfExistingElements) {
	Thread.sleep(100)

	'Select the Checkbox'
	checkbox.click()

	 'Scroll To Manage Layout button'
	WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

	'Scroll Page Down'
	WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

	WebUI.delay(1)

	'Click Remove icon'
	WebUI.click(findTestObject('Sprint4/img_Attributes_remove-icon'))

	WebUI.delay(2)

	'Verify Header'
	WebUI.verifyElementPresent(findTestObject('Sprint4/div_DeleteNote'), 10)

	'Click Save and Verify Success Popup'
	WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Scroll Page Up'
	WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))
	
		WebUI.delay(1)
		
	'Click Edit Mode Toggle button'
	WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
}
