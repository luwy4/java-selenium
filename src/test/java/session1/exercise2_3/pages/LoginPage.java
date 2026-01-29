package session1.exercise2_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import session1.exercise2_3.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "error")
    private WebElement errorMessage;

    public LoginPage enterUsername(String input) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(input);
        return this;
    }

    public LoginPage enterPassword(String input) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(input);
        return this;
    }

    public SuccessPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return new SuccessPage(driver);
    }

    public SuccessPage login(String user, String pass) {
        return enterUsername(user)
                .enterPassword(pass)
                .clickSubmit();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
