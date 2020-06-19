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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

/*if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Brand Change'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint8/p_BrandChange_Confirmation', [('brandName') : Brand]), 0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

WebUI.waitForPageLoad(0)

WebUI.verifyOptionPresentByLabel(findTestObject('Sprint8/Select_Division'), Division, true, 0)

WebUI.selectOptionByLabel(findTestObject('Sprint8/Select_Division'), Division, true)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Division Change'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint8/p_DivisionChangeConfirmation', [('divisionName') : Division]), 
    0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))*/


WebUI.click(findTestObject('Sprint8/img_PlusIcon'))

WebUI.click(findTestObject('Object Repository/Sprint8/span_Add additional field to filter by'))

WebUI.click(findTestObject('Sprint8/select_Field_CustomFilter'))

WebUI.click(findTestObject('Sprint8/span_AttributeSelection', [('attributeName') : attributeName]))

WebUI.selectOptionByLabel(findTestObject('Sprint8/select_Operator_CustomFilter'), Operator, false)

if (!(Operator.equals('Is Empty') || !AttributeType.toString().equals("Text"))) {
    WebUI.click(findTestObject('Object Repository/Sprint8/select_Field_Value'))

    WebUI.click(findTestObject('Sprint8/span_AttributeSelection', [('attributeName') : Value]))
}

if(AttributeType.toString().equals("Text"))
{
	WebUI.click(findTestObject('Object Repository/Sprint8/input_EnterText_FilterHeader'))
	
	WebUI.sendKeys(findTestObject('Object Repository/Sprint8/input_EnterText_FilterHeader'), Value)
}

WebUI.click(findTestObject('Object Repository/Sprint8/button_Apply Filter'))

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_Library'), Brand, true, 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint8/Select_Division'), Division, true, 0)

if(!(Operator.equals('Is Empty'))) {
WebUI.verifyElementPresent(findTestObject('Sprint8/div_FilterApplied', [('filterApplied') : (attributeName + Operator) + 
            Value]), 0)
}
else
{
	WebUI.verifyElementPresent(findTestObject('Sprint8/div_FilterApplied', [('filterApplied') : (attributeName + Operator)]), 0)
}

List<String> listOfExistingElements = WebUI.findWebElements(findTestObject('Object Repository/Sprint8/div_ColumnIndexNo'), 
    1)

int columnNo = 0

for (WebElement element : listOfExistingElements) {
    columnNo++

    if (element.getAttribute('title').equals(attributeName)) {
        break
    }
}

List<String> listOfExistingCells = WebUI.findWebElements(findTestObject('Object Repository/Sprint8/div_CellsByIndex', [('indexNo') : columnNo]), 
    1)

if (Operator.equals('Contains')) {
    for (WebElement element : listOfExistingCells) {
        if (!(element.getAttribute('title').contains(Value))) {
            throw new Exception('Contains Filter not working as expected')
        }
    }
} else if (Operator.equals('Does Not Contain')) {
    for (WebElement element : listOfExistingCells) {
        if (element.getAttribute('title').contains(Value)) {
            throw new Exception('Is Not Filter not working as expected')
        }
    }
} else if (Operator.equals('Is') || Operator.equals('Is Equal')) {
    for (WebElement element : listOfExistingCells) {
        if (!(element.getAttribute('title').equals(Value))) {
            throw new Exception('Is /Is Equal Filter not working as expected')
        }
    }
} else if (Operator.equals('Is Not')) {
    for (WebElement element : listOfExistingCells) {
        if (element.getAttribute('title').contains(Value)) {
            throw new Exception('Is Not Filter not working as expected')
        }
    }
} else if (Operator.equals('Starts with')) {
    for (WebElement element : listOfExistingCells) {
        if (!(element.getAttribute('title').startsWith(Value))) {
            throw new Exception('Starts with Filter not working as expected')
        }
    }
} else if (Operator.equals('Ends with')) {
    for (WebElement element : listOfExistingCells) {
        if (!(element.getAttribute('title').endsWith(Value))) {
            throw new Exception('Ends with Filter not working as expected')
        }
    }
} else if (Operator.equals('Is Empty')) {
    for (WebElement element : listOfExistingCells) {
        if (!(element.getText().equals(""))) {
            throw new Exception('Ends with Filter not working as expected')
        }
    }
} else if (Operator.equals('Is Equal')) {
    for (WebElement element : listOfExistingCells) {
        SimpleDateFormat sdformat = new SimpleDateFormat('MM-dd-yyyy')

        Date d1 = sdformat.parse(Value)

        Date d2 = sdformat.parse(element.getAttribute('title'))

        if (d1.compareTo(d2) != 0) {
            throw new Exception('Is Equal Filter not working as expected')
        }
    }
} else if (Operator.equals('Is After')) {
    for (WebElement element : listOfExistingCells) {
        SimpleDateFormat sdformat = new SimpleDateFormat('MM-dd-yyyy')

        Date d1 = sdformat.parse(Value)

        Date d2 = sdformat.parse(element.getAttribute('title'))

        if (!(d1.compareTo(d2) > 0)) {
            throw new Exception('Is After with Filter not working as expected')
        }
    }
} else if (Operator.equals('Is Before')) {
    for (WebElement element : listOfExistingCells) {
        SimpleDateFormat sdformat = new SimpleDateFormat('MM-dd-yyyy')

        Date d1 = sdformat.parse(Value)

        Date d2 = sdformat.parse(element.getAttribute('title'))

        if (!(d1.compareTo(d2) < 0)) {
            throw new Exception('Is Before with Filter not working as expected')
        }
    }
}
else if (Operator.equals('Range'))
{
	for (WebElement element : listOfExistingCells) {
		SimpleDateFormat sdformat = new SimpleDateFormat('MM-dd-yyyy')

		Date d = sdformat.parse(Value)
		
		Date d1 = sdformat.parse(Value1)

		Date d2 = sdformat.parse(element.getAttribute('title'))

		if (!(d2 >= d && d2 <= d1)) {
			throw new Exception('Range Filter not working as expected')
		}
	}
}