package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.DriverWeb;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyTest {
   AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    // all currency uygulamasinin yuklendigi dogulanir
// uygulamanin acildigi dogrulanir
// cevirmek istedigimiz para birimi zloty olarak secilir
// cevirelecek olan para birimi Tl olarak secilir
// cevrilen tutar screenShot olarak kaydedilir
// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
// bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
    @Test
    public void currency() throws IOException, InterruptedException {
        // all currency uygulamasinin yuklendigi dogulanir
       Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        AndroidElement anaSayfaApp = driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']");
        String uygulamaDogrulamaActual = anaSayfaApp.getText();
        String expected="CURRENCY CONVERTER";
        Assert.assertEquals(uygulamaDogrulamaActual,expected);

        // cevirmek istedigimiz para birimi zloty olarak secilir
        AndroidElement ilkKategory=driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyA");
        ilkKategory.click();
       // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PLN\"))");//methoddan once bunu yaptik
        ReusableMethods.scrollWithUiScrollable("PLN");

//cevrilecek tutari yazalim  1500 yazacagiz
        AndroidElement kategory2=driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB"));
        kategory2.click();
        ReusableMethods.scrollWithUiScrollable("Turkish Lira");
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b1")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b5")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();



        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir

        AndroidElement cevrilenBirim = driver.findElementById(("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB"));
        String sonucParaDegeri= cevrilenBirim.getText();

        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
        ilkKategory.click();
        ReusableMethods.scrollWithUiScrollable("USD");
        sonucParaDegeri= cevrilenBirim.getText();
        //driver.sendSMS("5555555555",sonucParaDegeri);
        Thread.sleep(500);
        ilkKategory.click();
        ReusableMethods.scrollWithUiScrollable("SEK");
        sonucParaDegeri= cevrilenBirim.getText();
        System.out.println(sonucParaDegeri);

        Thread.sleep(500);
        ilkKategory.click();
        ReusableMethods.scrollWithUiScrollable("JPY");
        sonucParaDegeri= cevrilenBirim.getText();
        System.out.println(sonucParaDegeri);

        Thread.sleep(500);
        ilkKategory.click();
        ReusableMethods.scrollWithUiScrollable("GBP");
        sonucParaDegeri= cevrilenBirim.getText();
        System.out.println(sonucParaDegeri);
        driver.sendSMS("5555555555",sonucParaDegeri);

        // cevrilen tutar screenShot olarak kaydedilir
//burada  screenshot aldi
        File ekranfotografi = driver.getScreenshotAs(OutputType.FILE);//screen shot aldik ama fotonun yeri belli degil
        FileUtils.copyFile(ekranfotografi,new File("paraSonucu.jpg"));//screen shotu sectigim isimle kaydettik  ,run edince solda cikacak
//burada da screen shot aldik ama methodla
        ReusableMethods.getScreenshot("t108");
        //proje dosya yolu
/*String target=System.getProperty("user.dir");
        System.out.println(target);*/

    }
}
