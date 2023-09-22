package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReviewScreen extends BaseScreen{
    public ReviewScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\")")
    private WebElement rateSavedMessage;

    @AndroidFindBy(accessibility = "close_webview&site=android&ref_=andp_tt_urv_ar#")
    private List<WebElement> rateStars;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private List<WebElement> inputsReview;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").textContains(\"No\")")
    private WebElement noSpoilersBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Submit\")")
    private WebElement submitReviewBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Submission successful\")")
    private WebElement messageSubmissionOk;


    public boolean addReview(int rateValue,String headline,String review){
        WebElement ratingToAdd = rateStars.get(rateValue);
        ratingToAdd.click();
        WebElement headlineInput = inputsReview.get(0);
        headlineInput.click();
        headlineInput.sendKeys(headline);
        WebElement reviewInput = inputsReview.get(1);
        reviewInput.click();
        reviewInput.sendKeys(review);
        noSpoilersBtn.click();
        submitReviewBtn.click();
        return messageSubmissionOk.isDisplayed();

    }
}
