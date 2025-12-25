package framework.tests;

import framework.pages.DashboardPage;
import framework.pages.LoginPage;
import framework.utils.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSmokeTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginSmokeTest.class);

    @Test(groups = "smoke")
    public void loginPageShouldLoadSuccessfully()
    {
        System.out.println("Thread ID:"+Thread.currentThread().threadId());
        LoginPage login = new LoginPage(getDriver());
        Assert.assertTrue(getDriver().getTitle().contains("Orange"));
        Assert.assertTrue(login.isUserNameFieldVisible());
        Assert.assertTrue(login.isPasswordFieldVisible());
    }

    @Test(groups = {"smoke","regression"})
    public void loginShouldSucceedwithvalidCredentials()
    {
        log.info("Thread ID:"+Thread.currentThread().threadId());
        LoginPage login = new LoginPage(getDriver());

        login.loginUser(ConfigReader.getProperty("valid.username"),ConfigReader.getProperty("valid.password"));
        DashboardPage dashboard = new DashboardPage(getDriver());
        Assert.assertTrue(dashboard.isDashboardDisplayed());

    }


}
