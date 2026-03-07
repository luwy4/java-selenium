package session3.exercise5_2.data;

import org.testng.annotations.DataProvider;
import session3.exercise5_2.utils.DataReader;

public class LoginDataProvider {

    private static final String CSV_PATH = "src/test/resources/session3/exercise5_2/login-data.csv";

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"student", "Password123", true},
                {"invalid", "invalid", false},
                {"student", "", false}
        };
    }

    @DataProvider(name = "loginDataFromCsv")
    public Object[][] getLoginDataFromCsv() {
        return DataReader.readLoginDataFromCsv(CSV_PATH);
    }
}
