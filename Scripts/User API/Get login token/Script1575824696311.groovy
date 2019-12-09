import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable


responseData = WS.sendRequest(findTestObject('api/login/user_login', [('url') : GlobalVariable.url]))
WS.verifyResponseStatusCode(responseData, 200)

def phone_number = 'GlobalVariable.phone_number'
def merchant_id = 'GlobalVariable.merchant_id'
def request_id = 'GlobalVariable.request_id'
def login = CustomKeywords.'com.kfc.api.common.loginByAPI'(phone_number, merchant_id, request_id)
def token = login[0]

WS.verifyNotEqual(token, null)
println token