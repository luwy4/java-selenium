package session2.exercise4_1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import session2.exercise4_1.base.BaseTest;
import session2.exercise4_1.pages.JavaScriptAlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testAllAlerts() {

        JavaScriptAlertPage alertPage = new JavaScriptAlertPage(driver);

        alertPage.clickJSAlert();
        alertPage.handleAlert("accept", null);

        Assert.assertEquals(
                alertPage.getResultText(),
                "You successfully clicked an alert"
        );

        alertPage.clickJSConfirm();
        alertPage.handleAlert("dismiss", null);

        Assert.assertEquals(
                alertPage.getResultText(),
                "You clicked: Cancel"
        );

        alertPage.clickJSPrompt();
        alertPage.handleAlert("accept", "Automation");

        Assert.assertTrue(
                alertPage.getResultText().contains("Automation")
        );
    }

    @Test
    public void testMultipleAlerts() {

        JavaScriptAlertPage alertPage = new JavaScriptAlertPage(driver);

        for (int i = 0; i < 2; i++) {
            alertPage.clickJSAlert();
            alertPage.handleAlert("accept", null);
        }

        Assert.assertEquals(
                alertPage.getResultText(),
                "You successfully clicked an alert"
        );
    }
}