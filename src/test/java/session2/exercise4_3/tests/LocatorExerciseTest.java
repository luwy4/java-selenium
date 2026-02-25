package session2.exercise4_3.tests;

import org.testng.annotations.Test;
import session2.exercise4_3.base.BaseTest;
import session2.exercise4_3.pages.PracticeFormPage;
import session2.exercise4_3.utils.ConfigReader;

import static org.testng.Assert.*;

public class LocatorExerciseTest extends BaseTest {

    private PracticeFormPage page;

    private void initPage() {
        navigateTo(ConfigReader.getBaseUrl());
        page = new PracticeFormPage(driver);
    }

    @Test
    public void testXPathText() {
        initPage();
        assertTrue(page.isSubmitDisplayed());
    }

    @Test
    public void testXPathContains() {
        initPage();
        assertTrue(page.isContainsInputDisplayed());
    }

    @Test
    public void testXPathNormalize() {
        initPage();
        assertTrue(page.isNormalizeDisplayed());
    }

    @Test
    public void testXPathStarts() {
        initPage();
        assertTrue(page.isStartsDisplayed());
    }

    @Test
    public void testXPathPosition() {
        initPage();
        assertTrue(page.isPositionDisplayed());
    }

    @Test
    public void testCssAttribute() {
        initPage();
        assertTrue(page.isCssAttributeDisplayed());
    }

    @Test
    public void testCssChild() {
        initPage();
        assertTrue(page.isCssChildDisplayed());
    }

    @Test
    public void testCssClass() {
        initPage();
        assertTrue(page.isCssClassDisplayed());
    }
}