package Tests.ScreensImDb;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen extends BaseScreen {

    public HomeScreen(AndroidDriver<AndroidElement> driver){
        super(driver);
    }

    @Override
    public SearchScreen goSearch() {

        super.goSearch();

        return new SearchScreen(this.driver);
    }

}
