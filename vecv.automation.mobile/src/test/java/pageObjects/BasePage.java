package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.LogReporter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.MobileActions;
import utils.ScreenShotUtils;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {





    protected AppiumDriver driver;

    public MobileActions actions;



    @AndroidFindBy(className = "android.widget.ProgressBar")
    WebElement progressBar;

    @iOSXCUITFindBy(accessibility = "Done")
    WebElement doneButton;

    @AndroidFindBy(id="in.here.volvo.android:id/tvFleetTracking")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[4]")
    WebElement fleetTrackingMenuOption;

    @AndroidFindBy(id="in.here.volvo.android:id/tvHome")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[1]")
    WebElement homeMenu;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"in.here.volvo.android:id/tvUserName\").text(\"MY EICHER\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"MY EICHER\"`]")
    WebElement homeMenuTitle;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"in.here.volvo.android:id/tvHeader\").text(\"FLEET TRACKING\")")
     WebElement fleetMenuTitle;

    public BasePage(AppiumDriver driver) {
        this.driver=driver;
        actions =new MobileActions(driver);
        init_factory();

    }

    public BasePage navigateToFleetTracking(){
        Assert.assertTrue(actions.iselementVisible(homeMenuTitle));
        fleetTrackingMenuOption.click();
        LogReporter.Reporter("clicked on fleetTracking menu");
        waitForAndroidProgresBar(1);
        if(driver.getCapabilities().getPlatformName().toString().contains(Platform.ANDROID.toString())){
           if(actions.iselementVisibleforMilli(fleetMenuTitle,100,true)){
               LogReporter.Reporter("Navigated to Fleet Tracking");
          }else{
               fleetTrackingMenuOption.click();
               LogReporter.Reporter("Again clicked on fleetTracking menu as previous click not work");
               Assert.assertTrue(actions.iselementVisibleforMilli(fleetMenuTitle,300,true));
           }
       }

        ScreenShotUtils.attachScreenshot();
        return this;
    }



    public void sendKeys(WebElement element ,String text) {
        element.sendKeys(text);
        if (driver.getCapabilities().getPlatformName().toString().contains(Platform.IOS.toString())) {
            Assert.assertTrue(actions.iselementVisible(doneButton));
            doneButton.click();
        }else{
            ((AndroidDriver)driver).hideKeyboard();
        }
    }

    public void waitForAndroidProgresBar(int sec){
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())){
            actions.iselemenDisappeared(progressBar,sec);
        }
    }
    public void sendKeysForAutoSuggestion(WebElement element ,String text) {

        if (driver.getCapabilities().getPlatformName().toString().contains(Platform.IOS.toString())) {
            element.sendKeys(text);
            Assert.assertTrue(actions.iselementVisible(doneButton));
            doneButton.click();
        }else{
            char[] chars =text.toCharArray();
            for (int i=0;i<chars.length;i++) {
                try {
                    AndroidKey key;
                    if(chars[i]==' '){
                        key=AndroidKey.SPACE;
                    }else {
                        key = AndroidKey.valueOf(String.valueOf(chars[i]));
                    }
                    ((AndroidDriver) driver).pressKey(new KeyEvent(key));
                }catch (Exception ex){
                    LogReporter.INFO("Exception while pressing key");
                }
                actions.waitforSecond(1);

                }
            ((AndroidDriver)driver).hideKeyboard();
        }
    }




    public void sendKeyselementClick(WebElement element ,String text) {
        element.click();
        sendKeysForAutoSuggestion(element,text);

    }

    public void init_factory(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
