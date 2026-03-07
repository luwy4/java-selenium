package session2.exercise3_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedActionsPage {

    WebDriver driver;
    Actions actions;

    private By doubleClickBtn = By.id("doubleClickBtn");
    private By dynamicBtn = By.xpath("//button[text()='Click Me']");

    public AdvancedActionsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void ctrlClickOnDynamicButton() {
        actions.keyDown(Keys.CONTROL).click(driver.findElement(dynamicBtn)).keyUp(Keys.CONTROL).perform();
    }

    public void shiftDoubleClick() {
        actions.keyDown(Keys.SHIFT).doubleClick(driver.findElement(doubleClickBtn)).keyUp(Keys.SHIFT).perform();
    }

    public void hoverPauseAndClick() {
        WebElement element = driver.findElement(dynamicBtn);

        actions.moveToElement(element).pause(1000).click().perform();
    }

    public void clickAndHoldDynamicButton() {
        actions.clickAndHold(driver.findElement(dynamicBtn)).pause(1000).release().perform();
    }

    public void pressEnterKey() {
        actions.sendKeys(Keys.ENTER).perform();
    }
}
