package Adapter.Bases;


import Core.ConfigCapabilities;
import Core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class BaseMobileTest {

    protected AndroidDriver<AndroidElement> driver;
     protected boolean logginNeed = false;

    @BeforeSuite(alwaysRun = true)
    public void SetUp(){
        ConfigCapabilities configCapabilities = new ConfigCapabilities();
        DesiredCapabilities capabilities = configCapabilities.GetCapabilities();
        MobileAppDriver mobileAppDriver = new MobileAppDriver();
        driver = mobileAppDriver.GetMoviesAppDriver(capabilities);



    }

    @AfterSuite(alwaysRun = true)
    public void TearDown()
    {
       driver.quit();
    }
}



