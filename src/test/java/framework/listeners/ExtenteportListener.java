package framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.tests.BaseTest;
import framework.utils.ExtentManager;
import framework.utils.ExtentTestManager;
import framework.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtenteportListener implements ITestListener {

   private static ExtentReports extent = ExtentManager.getExtentReportInstance();
   //private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(result.getTestClass().getName()+"::"+testName); //creating extent node on start of the test
        ExtentTestManager.setExtentTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getExtentTest().pass("Test passed...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getExtentTest().fail("Test failed...");
        Object testclass = result.getInstance();
        WebDriver driver = ((BaseTest)testclass).getDriver();
        String  path = ScreenshotUtils.captureScreenshot(driver,result.getMethod().getMethodName()); //add screenshot to the report
        ExtentTestManager.getExtentTest().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
       ExtentTestManager.getExtentTest().skip("Test skipped...");
    }


    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.removeExtentTest();
       extent.flush();
    }
}

