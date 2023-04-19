package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {
    //bu sayfayi ilk basta apkInfo/ApkBilgisi yuklemek icin kullandik,sonrada her yukleyecegimiz appi cihazimiza yuklemek icin kullanacagiz
    //sadece app in absolute pathini capabilities.setCapability(MobileCapabilityType.APP, "absolutePath"  yapistir
    AndroidDriver<AndroidElement> driver;//Bu driver ile Android islemciler test edilir,ve AndroidDriver<MobileElement> driver; seklinde de yazilabilir.
    AppiumDriver<MobileElement> appiumDriver;//Bu driver ile iosapple() cihazlar ve android cihazlar da test edilebilir
    final String cihazAdi="PIXEL2";
    final String platformIsmi="Android";
    final String version="10.0";
    final String automation="UiAutomator2";

    @Test
    public void test1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);//gercek telefon baglarsan buraya bagladigin cihaz adini yaz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\sevil\\IdeaProjects\\Appium_T-108\\Apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure.apk");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
