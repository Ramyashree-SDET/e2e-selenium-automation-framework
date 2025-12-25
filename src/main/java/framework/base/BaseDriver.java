package framework.base;

import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

//BaseDriver class(Driver Factory) responsibility : Only Create/Initialize a WebDriver. No Teardown

    public WebDriver initializeDriver(String browser) {
        if (ConfigReader.getProperty("execution.mode") == "grid") {
            //remode webdriver execution.
            return null;
        }
        else
        {
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }
            WebDriver driver; //In Driver factory it's better to define driver inside the method

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    manageWindow(driver);
                    return driver;
                case "firefox":
                    driver = new FirefoxDriver();
                    manageWindow(driver);
                    return driver;
                default:
                    throw new IllegalArgumentException("This browser is not supported");
            }


        }
    }
    private void manageWindow(WebDriver driver)
    {

        driver.manage().window().maximize();
    }



}
