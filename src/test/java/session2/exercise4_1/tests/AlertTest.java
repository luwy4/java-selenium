package session2.exercise4_1.tests;



import session2.exercise4_1.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session2.exercise4_1.pages.JavaScriptAlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testAlerts() {

        JavaScriptAlertPage alertPage = new JavaScriptAlertPage(driver);

        // Simple Alert
        alertPage.clickJSAlert();
        alertPage.acceptAlert();

        Assert.assertEquals(alertPage.getResultText(), "You successfully clicked an alert");

        // Confirm Alert
        alertPage.clickJSConfirm();
        alertPage.dismissAlert();

        Assert.assertEquals(alertPage.getResultText(), "You clicked: Cancel");

        // Prompt Alert
        alertPage.clickJSPrompt();
        alertPage.sendKeysAlert("Automation");
        alertPage.acceptAlert();

        Assert.assertTrue(alertPage.getResultText().contains("Automation"));
    }
}