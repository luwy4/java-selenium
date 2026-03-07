package session2.exercise4_1.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private By result = By.id("result");


    public void clickJSAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(jsAlertBtn)).click();
    }

    public void clickJSConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(jsConfirmBtn)).click();
    }

    public void clickJSPrompt() {
        wait.until(ExpectedConditions.elementToBeClickable(jsPromptBtn)).click();
    }


    public void handleAlert(String action, String text) {

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        if (text != null) {
            alert.sendKeys(text);
        }

        if (action.equalsIgnoreCase("accept")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }


    public String getResultText() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(result)
        ).getText();
    }
}