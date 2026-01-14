package session1.exercise1_2.locators;
import org.openqa.selenium.By;
public class ElementLocators {
    public static final By FULL_NAME = By.id("userName");
    public static final By EMAIL = By.id("userEmail");
    public static final By GENDER = By.name("gender");
    public static final By CURRENT_ADDRESS =
            By.cssSelector("#currentAddress");
    public static final By SUBMIT =
            By.cssSelector("button#submit");
    public static final By ELEMENTS_MENU_ABSOLUTE =
            By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div[1]");
    public static final By TEXT_BOX_MENU =
            By.xpath("//span[text()='Text Box']");
    public static final By PERMANENT_ADDRESS =
            By.xpath("//textarea[@id='permanentAddress']");
    public static final By ELEMENTS_SECTION =
            By.xpath("//div[contains(@class,'header-text')]");
    public static final By RADIO_BUTTON_MENU =
            By.xpath("//span[normalize-space()='Radio Button']");
}
