package session1.exercise2_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public void enterUsername(String user) {
        type(usernameField, user);
    }

    public void enterPassword(String pass) {
        type(passwordField, pass);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickSubmit();
    }

    public SuccessPage loginSuccessfully(String user, String pass) {
        login(user, pass);
        return new SuccessPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
