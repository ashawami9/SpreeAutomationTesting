package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    private Properties prop;

    public void initialSetup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashawami/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    public Properties readDatabase() throws IOException {
        FileReader reader = new FileReader("./src/main/java/init/db.properties");
        prop = new Properties();
        prop.load(reader);
        return prop;
    }

    public void terminate() {
        driver.quit();
    }
}
