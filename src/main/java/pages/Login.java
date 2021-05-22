package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Header {
    @FindBy(id = "spree_user_email")
    private WebElement email;
    @FindBy(id = "spree_user_password")
    private WebElement password;
    @FindBy(name = "commit")
    private WebElement login;

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void as(String userEmail, String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        login.click();
    }
}
