package session3.exercise5_1.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session3.exercise5_1.base.BasePage;

public class DashboardPage extends BasePage {

    private final By successMessage = By.className("post-title");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public boolean isLoginSuccessful() {
        return isElementPresent(successMessage);
    }

    // You can add more methods here: logout(), goToProfile(), etc.
}