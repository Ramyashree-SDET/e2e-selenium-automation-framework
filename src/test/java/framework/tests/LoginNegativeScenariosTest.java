package framework.tests;

import framework.pages.DashboardPage;
import framework.pages.LoginPage;
import framework.utils.ConfigReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginNegativeScenariosTest extends BaseTest{

    SoftAssert sassert = new SoftAssert();

    @Test(groups = "regression")
    public void loginShouldFailWithInvalidCredentials()
    {
        System.out.println("Thread ID:"+Thread.currentThread().threadId());

        LoginPage login = new LoginPage(getDriver());
        login.loginUser(ConfigReader.getProperty("invalid.username"),ConfigReader.getProperty("invalid.password"));
        sassert.assertTrue(login.isInvalidCredsErrorDisplayed());
        sassert.assertTrue(login.getInvalidCredErrorMessage().contains("Invalid"));

        DashboardPage dashboard = new DashboardPage(getDriver());
        sassert.assertFalse(dashboard.isDashboardDisplayed());
        sassert.assertAll();

    }


}
