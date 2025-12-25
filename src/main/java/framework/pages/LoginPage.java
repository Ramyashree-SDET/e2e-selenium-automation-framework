package framework.pages;

import framework.base.BaseDriver;
import framework.base.BasePage;
import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

        public LoginPage(WebDriver driver)
        {
            super(driver);

        }

        private By username = By.name("username");
        private By password = By.name("password");
        private By login = By.cssSelector("button[type='submit']");
        private By invalidCredentials_errormessage = By.xpath("//p[contains(normalize-space(),'Invalid')]");

        public void enterUsername(String username_Input) {
            log.info("Entering username: " + username_Input);
            wait.wait_FindElement_ByVisibility(username).sendKeys(username_Input);
        }

    public void enterPassword(String password_Input)
    {

        log.info("Entering password: "+password_Input);
        wait.wait_FindElement_ByVisibility(password).sendKeys(password_Input);
    }

    public void clickSubmit()
    {
        wait.wait_FindElement_ByVisibility(login).click();
    }

    public boolean isUserNameFieldVisible()
    {
        return wait.wait_FindElement_ByVisibility(username).isDisplayed();
    }

    public boolean isPasswordFieldVisible()
    {
        return wait.wait_FindElement_ByVisibility(password).isDisplayed();
    }

    public boolean isInvalidCredsErrorDisplayed()
    {
        return wait.wait_FindElement_ByVisibility(invalidCredentials_errormessage).isDisplayed();
    }
    public String getInvalidCredErrorMessage()
    {
        return wait.wait_FindElement_ByVisibility(invalidCredentials_errormessage).getText();
    }


    //Wrapper method
    public void loginUser(String username_Input,String password_Input)
    {
        enterUsername(username_Input);
        enterPassword(password_Input);
        clickSubmit();
    }




}
