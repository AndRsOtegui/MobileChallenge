package Tests.ScreensImDb;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PreferredServicesScreen extends BaseScreen {
    public PreferredServicesScreen(AndroidDriver<AndroidElement> driver){super(driver);}

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/user_streaming_skip_save_button\")")
    private WebElement skipBtn;

    public SignInScreen skipScreen(){
        skipBtn.click();
        return new SignInScreen(this.driver);
    }

}

