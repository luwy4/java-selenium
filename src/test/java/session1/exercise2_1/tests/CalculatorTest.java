package session1.exercise2_1.tests;
import base.CalculatorBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CalculatorTest extends CalculatorBaseTest {

    @Test(priority = 1, groups = "math_basic")
    public void testAdd() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double b = Double.parseDouble(prop.getProperty("val2"));
        double expected = Double.parseDouble(prop.getProperty("exp_add"));
        Assert.assertEquals(calc.add(a, b), expected);
    }

    @Test(priority = 2, groups = "math_basic")
    public void testSubtract() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double b = Double.parseDouble(prop.getProperty("val2"));
        double expected = Double.parseDouble(prop.getProperty("exp_sub"));
        Assert.assertEquals(calc.subtract(a, b), expected);
    }

    @Test(priority = 3, groups = "math_basic")
    public void testMultiply() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double b = Double.parseDouble(prop.getProperty("val2"));
        double expected = Double.parseDouble(prop.getProperty("exp_mul"));
        Assert.assertEquals(calc.multiply(a, b), expected);
    }

    @Test(priority = 4, groups = "math_basic")
    public void testDivide() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double b = Double.parseDouble(prop.getProperty("val2"));
        double expected = Double.parseDouble(prop.getProperty("exp_div"));
        Assert.assertEquals(calc.divide(a, b), expected);
    }

    @Test(priority = 5, groups = "edge_case")
    public void testDivideByZero() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double zero = Double.parseDouble(prop.getProperty("zero_val"));

        Assert.assertThrows(ArithmeticException.class, () -> calc.divide(a, zero));
    }

    @Test(priority = 6, groups = "advanced")
    public void testWithSoftAssert() {
        double a = Double.parseDouble(prop.getProperty("val1"));
        double b = Double.parseDouble(prop.getProperty("val2"));
        double expectedAdd = Double.parseDouble(prop.getProperty("exp_add"));
        double expectedMul = Double.parseDouble(prop.getProperty("exp_mul"));

        softAssert.assertEquals(calc.add(a, b), expectedAdd, "Soft Add Failed");
        softAssert.assertEquals(calc.multiply(a, b), expectedMul, "Soft Multiply Failed");
        softAssert.assertAll();
    }
}