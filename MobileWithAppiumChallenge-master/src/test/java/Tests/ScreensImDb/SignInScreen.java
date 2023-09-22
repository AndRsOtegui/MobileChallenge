package Tests.ScreensImDb;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class SignInScreen extends BaseScreen {

    public SignInScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/imdb_auth_portal\")")
    private WebElement signInImdbBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/splash_not_now\")")
    private WebElement skipLoginBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/user_streaming_skip_save_button\")")
    private WebElement skipBtn;

    public HomeScreen skipLogin(){

        skipLoginBtn.click();

        return new HomeScreen(this.driver);
    }

    public LoginScreen goToLogin(){

        signInImdbBtn.click();

        return new LoginScreen(this.driver);
    }

    public WebElement getSkipLoginBtn(){
        return skipLoginBtn;
    }

}
