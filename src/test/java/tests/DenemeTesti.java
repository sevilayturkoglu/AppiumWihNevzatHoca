package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DenemeTesti {
    AndroidDriver<AndroidElement> driver;//Bu driver ile Android islemciler test edilir,ve AndroidDriver<MobileElement> driver; seklinde de yazilabilir.
    //AppiumDriver<MobileElement> appiumDriver;//Bu driver ile ios (apple) cihazlar ve android cihazlar da test edilebilir
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
        // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\sevil\\IdeaProjects\\Appium_T-108\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        // bunu sadece app imizi cihazimiza yuklemek/kurmak icin yaptik sonra kullanmaya gerek yok,bunun yerine App yukleme clasini kullanacagiz
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void carpmaTest() throws InterruptedException {
        driver.activateApp("com.google.android.calculator");//apk infodan app imizi acip bundle mizi aldik,boylece bu testten appimize ulasabiliriz,artik before de ki 31. satira gerek yok
        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        String result = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(result);
        Assert.assertEquals(Integer.parseInt(result), 1600);
        getIslem("clear").click();


        getDigit(3).click();
        getIslem("multiply").click();
        getDigit(5).click();
        getIslem("equals").click();
        Thread.sleep(1000);
        AndroidElement resultFinal = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = resultFinal.getText();
        System.out.println(actualResult);
        assertEquals(actualResult, "15");
        getIslem("clear").click();
        driver.closeApp();
    }
    @Test
    public void toplamaTest() {
        driver.activateApp("com.google.android.calculator");//apk infodan app imizi acip bundle mizi aldik,boylece bu testten appimize ulasabiliriz,artik before de ki 31. satira ihtiyac yok

        getDigit(8).click();
        getIslem("plus").click();
        getDigit(2).click();
        getIslem("equals").click();
        AndroidElement resultFinal = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = resultFinal.getText();
        System.out.println(actualResult);
        assertEquals(actualResult, "10");
        getIslem("clear").click();
        driver.closeApp();
    }
    @Test
    public void cikarmaTest(){
        driver.activateApp("com.google.android.calculator");
        getDigit(7).click();
        getIslem("minus").click();
        getDigit(2).click();
        getIslem("equals").click();
        AndroidElement resultFinal = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult=resultFinal.getText();
        System.out.println(actualResult);
        assertEquals(actualResult, "5");
        getIslem("clear").click();
        driver.closeApp();



    }
    public MobileElement getDigit(int digit){
        return driver.findElementByAccessibilityId(""+digit);
    }

    public MobileElement getIslem(String islem){
        return driver.findElementByAccessibilityId(""+islem);
    }
    }

