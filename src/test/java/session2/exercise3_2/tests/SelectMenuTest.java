package session2.exercise3_2.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session2.exercise3_2.data.Constants;
import session2.exercise3_2.pages.SelectMenuPage;

public class SelectMenuTest extends BaseTest {

    private SelectMenuPage page;

    @Test
    public void testSelectColor() {
        page = new SelectMenuPage(driver);
        page.open()
                .selectColor(Constants.COLOR_BLUE);

        Assert.assertEquals(
                page.getSelectedColor(),
                Constants.COLOR_BLUE,
                "Selected color is incorrect"
        );
    }

    @Test
    public void testMultiSelectCars() {
        page = new SelectMenuPage(driver);
        page.open();

        Assert.assertTrue(
                page.isMultiSelectSupported(),
                "Cars dropdown does not support multi-select"
        );

        page.selectCars(Constants.CAR_VOLVO, Constants.CAR_AUDI);

        Assert.assertEquals(
                page.getSelectedCarsCount(),
                Constants.EXPECTED_SELECTED_CARS,
                "Number of selected cars is incorrect"
        );
    }
}
