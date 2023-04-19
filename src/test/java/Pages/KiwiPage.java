package Pages;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import java.time.Duration;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath ="//*[@text='One way']" )
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement kalkisButonu;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSILME;

    @FindBy(xpath = "//*[@text='LHR, Heathrow']")
    public WebElement London;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "//*[@text='Anywhere']")
    public WebElement toAnywhere;

    @FindBy(xpath = "//*[@text='IST, Istanbul Airport']")
    public WebElement istanbul;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement gidisTarihi;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement Setdate;

    @FindBy(xpath = "//*[@text='Search']")
    public WebElement Search;
    @FindBy(xpath = "//*[@text='Search']")
    public WebElement Search1;


    TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
    public  void ucButtonTiklama(int baslangic,int bitis,int xCoordinat,int yCoordinat,int wait){

        for (int i=baslangic; i<bitis; i++){
            action.press(PointOption.point(xCoordinat,yCoordinat)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release().
                    perform();
        }
    }
public void scrollDown(int xCoordinate,int yCoordinate,int sonYCoordinate){
    action.press(PointOption.point(xCoordinate,yCoordinate))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
            .moveTo(PointOption.point(xCoordinate,sonYCoordinate)).release().perform();
}


}
