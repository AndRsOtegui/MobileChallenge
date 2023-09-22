package Tests.ScreensImDb;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/search_src_text\")")
    private WebElement inputSearch;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\")")
    private List <WebElement> resultSearchBar;

    private int expectedLength = 5;

    public MovieScreen searchMovie(String search, int positionResult){
        inputSearch.click();
        inputSearch.sendKeys(search);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement result = resultSearchBar.get(positionResult);
        result.click();
        return new MovieScreen(this.driver);
    }


}
