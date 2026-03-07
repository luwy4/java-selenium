package session2.exercise4_2.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage {

    WebDriver driver;
    WebDriverWait wait;

    private By iframe = By.id("mce_0_ifr");
    private By editorBody = By.id("tinymce");

    public IframePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToIframeByIndex(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void clearAndType(String text) {
        WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(editorBody));

        try {
            editor.clear();
        } catch (InvalidElementStateException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", editor);
        }

        editor.sendKeys(text);
    }

    public String getEditorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(editorBody)).getText();
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }
}