package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    protected AndroidDriver<AndroidElement> driver;
    public BaseScreen(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Search")
    private WebElement searchBtn;

    @AndroidFindBy(accessibility = "You")
    private WebElement youNavBarBtn;


    public void waiter(WebElement elementToLoad){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementToLoad));
    }
    public SearchScreen goSearch(){
        waiter(searchBtn);
        searchBtn.click();
        return new SearchScreen(this.driver);
    }

    public YouScreen goToProfile(){
        youNavBarBtn.click();
        return new YouScreen(this.driver);
    }
}
