package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.LogReporter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage extends BasePage{
    public LandingPage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id="in.here.volvo.android:id/layoutFirst")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`visible ==1`]")
    WebElement firstLayout;

    @AndroidFindBy(id="in.here.volvo.android:id/layoutSecond")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`visible ==1`]")
    WebElement secondLayout;








    public LandingPage acceptLayoutHint(){
        Assert.assertTrue(actions.iselementVisible(firstLayout));
        if(driver.getCapabilities().getPlatformName().equals(Platform.IOS.toString())){
            actions.tapOnElement(firstLayout, 2);
        }else {
            firstLayout.click();
        }
        Assert.assertTrue(actions.iselementVisible(secondLayout));
        secondLayout.click();
        LogReporter.Reporter("Accepted both Layout");
        return this;
    }

        public LandingPage navigateToFleetTracking(){
        super.navigateToFleetTracking();
        return this;

        }


}
