package framework.pages;

import framework.base.BasePage;
import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver)
    {
        super(driver);

    }

    private By dashboardLogo = By.xpath("//h6[normalize-space()='Dashboard']");

    public boolean isDashboardDisplayed()
    {
        try {
            return wait.wait_FindElement_ByVisibility(dashboardLogo).isDisplayed();
        } catch (Exception e) {
            log.info("Dashboard is not loaded.. error:"+e.getMessage());
            return false;
        }
    }
}
