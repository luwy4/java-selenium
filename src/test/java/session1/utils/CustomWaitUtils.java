package session1.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.List;

public class CustomWaitUtils {
    public static ExpectedCondition<Boolean> loadingFinished(By loading, By success, String expectedText) {
        return driver -> {
            try {
                List<WebElement> loadingElems = driver.findElements(loading);
                boolean isNotLoading = loadingElems.isEmpty() || !loadingElems.get(0).isDisplayed();

                WebElement successElem = driver.findElement(success);
                boolean hasCorrectText = successElem.isDisplayed() &&
                        successElem.getText().trim().equals(expectedText);

                return isNotLoading && hasCorrectText;
            } catch (Exception e) {
                return false;
            }
        };
    }
}