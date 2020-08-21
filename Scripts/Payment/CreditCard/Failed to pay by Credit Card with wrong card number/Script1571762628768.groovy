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
import testlink.api.java.client.TestLinkAPIResults as TestLinkAPIResults

'Create checkout order (Call Test Case)'
Mobile.callTestCase(findTestCase('Test Cases/CheckoutOrder/Sucess create checkout order'), [:], FailureHandling.STOP_ON_FAILURE)

'Scroll to find Credit Card Midtrans in List Payment page'
Mobile.scrollToText('Credit Card Midtrans')

'Choose Credit Card Midtrans in payment page'
Mobile.tap(findTestObject('Object Repository/Payment Page/btn_creditcard_mid_paymentpage'), 30)

'Tap bayar in Payment Method page'
Mobile.tap(findTestObject('Object Repository/Payment Method Page/btn_isi_detail_kartu_paymentmethodpage'), 30)

'Fill the credit card number'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_card_number_creditcardpage'), '4811111111111119', 
    10)

'Fill the credit card expiration'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_masa_berlaku_creditcardpage'), card_expiration, 
    10)

'Fill the credit card cvv'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_cvv_creditcardpage'), card_cvv, 10)

'Tap bayar in Credit Card page'
Mobile.tap(findTestObject('Object Repository/Credit Card Midtrans Page/btn_bayar_creditcardpage'), 30)


def expectedErrorCardNumber = 'Nomor kartu tidak valid'

'Get Error message in Card number field'
def actualErrorCardNumber = Mobile.getText(findTestObject('Object Repository/Credit Card Midtrans Page/tv_error_card_number_creditcardpage'), 30)

'Verify error message on card number field'
Mobile.verifyEqual(actualErrorCardNumber, expectedErrorCardNumber)

'Close application'
Mobile.closeApplication()

