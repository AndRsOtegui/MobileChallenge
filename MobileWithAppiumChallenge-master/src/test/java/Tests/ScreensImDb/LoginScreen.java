package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_email\")")
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_password\")")
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"signInSubmit\")")
    private WebElement signInBtn;

    public HomeScreen signUp(String username,String password){
        waiter(emailInput);
        emailInput.click();
        emailInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        signInBtn.click();
        return new HomeScreen(this.driver);
    }

}
