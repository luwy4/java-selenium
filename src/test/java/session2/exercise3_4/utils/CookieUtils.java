package session2.exercise3_4.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

public class CookieUtils {

    public static void saveCookies(WebDriver driver, String filePath) throws IOException {

        File file = new File(filePath);
        file.delete();
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie ck : cookies) {

            bufferedWriter.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure());

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public static void loadCookies(WebDriver driver, String filePath) throws IOException {

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] token = line.split(";");

            Cookie cookie = new Cookie(token[0], token[1], token[2], token[3], null);

            driver.manage().addCookie(cookie);
        }

        bufferedReader.close();
        fileReader.close();
    }
}
