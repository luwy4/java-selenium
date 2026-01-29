package base;
import session1.exercise2_1.pages.Calculator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.FileInputStream;
import java.util.Properties;

public class CalculatorBaseTest {
    protected Calculator calc;
    protected SoftAssert softAssert;
    protected Properties prop;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite: Loading properties...");
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("@BeforeTest: Preparing environment.");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("@BeforeClass: Initializing Calculator.");
        calc = new Calculator();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("@BeforeMethod: Initializing SoftAssert.");
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("@AfterMethod: Test Case Clean up.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("@AfterClass: Class Clean up.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest: Closing Test Environment.");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("@AfterSuite: Generating final reports.");
    }
}