package utils;

import io.appium.java_client.AppiumDriver;
import logger.LogReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import reporter.ExtentTestManager;

public class ScreenShotUtils {
    public static AppiumDriver driver;
    public  static  int mediaCounter=0;

    public  static String getBase64SnapShot( ) {
        try {

            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            return scrShot.getScreenshotAs(OutputType.BASE64);

        } catch (Exception ex) {
            LogReporter.INFO("Unable to capture screenshot at this point");
           return  "No screenshot";
        }
    }

    public  static void attachScreenshot( ){
        String screenshot =getBase64SnapShot();
        ++mediaCounter;
        try {
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot).
                    getModel().getMedia()
                    .get(mediaCounter);
        }catch (Exception ex){
            LogReporter.INFO(ex.getMessage());
        }

    }
}
