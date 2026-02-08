package session2.exercise3_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import session1.utils.ConfigReader;

public class SelectMenuPage {

    private WebDriver driver;

    private final By oldStyleSelect = By.id("oldSelectMenu");
    private final By carsMultiSelect = By.id("cars");

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public SelectMenuPage open() {
        driver.get(ConfigReader.get("URL3.2"));
        return this;
    }


    private Select oldStyleDropdown() {
        return new Select(driver.findElement(oldStyleSelect));
    }

    private Select carsDropdown() {
        return new Select(driver.findElement(carsMultiSelect));
    }

    public void selectColor(String color) {
        oldStyleDropdown().selectByVisibleText(color);
    }

    public String getSelectedColor() {
        return oldStyleDropdown().getFirstSelectedOption().getText();
    }

    public boolean isMultiSelectSupported() {
        return carsDropdown().isMultiple();
    }

    public void selectCars(String... cars) {
        Select select = carsDropdown();
        for (String car : cars) {
            select.selectByVisibleText(car);
        }
    }

    public int getSelectedCarsCount() {
        return carsDropdown().getAllSelectedOptions().size();
    }
}
