package session2.exercise4_1.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertPage {

    WebDriver driver;
    WebDriverWait wait;

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private By result = By.id("result");

    public void clickJSAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jsAlertBtn));
        driver.findElement(jsAlertBtn).click();
    }

    public void clickJSConfirm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jsConfirmBtn));
        driver.findElement(jsConfirmBtn).click();
    }

    public void clickJSPrompt() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jsPromptBtn));
        driver.findElement(jsPromptBtn).click();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    public String getResultText() {
        return driver.findElement(result).getText();
    }
}