package session2.exercise4_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeFormPage {

    private WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }


    private By submitBtn_text = By.xpath("//button[text()='Submit']");

    private By input_contains = By.xpath("//input[contains(@id,'Name')]");

    private By hobby_reading = By.xpath("//label[normalize-space()='Reading']");

    private By div_starts = By.xpath("//div[starts-with(@class,'col')]");

    // Đã fix: button Submit thường là button cuối trong form
    private By button_position = By.xpath("//form//button[position()=last()]");


    private By css_input_text = By.cssSelector("input[type='text']");

    private By css_child = By.cssSelector("form input[type='text']");

    private By css_class = By.cssSelector("input[name='gender']");


    public boolean isSubmitDisplayed() {
        return driver.findElement(submitBtn_text).isDisplayed();
    }

    public boolean isContainsInputDisplayed() {
        return driver.findElement(input_contains).isDisplayed();
    }

    public boolean isNormalizeDisplayed() {
        return driver.findElement(hobby_reading).isDisplayed();
    }

    public boolean isStartsDisplayed() {
        return driver.findElement(div_starts).isDisplayed();
    }

    public boolean isPositionDisplayed() {
        return driver.findElement(button_position).isDisplayed();
    }

    public boolean isCssAttributeDisplayed() {
        return driver.findElement(css_input_text).isDisplayed();
    }

    public boolean isCssChildDisplayed() {
        return driver.findElement(css_child).isDisplayed();
    }

    public boolean isCssClassDisplayed() {
        List<WebElement> elements = driver.findElements(css_class);
        if (elements.isEmpty()) {
            return false;
        }
        return elements.get(0).isDisplayed();
    }
}