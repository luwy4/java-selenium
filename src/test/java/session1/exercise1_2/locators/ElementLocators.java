package session1.exercise1_2.locators;

import org.openqa.selenium.By;

public class ElementLocators {
    public static final By ID_NAME = By.id("userName");
    public static final By ID_EMAIL = By.id("userEmail");
    public static final By ID_CURRENT_ADDR = By.id("currentAddress");
    public static final By ID_PERMANENT_ADDR = By.id("permanentAddress");
    public static final By BTN_SUBMIT = By.id("submit");
    public static final By XPATH_LABEL_NAME = By.xpath("//label[@id='userName-label']");
    public static final By CSS_OUTPUT_NAME = By.cssSelector("#output #name");
    public static final By CSS_OUTPUT_EMAIL = By.cssSelector("#output #email");

    public static final String DYNAMIC_MENU = "//span[text()='%s']";
    public static final String DYNAMIC_OUTPUT = "//p[contains(@id,'%s')]";
}

