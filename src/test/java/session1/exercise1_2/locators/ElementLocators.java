package session1.exercise1_2.locators;

import org.openqa.selenium.By;

public class ElementLocators {
    public static final By TEXT_BOX_MENU = By.xpath("//span[text()='Text Box']");
    public static final By FULL_NAME_INPUT = By.id("userName");
    public static final By EMAIL_INPUT = By.id("userEmail");
    public static final By CURRENT_ADDRESS_TEXTAREA = By.cssSelector("#currentAddress");
    public static final By PERMANENT_ADDRESS_TEXTAREA = By.cssSelector("#permanentAddress");
    public static final By SUBMIT_BUTTON = By.cssSelector("button#submit");
    public static final By OUTPUT_BOX = By.xpath("//div[contains(@class,'border')]");
    public static final By OUTPUT_NAME = By.xpath("//p[contains(@id,'name')]");

    public static final By OUTPUT_EMAIL = By.xpath("//p[contains(@id,'email')]");
    public static final By CURRENT_ADDRESS_LABEL = By.xpath("//label[normalize-space()='Current Address']");
}


