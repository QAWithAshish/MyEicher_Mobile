package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.LogReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ScreenShotUtils;

public class SelectCustomerPage extends BasePage{

    public SelectCustomerPage(AppiumDriver driver){
        super(driver);
    }


    @iOSXCUITFindBy(accessibility = "SELECT CUSTOMER")
    @AndroidFindBy(id="in.here.volvo.android:id/tvHeader")
    WebElement selectCustomerTitle;

    @iOSXCUITFindBy(className="XCUIElementTypeTextField")
    @AndroidFindBy(id="in.here.volvo.android:id/etCustomerName")
    WebElement customerInput;

    @iOSXCUITFindBy(className="XCUIElementTypeCell")
    @AndroidFindBy(id="in.here.volvo.android:id/tvTitle")
    WebElement customerFirstSuggestion;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"Submit\"`]")
    @AndroidFindBy(id="in.here.volvo.android:id/btnSubmit")
    WebElement submitButton;

    public SelectCustomerPage submitCustomerDetails() {
        Assert.assertTrue(actions.iselementVisible(selectCustomerTitle));
        Assert.assertEquals(selectCustomerTitle.getText(),"SELECT CUSTOMER");
        actions.waitforElementClickable(customerInput,actions.shortTimeout).click();
        customerInput.clear();
        sendKeysForAutoSuggestion(customerInput,"B M ROADLINES");
        customerFirstSuggestion.click();
        Assert.assertTrue(actions.iselementVisible(submitButton));
        ScreenShotUtils.attachScreenshot();
        submitButton.click();
        LogReporter.Reporter("Submitted Customer Details");
        return this;
    }


}
