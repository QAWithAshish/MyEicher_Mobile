package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.LogReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporter.ExtentTestManager;
import sun.rmi.runtime.Log;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class MobileActions {
    public static int mediaCounter;
   private  AppiumDriver driver;
   public int shortTimeout=30;
   public MobileActions(AppiumDriver driver){
        this.driver=driver;
    }


    public boolean iselementVisible(WebElement element) {
        return iselementVisible(element,shortTimeout);
    }

    public boolean iselementVisible(WebElement element, int timeout) {
        try {
            return iselementVisibleforMilli(element,timeout,false);
        } catch (Exception ex) {
            LogReporter.INFO(ex.getMessage());
            return false;
        }

    }

    public boolean iselementVisibleforMilli(WebElement element, int timeout,boolean flag) {
        try {
            if(flag) {
                return waitforElementVisible(element, timeout,flag).isDisplayed();
            }else{
                return waitforElementVisible(element, timeout).isDisplayed();
            }
        } catch (Exception ex) {
           LogReporter.INFO(ex.getMessage());
            return false;
        }

    }



    public boolean iselemenDisappeared(WebElement element, int timeout) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {
            LogReporter.INFO("Progress bar no longer available");
            return false;
        }

    }

    public boolean iselementRefreshed(WebElement element, int timeout) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        } catch (Exception ex) {
            LogReporter.INFO("Element is no longer stale");
            return false;
        }
    }

    public WebElement waitforElementwithLoop(WebElement element,int loop){
       for(int i=0;i<loop;i++){
           if(iselementVisible(element,1)){
               return element;
           }
       }
       return element;
    }
    public WebElement waitforElementVisible(WebElement element, int timeout){
      return waitforElementVisible(element,timeout,false);
    }

    public WebElement waitforElementVisible(WebElement element, int timeout, Boolean flag){
        try {
            if(flag) {
                return new WebDriverWait(driver, Duration.ofMillis(timeout))
                        .until(ExpectedConditions.visibilityOf(element));
            }else{
                return new WebDriverWait(driver,Duration.ofSeconds(timeout))
                        .until(ExpectedConditions.visibilityOf(element));
            }

        } catch (Exception ex) {
         //   LogReporter.INFO(ex.getMessage());
            throw new RuntimeException("Unable to find element");
        }
    }


    public void highlightOnly(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", element);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to highlight" + ex.getMessage());
        }
    }

    public void tapOnElement(WebElement element, int duration){
        Point point =element.getLocation();
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public void tapOnWheel(WebElement element, int duration){
        Point point =element.getLocation();
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX()+point.getX()/2, point.getY()+ point.getY()/2))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public void pullUpBottomSheet(WebElement sourceElement,WebElement targetElement,int duration){
        Point source = sourceElement.getLocation();
        Point target = targetElement.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(),target.x, target.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));

    }

    public void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement waitforElementClickable(WebElement element, int timeout){
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception ex) {
            LogReporter.INFO(ex.getMessage());
            throw new RuntimeException("Unable to click element"+ex.getMessage());
        }



    }



    public WebElement waitForElementByXpath(String xpath){

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }
    public void waitforSecond(int sec){

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public   String getDatePlusHours(int hours){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
        String strDate= formatter.format(calendar.getTime());
        return strDate;
    }

    public int getHours(int hours) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getAMPM() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.AM_PM);
    }


    public int getHours(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMin(int min) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.get(Calendar.MINUTE);
    }


    public  String getBase64SnapShot( ) {
        try {

            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        } catch (Exception ex) {
            LogReporter.Reporter("Unable to capture screenshot at this point");
            throw new RuntimeException("Unable to capture screenshot");
        }
    }

    public  void attachScreenshot( ){
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64SnapShot()).
                getModel().getMedia()
                .get(mediaCounter);
        mediaCounter++;
    }
}
