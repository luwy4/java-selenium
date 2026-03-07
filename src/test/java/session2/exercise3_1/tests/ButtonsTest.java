package session2.exercise3_1.tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session2.exercise3_1.pages.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test
    public void testButtonsActions() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);

        buttonsPage.openButtonsPage();

        buttonsPage.doubleClick();
        Assert.assertEquals(buttonsPage.getDoubleClickMessage(), "You have done a double click");

        buttonsPage.rightClick();
        Assert.assertEquals(buttonsPage.getRightClickMessage(), "You have done a right click");

        buttonsPage.dynamicClick();
        Assert.assertEquals(buttonsPage.getDynamicClickMessage(), "You have done a dynamic click");
    }

    @Test
    public void testDragAndDrop() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);

        buttonsPage.openDragAndDropPage();
        buttonsPage.dragAndDropByActions();

        Assert.assertEquals(buttonsPage.getDropResultText(), "Dropped!");
    }
}
