package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;


public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void initialSetup(){
        System.setProperty("webdriver.chrome.driver" , "/Users/ashawami/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void endSetup(){
        driver.close();
    }

    public void loginSetup(String test_email, String test_password){
        WebElement login_item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        login_item.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spree_user_email")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spree_user_password")));

        email.sendKeys(test_email);
        password.sendKeys(test_password);

        WebElement login_button = driver.findElement(By.name("commit"));
        login_button.click();
    }

    @Test
    public void testLoginAndLogout() {
        String correct_email = "ash1@gmail.com";
        String correct_password = "ash1234";

        loginSetup(correct_email, correct_password);

        WebElement logout_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        logout_button.click();
    }

    @Test
    public void testSuccessfulMessageOnValidLogin() {
        String correct_email = "ash1@gmail.com";
        String correct_password = "ash1234";

        loginSetup(correct_email, correct_password);

        WebElement success_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
        assertEquals(success_message.getText() , "Logged in successfully");
    }

    @Test
    public void testErrorMessageOnInvalidLogin() {
        String incorrect_email = "ash@gmail.com";
        String incorrect_password = "ash12";

        loginSetup(incorrect_email, incorrect_password);

        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-error")));
        assertEquals(error_message.getText() , "Invalid email or password.");
    }
}
