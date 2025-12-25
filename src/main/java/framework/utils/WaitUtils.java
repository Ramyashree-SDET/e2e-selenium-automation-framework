package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

   protected WebDriver driver;
   protected WebDriverWait wait;

    public WaitUtils(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public WebElement wait_FindElement_ByVisibility(By locator)
    {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> wait_FindElements_ByVisibility(By locator)
    {
       return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement wait_FindElement_ByClickable(By locator)
    {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> wait_FindElements_ByPresence(By locator)
    {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
