package session3.exercise5_3.tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session3.exercise5_3.pages.AccessibilityPage;

import java.util.ArrayList;
import java.util.List;

public class AccessibilityTest extends BaseTest {

    private AccessibilityPage page;

    @BeforeMethod
    public void initPage() {
        page = new AccessibilityPage(driver).open();
    }

    @Test
    public void testAccessibilityAttributes() {
        WebElement element = page.getSubmitButton();

        // Check ARIA label
        String ariaLabel = element.getAttribute("aria-label");
        if (ariaLabel == null || ariaLabel.isBlank()) {
            ariaLabel = element.getText();
        }
        Assert.assertNotNull(ariaLabel);
        Assert.assertFalse(ariaLabel.isBlank());

        // Check role
        String role = element.getAttribute("role");
        if (role == null || role.isBlank()) {
            role = element.getTagName();
        }
        Assert.assertEquals(role, "button");
    }

    @Test
    public void testKeyboardNavigation() {
        Assert.assertTrue(tabUntilFocusId("username", 8),
                "Could not focus username field using keyboard Tab navigation.");
        Assert.assertTrue(tabUntilFocusId("password", 3),
                "Could not focus password field after username.");
        Assert.assertTrue(tabUntilFocusId("submit", 3),
                "Could not focus submit button after password.");
    }

    @Test
    public void testColorContrast() {
        WebElement submitButton = page.getSubmitButton();
        String foreground = submitButton.getCssValue("color");
        String background = getEffectiveBackgroundColor(submitButton);

        double ratio = getContrastRatio(foreground, background);
        Assert.assertTrue(ratio >= 4.5,
                "Contrast ratio is below WCAG AA threshold: " + ratio);
    }

    @Test
    public void testScreenReaderCompatibility() {
        WebElement username = page.getUsernameField();
        WebElement password = page.getPasswordField();
        WebElement submit = page.getSubmitButton();

        Assert.assertTrue(hasAccessibleName(username),
                "Username field should have accessible name.");
        Assert.assertTrue(hasAccessibleName(password),
                "Password field should have accessible name.");
        Assert.assertTrue(hasAccessibleName(submit),
                "Submit button should have accessible name.");
    }

    @Test
    public void testComprehensiveA11ySuite() {
        List<String> violations = new ArrayList<>();

        for (WebElement element : page.getInteractiveElements()) {
            if (!element.isDisplayed()) {
                continue;
            }

            String tagName = element.getTagName();
            if (("input".equals(tagName) || "button".equals(tagName) || "a".equals(tagName))
                    && !hasAccessibleName(element)) {
                violations.add("Missing accessible name: <" + tagName + ">");
            }

            String text = element.getText();
            if (text != null && !text.isBlank()) {
                double ratio = getContrastRatio(
                        element.getCssValue("color"),
                        getEffectiveBackgroundColor(element)
                );
                if (ratio < 4.5) {
                    violations.add("Low contrast (" + ratio + ") on <" + tagName + ">");
                }
            }
        }

        Assert.assertTrue(violations.isEmpty(),
                "Accessibility issues found:\n" + String.join("\n", violations));
    }

    private boolean hasAccessibleName(WebElement element) {
        String ariaLabel = element.getAttribute("aria-label");
        if (ariaLabel != null && !ariaLabel.isBlank()) {
            return true;
        }

        String ariaLabelledBy = element.getAttribute("aria-labelledby");
        if (ariaLabelledBy != null && !ariaLabelledBy.isBlank()) {
            for (String id : ariaLabelledBy.split("\\s+")) {
                List<WebElement> labels = driver.findElements(By.id(id));
                if (!labels.isEmpty() && !labels.get(0).getText().isBlank()) {
                    return true;
                }
            }
        }

        String id = element.getAttribute("id");
        if (id != null && !id.isBlank()) {
            List<WebElement> labels = driver.findElements(By.cssSelector("label[for='" + id + "']"));
            if (!labels.isEmpty() && !labels.get(0).getText().isBlank()) {
                return true;
            }
        }

        String text = element.getText();
        return text != null && !text.isBlank();
    }

    private boolean tabUntilFocusId(String expectedId, int maxTabs) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < maxTabs; i++) {
            actions.sendKeys(Keys.TAB).perform();
            WebElement focused = driver.switchTo().activeElement();
            if (expectedId.equals(focused.getAttribute("id"))) {
                return true;
            }
        }
        return false;
    }

    private String getEffectiveBackgroundColor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "let e = arguments[0];"
                + "while(e){"
                + "  const bg = window.getComputedStyle(e).backgroundColor;"
                + "  if(bg && bg !== 'rgba(0, 0, 0, 0)' && bg !== 'transparent'){return bg;}"
                + "  e = e.parentElement;"
                + "}"
                + "return 'rgb(255, 255, 255)';";
        return (String) js.executeScript(script, element);
    }

    private double getContrastRatio(String foregroundColor, String backgroundColor) {
        int[] fg = parseRgbColor(foregroundColor);
        int[] bg = parseRgbColor(backgroundColor);

        double fgLum = getRelativeLuminance(fg[0], fg[1], fg[2]);
        double bgLum = getRelativeLuminance(bg[0], bg[1], bg[2]);

        double lighter = Math.max(fgLum, bgLum);
        double darker = Math.min(fgLum, bgLum);
        return (lighter + 0.05) / (darker + 0.05);
    }

    private int[] parseRgbColor(String cssColor) {
        String cleaned = cssColor.replace("rgba(", "")
                .replace("rgb(", "")
                .replace(")", "");
        String[] parts = cleaned.split(",");

        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());
        return new int[]{r, g, b};
    }

    private double getRelativeLuminance(int r, int g, int b) {
        double rs = channelToLinear(r / 255.0);
        double gs = channelToLinear(g / 255.0);
        double bs = channelToLinear(b / 255.0);
        return 0.2126 * rs + 0.7152 * gs + 0.0722 * bs;
    }

    private double channelToLinear(double value) {
        if (value <= 0.03928) {
            return value / 12.92;
        }
        return Math.pow((value + 0.055) / 1.055, 2.4);
    }
}
