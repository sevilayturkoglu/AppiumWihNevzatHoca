package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {
    AndroidDriver<AndroidElement> driver;//Bu driver ile Android islemciler test edilir,ve AndroidDriver<MobileElement> driver; seklinde de yazilabilir.
    AppiumDriver<MobileElement> appiumDriver;//Bu driver ile iosapple() cihazlar ve android cihazlar da test edilebilir
    final String cihazAdi = "PIXEL2";
    final String platformIsmi = "Android";
    final String version = "10.0";
    final String automation = "UiAutomator2";

    @BeforeTest
    public void test1() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, cihazAdi);//gercek telefon baglarsan buraya bagladigin cihaz adini yaz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
        capabilities.setCapability("appPackage", "com.dogan.arabam");//hangi uygulamada calisacagimi bildirdim ,apkinfo uzerinden bundle aldik
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");//Activities uzerinden acip urada uygulamada hangi sayfayi gormek veya baslatmak istedigimizi yazariz,ya main activity veya homePage actyviti den alip kopyalariz,sondaki - yi sildik
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "");//Bunu yazarak uygulama icin girdigimiz sifre mail gibi veriler store edilir ,her giriste yeniden istenmez,false yazarsak kayit olmaz,true yazarsak sifreleri saklar sifirlamaz,genelde false kullanilir
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    // Arabam kac para bolumune tiklayalim
// Aracimin fiyatini merak ediyorum bolumunetiklayalim
// Wolkswagen markasini secelim
// yil secimi yapalim
// model secimi yapalim
// govde tipini secelim
// yakit tipini secelim
// vites tipini secelim
// Versiyon secimi yapalim
// aracin km bilgilerini girelim
// aracin rengini secelim
// opsiyel donanim (varsa) seecelim
// degisen bilgisi ekleyerek tramer kaydi belirtelim
// aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
// uygulamayi kapatalim

    @Test
    public void arabamTest() throws InterruptedException {

        // Arabam kac para bolumune tiklayalim
     driver.findElementByXPath("//*[@text='Arabam kaç para?']").click();

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        AndroidElement fiyatMerak=driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        fiyatMerak.click();

        // Wolkswagen markasini secelim  burada ekran kaydirma islemi yapacagiz
Thread.sleep(2000);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(530,2250)).//ekrandaki alt koordinatlari belirledik
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
                moveTo(PointOption.point(530,0)).release().perform();//Ekrandaki ust kaydirma noktasi  koordinatlari belirledik release parmagini kaldir dedik
      /*  Eger ki bizler daha onceden kaydirma islemi gerceklestirmissek tam tersi haraketini gerceklestirmek icin yazdigimiz
        koordinat degerlerini tam tersi olacak sekilde yazmak o islemin zittini gerceklestirir.*/
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();
     /*
         action.press(PointOption.point(537,381)).
                 waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                 moveTo(PointOption.point(543,1732)).release().perform();

      */
// yil secimi yapalim
        driver.findElement(By.xpath("//*[@text='2011']")).click();
// model secimi yapalim
        driver.findElement(By.xpath("//*[@text='Passat']")).click();
// govde tipini secelim
        driver.findElement(By.xpath("//*[@text='Sedan']")).click();
// yakit tipini secelim
        driver.findElement(By.xpath("//*[@text='Benzin']")).click();
// vites tipini secelim
        driver.findElement(By.xpath("//*[@text='Yarı Otomatik']")).click();
// Versiyon secimi yapalim
        Thread.sleep(1000);
        action.press(PointOption.point(490,1747)).release().perform(); //burada kendi koordinatini bul yaz
// aracin km bilgilerini girelim
        //driver.getKeyboard().pressKey("190000");boyle yapilabilir
        if(driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("190000");
        }else{
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("190000");
        }
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();
        // aracin rengini secelim
        driver.findElementByXPath("//*[@text='Gri (metalik)']").click();
        // opsiyel donanim (varsa) seecelim
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        AndroidElement kaput=driver.findElementById("com.dogan.arabam:id/iv_B01001");
        kaput.click();
        Thread.sleep(1000);
        driver.findElementByXPath("(//*[@text='Boyalı'])[2]").click();
        Thread.sleep(1000);
        driver.findElementById("com.dogan.arabam:id/btn_next").click();
        // tramer kaydi yok kismina tiklayalim
        driver.findElementById("com.dogan.arabam:id/rbHasNoTramerEntry").click();
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        String avaragePrice= driver.findElementById("com.dogan.arabam:id/tvAveragePrice").getText();
        //588.500 TL
        String lastPrice=avaragePrice.replaceAll("\\D","");
        Assert.assertTrue(Integer.parseInt(lastPrice)>500000);

        // uygulamayi kapatalim
        driver.closeApp();
    }
    }

