package session1.exercise2_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import session1.exercise2_3.base.BasePage;

public class SuccessPage extends BasePage {

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(., 'Logged In Successfully')]")
    private WebElement successHeader;

    public String getSuccessText() {
        return getText(successHeader);
    }

    public boolean isLoggedIn() {
        return successHeader.isDisplayed();
    }
}
