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

'Create checkout order (Call Test Case)'
Mobile.callTestCase(findTestCase('Test Cases/CheckoutOrder/Sucess create checkout order'), [:], FailureHandling.STOP_ON_FAILURE)

'Scroll to find Credit Card Midtrans in List Payment page'
Mobile.scrollToText('Credit Card Midtrans')

'Choose Credit Card Midtrans in payment page'
Mobile.tap(findTestObject('Object Repository/Payment Page/btn_creditcard_mid_paymentpage'), 30)

'Tap bayar in Payment Method page'
Mobile.tap(findTestObject('Object Repository/Payment Method Page/btn_isi_detail_kartu_paymentmethodpage'), 30)

'Fill the credit card number'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_card_number_creditcardpage'), card_number, 
    10)

'Fill the credit card expiration'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_masa_berlaku_creditcardpage'), card_expiration, 
    10)

'Fill the credit card cvv'
Mobile.setText(findTestObject('Object Repository/Credit Card Midtrans Page/form_cvv_creditcardpage'), card_cvv, 10)

'Tap bayar in Credit Card page'
Mobile.tap(findTestObject('Object Repository/Credit Card Midtrans Page/btn_bayar_creditcardpage'), 30)

'Fill password/otp in Credit Card webview'
Mobile.setText(findTestObject('Object Repository/Web View CC Page/form_otp_cc_webview'), '112233', 30)

'Tap OK in Credit Card webview'
Mobile.tap(findTestObject('Object Repository/Web View CC Page/btn_ok_cc_webview'), 30)

'Tap Lihat pesanan in Payment success page'
Mobile.tap(findTestObject('Object Repository/Payment Success Page/btn_lihat_pesanan_paymentsuccesspage'), 30)

def expectedPaymentStatus = 'Paid'

'Get Payment Status in Order detail page'
def actualPaymentStatus = Mobile.getText(findTestObject('Object Repository/Order Detail Page/tv_statuspayment_orderdetailpage'), 
    30)

'Verify if status payment is Paid in Order detail page'
Mobile.verifyEqual(actualPaymentStatus, expectedPaymentStatus)

