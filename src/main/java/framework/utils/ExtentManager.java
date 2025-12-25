package framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent; //define instance of ExtentReport

    private ExtentManager(){}; //make it private, so that other classes cannot create instance of this class. Singleton pattern

    public static ExtentReports getExtentReportInstance()
    {
        if(extent==null) //create instance only if required. Lazy initialization
        {
            String path=System.getProperty("user.dir")+"/reports/ExtentReport.html"; // html report path.No hardcode. CI pipeline friendly reference

            ExtentSparkReporter reporter = new ExtentSparkReporter(path); //html report , defines format and style of report

            extent =new ExtentReports(); //create instance of ExtentReport

            extent.attachReporter(reporter); //attch html reporter

        }
        return extent;
    }
}
