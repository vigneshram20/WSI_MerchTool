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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RC

def hostName = RC.getHostName();

if(hostName.contains("wsgc"))
{
	hostName = "CITRIX"
}
else
{
	hostName = "LOCAL"
}

BrandConcat = ((((Brand + ' > ') + Division) + ' > ') + Season)

String sheetName = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'ddMMMyyyy HH.mm.ss') + '(IST)-'+hostName //+executionProfile

CustomKeywords.'myKeywords.customKeywords.createSheetAndColumn'(sheetName)

//CustomKeywords.'myKeywords.GoogleSheetsAPI.createSheetAndColumn'(sheetName)

GlobalVariable.ExcelSheetName = sheetName

String[] Department = Division.toString().split('>')

int innerIterationCount = 5

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

'Verify Logo'
WebUI.verifyElementVisible(findTestObject('Common Objects/img_LogoMain'))

WebUI.takeScreenshot()

WebUI.verifyElementClickable(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.takeScreenshot()

for (int outerIteration = 0; outerIteration < 2; outerIteration++) {
    'Click Hamburger menu'
    WebUI.enhancedClick(findTestObject('Common Objects/img_HamburgerMenu'))

    'Click menu'
    WebUI.verifyElementClickable(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : 'User Profile']))

    'Click menu'
    WebUI.enhancedClick(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : 'User Profile']))

    GlobalVariable.startTime = System.currentTimeMillis()

    try {
        WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/textarea_roles_userProfilePage'), FailureHandling.STOP_ON_FAILURE)

        'Check Page Performance'
        long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('User Profile', 0)

        long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('User Profile')

        CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'User Profile', domLoad, pageLoad)

        //CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, 'User Profile', domLoad, pageLoad)
    }
    catch (Exception ex) {
        throw new Exception('User Profile Exception-___Check Code')
    } 
    
    WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : SubMenu
            , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('Object Repository/Sprint6/select_Library_optionParameterized', [('option') : Brand]), 
        0)

    WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5)

    WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

    WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/span_Select Department'), 0)

    WebUI.delay(5)

    WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

    WebUI.waitForPageLoad(0)

    WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.enhancedClick(findTestObject('Object Repository/Sprint8/span_Select Department'))

    WebUI.waitForPageLoad(0)

    WebUI.delay(5)

    if (Department.length > 1) {
        WebUI.click(findTestObject('Object Repository/Sprint6/li_OpenDeparmentdropdown_param', [('param') : Department[0]]))

        WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Department[1]]))
    } else {
        WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Division]))
    }
    
    WebUI.click(findTestObject('Sprint8/img_Select_Department_dropdown'))

    WebUI.waitForElementClickable(findTestObject('Sprint8/Select_Season_dropdown'), 0)

    WebUI.click(findTestObject('Sprint8/Select_Season_dropdown'))

    WebUI.click(findTestObject('Object Repository/Sprint8/span_parameterized', [('param') : Season]))

    int totalRecords

    for (int innerIteration = 1; innerIteration <= innerIterationCount; innerIteration++) {
        if (innerIteration == 1) {
            WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

            GlobalVariable.startTime = System.currentTimeMillis()
        } else {
            WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

            WebUI.click(findTestObject('Object Repository/Sprint8/a_Go To next Page'))

            GlobalVariable.startTime = System.currentTimeMillis()
        }
        
        try {

            WebUI.verifyElementPresent(findTestObject('Sprint8/span_Total_Records'), 60, FailureHandling.STOP_ON_FAILURE)

            'Check Page Performance'
            long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration, 0)

            long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration)

            CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (((SubMenu + ' > ') + BrandConcat) + ' - Page ') + 
                innerIteration, domLoad, pageLoad)

            //CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (((SubMenu + ' > ') + BrandConcat) + 
               // ' - Page ') + innerIteration, domLoad, pageLoad)
			
			//WebUI.callTestCase(findTestCase('PageLoadPerformance/linkTestCase_ManageList_UpdatePerfTest'), [('pageNo') : innerIteration], FailureHandling.STOP_ON_FAILURE)
        }
        catch (com.kms.katalon.core.exception.StepFailedException ex) {
			throw new Exception("Test Failed")
                   } 
        
        if (innerIteration == 1) {
            totalRecords = Integer.parseInt(WebUI.getText(findTestObject('Sprint8/span_Total_Records')))

            if (totalRecords > 50) {
                System.out.println(totalRecords)

                int RecordsPerPage = 50

                boolean evenNo = (totalRecords % RecordsPerPage) == 0

                System.out.println(evenNo)

                int totalNoOfPagesAvailable = totalRecords / RecordsPerPage

                if (totalNoOfPagesAvailable < 5) {
                    innerIterationCount = totalNoOfPagesAvailable

                    println(innerIterationCount)
                }
            } else {
                break
            }
        }
    }
	
	for (int innerIteration = 1; innerIteration <= innerIterationCount; innerIteration++) {
		if(innerIteration==1)
		{
			WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/button_switchToVLL'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/a_First'), 0)
			WebUI.click(findTestObject('Object Repository/Sprint8/a_First'))
			GlobalVariable.startTime = System.currentTimeMillis()
		}
		else
		{
			WebUI.click(findTestObject('Object Repository/Sprint8/a_Go To next Page'))
			GlobalVariable.startTime = System.currentTimeMillis()
			
		}
		
		WebUI.verifyElementPresent(findTestObject('Sprint8/span_Total_Records'), 60, FailureHandling.STOP_ON_FAILURE)
		
		'Check Page Performance'
		long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'((('VLL > ' + SubMenu) +
			'- Page ') + innerIteration, 0)
	
		long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'((('VLL > ' + SubMenu) +
			'- Page ') + innerIteration)
	
		CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, ((("VLL" + ' > ') + BrandConcat) + ' - Page ') +
			innerIteration, domLoad, pageLoad)
	
		//CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, ((("VLL" + ' > ') + BrandConcat) +
			//' - Page ') + innerIteration, domLoad, pageLoad)
	
	}
	
}



