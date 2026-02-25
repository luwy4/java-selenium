package base;

import session1.exercise2_1.pages.Calculator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.util.Properties;

public class CalculatorBaseTest {

    protected Calculator calc;
    protected SoftAssert softAssert;
    protected Properties prop;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("@BeforeClass: Loading properties & initializing Calculator");

        prop = new Properties();
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException("config.properties not found in src/test/resources");
            }
            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        calc = new Calculator();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("@AfterMethod: Test Case Clean up.");
    }
}
