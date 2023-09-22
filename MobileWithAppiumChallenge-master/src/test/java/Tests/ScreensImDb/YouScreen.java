package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Objects;

public class YouScreen extends BaseScreen{
    public YouScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/main_line\")")
    WebElement elementWatchlistTitle;
    public Boolean getMovieInWtchLst(String movieSelected){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementWatchlistTitle));
        String text = elementWatchlistTitle.getText();
        System.out.println(text);
        return Objects.equals(text, movieSelected);
    }
}
