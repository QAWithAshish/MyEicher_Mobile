package infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import logger.LogReporter;
import org.openqa.selenium.Platform;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    protected static final int PORT = 4724;

    protected static final String HOST = "127.0.0.1";
    protected static AppiumDriver driver=null;
    private static ThreadLocal<AppiumDriver> localDriver = new ThreadLocal<AppiumDriver>();
    private static AppiumDriverLocalService services;
    private static String appDirectory=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources";

    /**
     * The function is used to set Capabilities and invoke driver Server.
     */

    public void startAppiumServer(){
      services = new AppiumServiceBuilder()
                .withIPAddress(HOST)
                .usingPort(PORT)
                .withLogFile(new File(System.getProperty("user.dir")+File.separator+"appium-output-logs"+File.separator+"appium.log"))
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
            //  .withCapabilities()
                .build();
        services.start();
        services.clearOutPutStreams();
    }

    public AppiumDriver invokeDriver(String deviceName,
                                                       String platformVersion, String simulator, String udid, String os
                                                     )  {
        try {
            LogReporter.INFO("********Creating new session******");
            String Url = "http://"+HOST+":"+PORT+"/wd/hub";

            if (os.toLowerCase().contains(Platform.ANDROID.toString().toLowerCase())) {
                UiAutomator2Options options = new UiAutomator2Options();
                options
                        .setDeviceName(deviceName)
                        .setPlatformName(os)
                        .setPlatformVersion(platformVersion)
                        .setUdid(udid)
                        .autoGrantPermissions()
               //        .noReset()


                        .setApp(appDirectory+File.separator+"app-arm64-v8a-debug.apk");

                         driver = new AndroidDriver(new URL(Url), options);
                         LogReporter.INFO("Launching Android Driver");
          }else if(os.toLowerCase().contains(Platform.IOS.toString().toLowerCase())){
                XCUITestOptions options = new XCUITestOptions();
                options.setDeviceName(deviceName)
                        //.setApp(appDirectory+File.separator+"MYEICHER.ipa")
                        .setBundleId("in.here.volvo.ios")
                        .setPlatformName(os)
                        .setPlatformVersion(platformVersion)
                        .setUdid(udid)
                        .usePrebuiltWda()
                 //      .autoAcceptAlerts()
                        .autoWebview()
                        .noReset()
                        .includeSafariInWebviews()
                        .setCapability("xcodeOrgId","Z435JX8Z8Q");
                options.setCapability("xcodeSigningId","iPhone Developer");
                driver = new IOSDriver(new URL(Url), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                LogReporter.INFO("Launching IOS Driver");
            }

        } catch (Exception ex) {
            LogReporter.INFO(ex.getMessage());
           throw new RuntimeException("Unable to create Driver"+ ex.getMessage());
        }
        setDriver(driver);
        LogReporter.INFO("Message" + driver.getSessionId());
        return driver;
    }

    /**
     * To maintain Thread Safety between driver instance getDriver and SetDriver
     * method are created by using ThreadLocal.
     */


    public void relaunchDriver(){
        if( driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {

            ((AndroidDriver) driver).activateApp("in.here.volvo.android");
        }else{

            ((IOSDriver) driver).activateApp("in.here.volvo.ios");
        }

    }

    public void closeApp(){
        if( driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {

            ((AndroidDriver) driver).terminateApp("in.here.volvo.android");

        }else{

                    ((IOSDriver) driver).terminateApp("in.here.volvo.ios");
        }
    }

    public AppiumDriver getDriver() {
        return localDriver.get();
    }

    /**
     * To maintain Thread Safety between driver instance getDriver and SetDriver
     * method are created by using ThreadLocal.
     */

    public void setDriver(AppiumDriver driver) {
        localDriver.set(driver);

    }

    public void quitDriver(){
        if(driver !=null){
            driver.quit();
            driver=null;
        }

    }


    public void stopAppiumServer(){
        if (services != null) {
            services.stop();
        }
    }


}

