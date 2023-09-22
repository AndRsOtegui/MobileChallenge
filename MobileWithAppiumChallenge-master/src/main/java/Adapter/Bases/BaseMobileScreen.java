package Adapter.Bases;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BaseMobileScreen {
    protected AndroidDriver<AndroidElement> driver;
    public BaseMobileScreen(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Search']/android.widget.FrameLayout")
    private WebElement searchBtn;

    public void goSearch(){searchBtn.click();

    }



}


