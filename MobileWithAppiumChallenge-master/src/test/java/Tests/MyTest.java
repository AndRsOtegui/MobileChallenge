package Tests;

import Adapter.Bases.BaseMobileTest;
import Tests.ScreensImDb.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;


public class MyTest extends BaseMobileTest{

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/splash_not_now\")")
    private WebElement skipLoginBtn;


    @Test
    public void searchMovie(){
        String searchText = "My Hero Academia";
        int positionResult =0;
        String overviewText = "A superhero-admiring boy without any powers enrolls in a prestigious hero academy and learns what it really means to be a hero.";

        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        HomeScreen homeScreen = loadingScreensSkip(driver,welcomeScreen);
        SearchScreen searchScreen = homeScreen.goSearch();
        MovieScreen movieScreen = searchScreen.searchMovie(searchText,positionResult);
        Assert.assertEquals(overviewText,movieScreen.getOverviewText());
    }

   @Test
   public void addToWatchlist(){
       String searchText = "Batman";
       Random random = new Random();
       int randomResultPosition = random.nextInt(5);
       UserCredentials userCredentials = new UserCredentials();
       userCredentials.setCredentials();

       WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
       LoginScreen loginScreen = loadingScreensLogin(driver,welcomeScreen);
       HomeScreen homeScreen = loginScreen.signUp(userCredentials.getUserName(),userCredentials.getPassWord());
       SearchScreen searchScreen = homeScreen.goSearch();
       MovieScreen movieScreen = searchScreen.searchMovie(searchText,randomResultPosition);
       String movieSelected = movieScreen.addToWatchlist();
       YouScreen youScreen = movieScreen.goToProfile();
       Assert.assertTrue(youScreen.getMovieInWtchLst(movieSelected));
   }

   @Test
   public void rateMovie(){
       String searchText = "Hulk";
       int positionResult =0;
       int rateValue= 10;
       UserCredentials userCredentials = new UserCredentials();
       userCredentials.setCredentials();

       WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
       LoginScreen loginScreen = loadingScreensLogin(driver,welcomeScreen);
       HomeScreen homeScreen = loginScreen.signUp(userCredentials.getUserName(),userCredentials.getPassWord());
       SearchScreen searchScreen = homeScreen.goSearch();
       MovieScreen movieScreen = searchScreen.searchMovie(searchText,positionResult);
       RaterScreen raterScreen = movieScreen.rateMovie();
       movieScreen = raterScreen.rateMovie(rateValue);
       Assert.assertTrue(movieScreen.verifyRater());
   }

   @Test
   public void reviewMovie(){
       String searchText = "Hulk";
       int positionResult =0;
       int rateValue= 5;
       UserCredentials userCredentials = new UserCredentials();
       userCredentials.setCredentials();
       Review review = new Review();
       review.setReview();


       WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
       LoginScreen loginScreen = loadingScreensLogin(driver,welcomeScreen);
       HomeScreen homeScreen = loginScreen.signUp(userCredentials.getUserName(),userCredentials.getPassWord());
       SearchScreen searchScreen = homeScreen.goSearch();
       MovieScreen movieScreen = searchScreen.searchMovie(searchText,positionResult);
       ReviewScreen reviewScreen =  movieScreen.reviewButton();
       Assert.assertTrue(reviewScreen.addReview(rateValue, review.getHeadLine(),review.getReviewText()));
   }


   public HomeScreen loadingScreensSkip(AndroidDriver<AndroidElement> driver, WelcomeScreen welcomeScreen){
       driver = welcomeScreen.clickContinueTest();
       if(skipLoginBtn == null){
           PreferredServicesScreen preferredServicesScreen = new PreferredServicesScreen(driver);
           SignInScreen signInScreen0 = preferredServicesScreen.skipScreen();
           return signInScreen0.skipLogin();
       }else{
           SignInScreen signInScreen = new SignInScreen(driver);
           return signInScreen.skipLogin();
       }
   }

    public LoginScreen loadingScreensLogin(AndroidDriver<AndroidElement> driver, WelcomeScreen welcomeScreen){
        driver = welcomeScreen.clickContinueTest();
        if(skipLoginBtn == null){
            PreferredServicesScreen preferredServicesScreen = new PreferredServicesScreen(driver);
            SignInScreen signInScreen0 = preferredServicesScreen.skipScreen();
            return signInScreen0.goToLogin();
        }else{
            SignInScreen signInScreen = new SignInScreen(driver);
            return signInScreen.goToLogin();
        }
    }





}


