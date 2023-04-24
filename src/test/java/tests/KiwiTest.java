package tests;

import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

public class KiwiTest {

    // uygulamanin yuklendigi dogrulanir
// uygulamanin basariyla acildigi dogrulanir
// misafir olarak devam et e tiklanir
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage page = new KiwiPage();

    @Test
    public void kiwiTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        // Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"), "uygulama yuklenemedi");
        // uygulamanin basariyla acildigi dogrulanir
        String actualElementText = page.asAGuest.getText();
        String expectedElementText = "Continue as a guest";
        Assert.assertEquals(actualElementText, expectedElementText);
        // misafir olarak devam et e tiklanir
        page.asAGuest.click();
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        page.ucButtonTiklama(0, 4, 500, 2030, 1500);
// Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.kalkisButonu.click();
        page.defaultUlkeSILME.click();
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("London");
        page.London.click();
        page.chooseClick();
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        page.toAnywhere().click();//WebElement donuslu method yapip burada cagirip tikladim
        driver.getKeyboard().pressKey("Istanbul");
        page.istanbul.click();
        page.chooseClick();//click methodunu page sayfasinda yapip orada click yaptik buraya sadece methodu cagirdik.boylece datayi private yapabildik

// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        page.gidisTarihi.click();
        Thread.sleep(2000);
        page.scrollDown(580, 1660, 319);
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.tap(PointOption.point(116, 1410)).perform();
        page.Setdate.click();
 // search butonuna tiklanir
        page.Search.click();
 // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.Best.click();
        page.Cheapest.click();
        page.Stops.click();
        page.Nonstop.click();
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        Thread.sleep(1000);
        String price = page.ticketPrice.getText();
        //System.out.println(biletFiyatText);
        driver.sendSMS("7878212998", price);
    }
}