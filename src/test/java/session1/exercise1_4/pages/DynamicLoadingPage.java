package session1.exercise1_4.pages;

import org.openqa.selenium.WebDriver;
import session1.exercise1_4.locators.DynamicLoadingLocators;

public class DynamicLoadingPage {
    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(DynamicLoadingLocators.START_BTN).click();
    }
}