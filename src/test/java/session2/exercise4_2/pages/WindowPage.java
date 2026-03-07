package session2.exercise4_2.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage {

    WebDriver driver;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
    }

    private By clickHere = By.linkText("Click Here");

    public void openNewWindow() {
        driver.findElement(clickHere).click();
    }
}