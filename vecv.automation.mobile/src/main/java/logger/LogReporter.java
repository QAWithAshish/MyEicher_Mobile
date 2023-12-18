package logger;

import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import reporter.ExtentTestManager;


public class LogReporter {

    private final static Logger logger = LoggerFactory.getLogger(LogReporter.class);

    public static void INFO(String message){
        logger.info(message);
    }

    public static void Reporter(String Message){
        INFO(Message);
       ExtentTestManager.getTest().log(Status.INFO,Message);
    }

    public static void ErrorMsgDetails(int count, ITestResult iTestResult){
        try {
            for (int i = 0; i < count; i++) {
                Reporter("Error Msg in::" + iTestResult.getThrowable().getStackTrace()[i].getClassName()
                        + "  And methodName: " + iTestResult.getThrowable().getStackTrace()[i].getMethodName()
                        + "  And lineNumber: " + iTestResult.getThrowable().getStackTrace()[i].getLineNumber());
            }
        }catch (Exception ex){
            LogReporter.Reporter("Print stack trace not available");
        }
    }



}
