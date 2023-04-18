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

    @Test
    public void arabamTest() {


    }
}
