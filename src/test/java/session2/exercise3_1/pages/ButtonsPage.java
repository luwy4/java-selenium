package session2.exercise3_1.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session1.utils.ConfigReader;


import java.time.Duration;

public class ButtonsPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By dynamicClickMsg = By.id("dynamicClickMessage");

    private By draggable = By.id("draggable");
    private By droppable = By.id("droppable");
    private By dropResult = By.xpath("//div[@id='droppable']/p");

    public void openButtonsPage() {
        driver.get(ConfigReader.get("url3.1"));
    }

    public void openDragAndDropPage() {
        driver.get(ConfigReader.get("URL3.1"));
    }

    public void doubleClick() {
        WebElement element = driver.findElement(doubleClickBtn);
        actions.doubleClick(element).perform();
    }

    public void rightClick() {
        WebElement element = driver.findElement(rightClickBtn);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        actions.moveToElement(element).pause(Duration.ofMillis(300)).contextClick().perform();
    }

    public void dynamicClick() {
        driver.findElement(dynamicClickBtn).click();
    }

    public String getDoubleClickMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(doubleClickMsg)).getText();
    }

    public String getRightClickMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(rightClickMsg)).getText();
    }

    public String getDynamicClickMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(dynamicClickMsg)).getText();
    }

    public void dragAndDropByActions() {
        WebElement source = driver.findElement(draggable);
        WebElement target = driver.findElement(droppable);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);

        actions.moveToElement(source).clickAndHold().pause(Duration.ofMillis(300)).moveToElement(target).pause(Duration.ofMillis(300)).release().perform();
    }

    public String getDropResultText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(dropResult)).getText();
    }
}
