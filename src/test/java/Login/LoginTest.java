package Login;

import com.relevantcodes.extentreports.LogStatus;
import testsetup.BaseTest;
import org.testng.annotations.*;
import pages.Login;

import static java.lang.System.getenv;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginAndLogout() {
        gt = gr.startTest("testLoginAndLogout");
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(getenv("EMAIL") , getenv("PASSWORD"));
        login.clickLogoutButton();
        gt.log(LogStatus.PASS, "Test Passed");
    }

    @Test
    public void testSuccessfulMessageOnValidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(prop.getProperty("correctEmail"), prop.getProperty("correctPassword"));
        assertEquals(login.getLoginMessage(), "Logged in successfully");
    }

    @Test
    public void testErrorMessageOnInvalidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(prop.getProperty("incorrectEmail"), prop.getProperty("incorrectPassword"));
        assertEquals(login.getLoginMessage(), "Invalid email or password.");
    }
}
