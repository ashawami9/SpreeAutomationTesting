package testsetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void initialSetup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashawami/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    @BeforeMethod
    public Properties readDatabase() throws IOException {
        FileReader reader = new FileReader("./src/main/java/init/db.properties");
        prop = new Properties();
        prop.load(reader);
        return prop;
    }

    @AfterMethod
    public void terminate() {
        driver.quit();
    }
}
