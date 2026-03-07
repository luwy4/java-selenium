package session1.exercise1_2.locators;

import org.openqa.selenium.By;

public class ElementLocators {
    public static final String ID = "//*[@id='%s']";
    public static final String LABEL_BY_TEXT = "//label[text()='%s']";
    public static final String MENU_ITEM = "//span[normalize-space()='%s']";
    public static final String OUTPUT_FIELD = "//p[contains(@id, '%s')]";
    public static final String BTN_BY_TEXT = "//button[text()='%s']";
    public static final String CSS_USER_FORM = "#userForm";
    public static final String XPATH_HEADER = "//*[contains(@class,'main-header') and text()='%s']";
    public static final String TAG_INPUT = "input";
    public static final String CLASS_OUTPUT_BOX = "border";
    public static final String CSS_OUTPUT_WRAPPER = "div#output div";
}

