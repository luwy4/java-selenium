package session2.exercise3_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameTxt = By.id("userName");
    private By passwordTxt = By.id("password");
    private By loginBtn = By.id("login");

    public void login(String username, String password) {
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
