package session3.exercise5_1.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session3.exercise5_1.base.BasePage;
import session3.exercise5_1.utils.ConfigReader;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton  = By.id("submit");

    public LoginPage(WebDriver driver) {
        super(driver);
        navigateTo(ConfigReader.getUrl());
    }

    public LoginPage enterUsername(String username) {
        sendKeys(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }

    public DashboardPage clickSubmit() {
        click(submitButton);
        return new DashboardPage(driver);
    }

    // Convenience method (optional)
    public DashboardPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickSubmit();
    }
}