/*List<Object> innerList = new ArrayList<Object>()

innerList.add('Pagination - Average Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList, sheetName + '!E4')

List<Object> innerList2 = new ArrayList<Object>()

innerList2.add('=AVERAGE(C4,C6,C8,C10,C12,C20,C22,C24,C26,C28)')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList2, sheetName + '!E5')

List<Object> innerList3 = new ArrayList<Object>()

innerList3.add('Pagination - Normalized Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList3, sheetName + '!E6')

List<Object> innerList4 = new ArrayList<Object>()

innerList4.add('=E5-3000')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList4, sheetName + '!E7')

List<Object> innerList5 = new ArrayList<Object>()

innerList5.add('Update - Average Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList5, sheetName + '!E9')

List<Object> innerList6 = new ArrayList<Object>()

innerList6.add('=AVERAGE(C5,C7,C9,C11,C13,C21,C23,C25,C27,C29)')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList6, sheetName + '!E10')

List<Object> innerList7 = new ArrayList<Object>()

innerList7.add('Update - Normalized Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList7, sheetName + '!E11')

List<Object> innerList8 = new ArrayList<Object>()

innerList8.add('=E10-3000')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList8, sheetName + '!E12')

List<Object> innerList9 = new ArrayList<Object>()

innerList9.add('VLL - Average Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList9, sheetName + '!E14')

List<Object> innerList10 = new ArrayList<Object>()

innerList10.add('=average(C14:C18,C30:C34)')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList10, sheetName + '!E15')

List<Object> innerList11 = new ArrayList<Object>()

innerList11.add('VLL - Normalized Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList11, sheetName + '!E16')

List<Object> innerList12 = new ArrayList<Object>()

innerList12.add('=E15-3000')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList12, sheetName + '!E17')

*/