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

'Open Tanihub App'
Mobile.startApplication('/Users/eddypastika/Documents/TaniHub-staging.apk', false)

'Choose category in Home Page'
Mobile.tap(findTestObject('Object Repository/Homepage/btn_category_sepoket_homepage'), 30)

'Choose product in Category Page'
Mobile.tap(findTestObject('Object Repository/Category Page/btn_produk_categorypage'), 30)

'Tap Beli in Product Page'
Mobile.tap(findTestObject('Object Repository/Product Page/btn_beli_productpage'), 30)

'Tap Tambah ke Keranjang in Product Detail page'
Mobile.tap(findTestObject('Object Repository/Product Detail Page/btn_tambah_keranjang_productdetailpage'), 30)

'Tap Lihat Keranjang in Cart View page'
Mobile.tap(findTestObject('Object Repository/Cart Preview Page/btn_lihat_keranjang_cartpreviewpage'), 30)

'Tap checkout in Cart page'
Mobile.tap(findTestObject('Object Repository/Cart Page/btn_checkout_cartpage'), 30)

'Tap Pilih Alamat in Checkout page'
Mobile.tap(findTestObject('Object Repository/Checkout Page/btn_piliha_alamat_checkoutpage'), 30)

'Choose an address in Address page'
Mobile.tap(findTestObject('Object Repository/Address Page/btn_select_address_addresspage'), 30)

'Tap bayar in Checkout page'
Mobile.tap(findTestObject('Object Repository/Checkout Page/btn_bayar_checkout'), 30)

def expectedPaymentTitle = 'Pembayaran'

'Get Payment Title'
def actualPaymentTitle = Mobile.getText(findTestObject('Object Repository/Payment Page/tv_pembayaran_page_paymentpage'),30)

'Verify if payment title is Pembayaran'
Mobile.verifyEqual(actualPaymentTitle, expectedPaymentTitle)