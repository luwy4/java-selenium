package session1.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class WindowUtils {

    public static String getCurrentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static void switchToNewWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public static void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    public static void switchToWindow(WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public static void closeCurrentWindow(WebDriver driver) {
        driver.close();
    }
}