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

WebUI.enableSmartWait()

'Verify Logo'
WebUI.verifyElementVisible(findTestObject('Common Objects/img_LogoMain'))

WebUI.delay(1)

'Click Hamburger menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

'Click Library menu'
WebUI.click(findTestObject('Sprint1/LandingPage/a_Library'))

WebUI.delay(1)

'Click Lading Port sub menu'
WebUI.click(findTestObject('Sprint1/LandingPage/a_LadingPort'))

WebUI.delay(1)

'Verify Lading Port Page Title'
WebUI.verifyElementPresent(findTestObject('Sprint5/divPageHeader_LadingPort'), 0)

