package Tests.ScreensImDb;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/welcome_dialog_continue\")")
    private WebElement continueBtn;



    public WelcomeScreen(AndroidDriver<AndroidElement> driver){
        super(driver);

    }

    public PreferredServicesScreen clickContinue2() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));

        if (element != null) {
            element.click();
        } else {
            System.out.println("Element not found or clickable.");
        }

       return new PreferredServicesScreen(this.driver);
    }

    public SignInScreen clickContinue() {
        waiter(continueBtn);
        continueBtn.click();

        return new SignInScreen(this.driver);
    }
    public AndroidDriver<AndroidElement> clickContinueTest(){
        waiter(continueBtn);
        continueBtn.click();
        return this.driver;
    }
}
