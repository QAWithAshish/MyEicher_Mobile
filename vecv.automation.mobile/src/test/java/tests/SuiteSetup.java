package tests;

import infra.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import logger.LogReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenShotUtils;

public class SuiteSetup {
    protected AppiumDriver driver = null;
    DriverFactory factory;
    static boolean testfailed=false;
    @BeforeSuite
    public void serverConfiguration ()
    {
        factory=new DriverFactory();
        factory.startAppiumServer();
    }

    @Parameters({"deviceName", "platformVersion","simulator","udid","os"})
    @BeforeTest
    public void Configuration (String deviceName, String platformVersion,String simulator,String udid, String os )
    {
        LogReporter.INFO("**********Starting Driver**********");

        if(factory==null) {

            factory = new DriverFactory();
        }
        factory.invokeDriver(deviceName,
                platformVersion, simulator,
                udid,os);
        driver=factory.getDriver();
        ScreenShotUtils.driver=driver;
    }

    @BeforeMethod

    public void launch() {
        if(testfailed) {
            factory.relaunchDriver();
            testfailed=false;
        }
    }

    @AfterMethod
    public void closeDown(ITestResult result) {
        LogReporter.Reporter("is passed "+result.isSuccess());
        ScreenShotUtils.attachScreenshot();
        if(!result.isSuccess()){
            testfailed=true;
            factory.closeApp();
        }


    }

    @AfterSuite
    public void teardownServer() {
        LogReporter.INFO("Going to TearDown");
        factory.quitDriver();
        LogReporter.INFO("Going to Stop Appium Server");
        factory.stopAppiumServer();
    }
}
