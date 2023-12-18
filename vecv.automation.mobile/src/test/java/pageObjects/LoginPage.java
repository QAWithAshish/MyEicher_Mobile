package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import logger.LogReporter;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ScreenShotUtils;



public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver){
        super(driver);
    }


    @iOSXCUITFindBy(accessibility = "Program requires GPS to track cars and job orders")
    WebElement gpsPermissionAlert;

    @iOSXCUITFindBy(accessibility = "Notifications may include alerts, sounds and icon badges. These can be configured in Settings.")
    WebElement pushNotificationAlert;

    @iOSXCUITFindBy(accessibility = "App would like to access IDFA to get the user detail when app crashes.")
    WebElement accessIDFA;

    @iOSXCUITFindBy(accessibility = "Ask App Not to Track")
    WebElement notToTrack;


    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    WebElement allowGPS;

    @iOSXCUITFindBy(accessibility = "Allow")
    WebElement allowButton;


    @iOSXCUITFindBy(accessibility="Fleet Management")
    @AndroidFindBy(id="in.here.volvo.android:id/tvMain")
    WebElement fleetManagement;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Skip\"`]")
    @AndroidFindBy(id="in.here.volvo.android:id/tvSkip")
    WebElement skipOption;


    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \" \"`][3]")
    @AndroidFindBy(id="in.here.volvo.android:id/rb_vecv")
    WebElement vecvRadioButton;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`value == \"Enter User ID\"`]")
    @AndroidFindBy(id="in.here.volvo.android:id/etUserId")
    WebElement userID;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeSecureTextField[`value == \"Enter your password\"`]")
    @AndroidFindBy(id="in.here.volvo.android:id/ed_password")
    WebElement password;

    @iOSXCUITFindAll(value = {
            @iOSXCUITBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"PROCEED\"`]"),
            @iOSXCUITBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Get Started\"`]")
    })
    @AndroidFindBy(id="in.here.volvo.android:id/btnLogin")
    WebElement login_welcomeButton;


    @iOSXCUITFindBy(accessibility="Sandeep Handa")
    @AndroidFindBy(id="in.here.volvo.android:id/tvpersonName")
    WebElement userWelcome;



    public LoginPage skipToLogin(){
        if(driver.getCapabilities().getPlatformName().toString().contains(Platform.IOS.toString())){
           Assert.assertTrue( actions.iselementVisible(gpsPermissionAlert,actions.shortTimeout));
                   allowGPS.click();
            Assert.assertTrue( actions.iselementVisible(pushNotificationAlert,actions.shortTimeout));
            allowButton.click();
        }
        Assert.assertTrue(actions.iselementVisible(fleetManagement));
        Assert.assertEquals(fleetManagement.getText(),"Fleet Management");
        LogReporter.Reporter("Fleet Management screen displayed");
        Assert.assertTrue(skipOption.isDisplayed());
        skipOption.click();
        if(driver.getCapabilities().getPlatformName().toString().contains(Platform.IOS.toString())) {
        Assert.assertTrue(actions.iselementVisible(accessIDFA,actions.shortTimeout));
        notToTrack.click();

        }
        ScreenShotUtils.attachScreenshot();
            LogReporter.Reporter("skipOption clicked");
        return this;
    }

    public LoginPage performLogin(){
        Assert.assertTrue(actions.iselementVisible(vecvRadioButton));
        vecvRadioButton.click();
        LogReporter.Reporter("Selected VECV Login");
        Assert.assertTrue(actions.iselementVisible(userID));
       sendKeys(userID,"myeicherid4");
        LogReporter.Reporter("Entered Username");
        Assert.assertTrue(actions.iselementVisible(password));
       sendKeys(password,"Eicher123456789");
        LogReporter.Reporter("Entered Password");
        login_welcomeButton.click();
        LogReporter.Reporter("Clicked on LoginButton");
        ScreenShotUtils.attachScreenshot();
        return this;
    }
    public LoginPage gettingStarted(){
        Assert.assertTrue(actions.iselementVisible(userWelcome));
        LogReporter.Reporter("Logged in with "+userWelcome.getText());
        login_welcomeButton.click();
        ScreenShotUtils.attachScreenshot();
        return this;

    }
}


