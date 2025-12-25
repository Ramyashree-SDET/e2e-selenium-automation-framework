package framework.base;

import framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
   protected WaitUtils wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

}
