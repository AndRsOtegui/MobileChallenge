package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class MovieScreen extends BaseScreen{
    public MovieScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/plot_overview\")")
    private WebElement descriptionText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/watchlist_button\")")
    private WebElement addToWatchListBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\")")
    private WebElement getMovieTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/notification_not_now\")")
    private WebElement notNowNotificationBtn;

    @AndroidFindBy(uiAutomator = "new UiScrollable(scrollable(true)).scrollIntoView(resourceId(\"com.imdb.mobile:id/add_a_review\"))")
    private WebElement addReviewScroll;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/empty_rating_star\")")
    private WebElement starBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\").textContains(\"Rating saved\")")
    private WebElement rateSavedMessage;

    public String getOverviewText(){
        return descriptionText.getText();
    }

    public String addToWatchlist(){
        String movieSelected = getMovieTitle.getText();
        addToWatchListBtn.click();
        waiter(notNowNotificationBtn);
        notNowNotificationBtn.click();
        return movieSelected;
    }

    @Override
    public YouScreen goToProfile() {
        return super.goToProfile();
    }

    public RaterScreen rateMovie(){
       addReviewScroll.isDisplayed();
       starBtn.click();
       return new RaterScreen(this.driver);
    }

    public ReviewScreen reviewButton(){
        addReviewScroll.click();

        return  new ReviewScreen(this.driver);
    }

    public boolean verifyRater(){
      return rateSavedMessage.isDisplayed();
    }
}

