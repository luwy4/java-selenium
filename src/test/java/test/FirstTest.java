package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;
public class FirstTest {
    @Test
    public void openBrowserWithConfig() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");;
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Browser not supported");
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.quit();
    }
}

