package framework.tests;

import framework.base.BaseDriver;
import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    BaseDriver base = new BaseDriver();

    public WebDriver getDriver()
    {
        return driver.get();
    }

    @BeforeMethod
    public void setUpDriver()
    {
       WebDriver webdriver = base.initializeDriver(ConfigReader.getProperty("browser"));
        driver.set(webdriver);
        getDriver().get(ConfigReader.getProperty("url"));

    }

    @AfterMethod
    public void quitDriver()
    {
      if(getDriver()!=null)
      {
          getDriver().quit();
          driver.remove();

      }
    }
}
