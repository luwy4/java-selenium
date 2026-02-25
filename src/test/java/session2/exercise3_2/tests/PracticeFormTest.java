package session2.exercise3_2.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session2.exercise3_2.data.Constants;
import session2.exercise3_2.pages.PracticeFormPage;
import session1.utils.ConfigReader;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testSubmitPracticeForm() {
        driver.get(ConfigReader.get("url3.2"));

        PracticeFormPage form = new PracticeFormPage(driver);

        form.enterPersonalInfo(
                Constants.FIRST_NAME,
                Constants.LAST_NAME,
                Constants.EMAIL,
                Constants.MOBILE
        );

        form.selectByLabel(Constants.GENDER);

        for (String hobby : Constants.HOBBIES) {
            form.selectByLabel(hobby);
        }

        form.setDateOfBirth(Constants.DOB);
        form.selectStateAndCity(Constants.STATE, Constants.CITY);
        form.submitForm();

        Assert.assertEquals(
                form.getSubmitTitle(),
                Constants.SUBMIT_SUCCESS_TITLE
        );

        Assert.assertEquals(
                form.getResultValue(Constants.LABEL_STUDENT_EMAIL),
                Constants.EMAIL
        );
    }
}
