package session2.exercise3_2.pages;

import org.openqa.selenium.*;

public class PracticeFormPage {

    private WebDriver driver;
    private JavascriptExecutor js;

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By mobile = By.id("userNumber");
    private By dateInput = By.id("dateOfBirthInput");
    private By submitBtn = By.id("submit");

    private By reactInput = By.xpath("//input[contains(@id,'react-select')]");
    private String labelByText = "//label[text()='%s']";

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    private void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void enterPersonalInfo(String fName, String lName, String mail, String phone) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(mobile).sendKeys(phone);
    }

    public void selectByLabel(String value) {
        jsClick(driver.findElement(
                By.xpath(String.format(labelByText, value))
        ));
    }

    public void setDateOfBirth(String dob) {
        WebElement date = driver.findElement(dateInput);
        date.sendKeys(Keys.CONTROL + "a");
        date.sendKeys(dob + Keys.ENTER);
    }

    public void selectStateAndCity(String state, String city) {
        WebElement input = driver.findElement(reactInput);

        input.sendKeys(state);
        input.sendKeys(Keys.ENTER);

        input.sendKeys(city);
        input.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        jsClick(driver.findElement(submitBtn));
    }

    public String getSubmitTitle() {
        return driver.findElement(
                By.id("example-modal-sizes-title-lg")
        ).getText();
    }

    public String getResultValue(String label) {
        return driver.findElement(
                By.xpath("//td[text()='" + label + "']/following-sibling::td")
        ).getText();
    }
}
