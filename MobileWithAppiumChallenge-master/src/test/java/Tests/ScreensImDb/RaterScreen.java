package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RaterScreen extends BaseScreen{

   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/rate_title_button\")")
   private WebElement rateBtn;

    public RaterScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }
    private String movieRating;

    public MovieScreen rateMovie(int rateValue){
        String starRateBtn = "com.imdb.mobile:id/star_"+rateValue;
        driver.findElement(By.id(starRateBtn)).click();
        rateBtn.click();
        return new MovieScreen(this.driver);
    }

}
