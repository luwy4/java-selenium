package session1.exercise1_3.locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By SUBMIT_BUTTON = By.id("submit");
    public static final By SUCCESS_MESSAGE = By.tagName("h1");
    public static final By ERROR_MESSAGE = By.id("error");
}
