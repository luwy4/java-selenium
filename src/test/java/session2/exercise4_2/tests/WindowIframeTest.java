package session2.exercise4_2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import session2.exercise4_2.base.BaseTest;
import session2.exercise4_2.pages.IframePage;
import session2.exercise4_2.pages.NestedFramePage;
import session2.exercise4_2.pages.WindowPage;
import session2.exercise4_2.utils.ConfigReader;

import java.time.Duration;
import java.util.Set;

public class WindowIframeTest extends BaseTest {

    @Test
    public void testEX42() {

        driver.get(ConfigReader.get("window.url"));

        WindowPage windowPage = new WindowPage(driver);

        String mainWindow = driver.getWindowHandle();

        windowPage.openNewWindow();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();

        for (String w : windows) {
            if (!w.equals(mainWindow)) {
                driver.switchTo().window(w);
            }
        }

        System.out.println("New Window Text: " + driver.findElement(By.tagName("h3")).getText());

        driver.close();

        driver.switchTo().window(mainWindow);

        driver.get(ConfigReader.get("iframe.url"));

        IframePage iframePage = new IframePage(driver);

        iframePage.switchToIframeByIndex(0);
        iframePage.clearAndType("Automation iframe by index");

        iframePage.switchToMainContent();

        iframePage.switchToIframe();
        iframePage.clearAndType("Automation iframe by id");
    }
}