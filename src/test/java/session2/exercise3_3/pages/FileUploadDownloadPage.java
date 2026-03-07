package session2.exercise3_3.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session1.utils.ConfigReader;

import java.io.File;

public class FileUploadDownloadPage {
    private WebDriver driver;

    private By uploadInput = By.id("uploadFile");
    private By uploadedPath = By.id("uploadedFilePath");
    private By downloadButton = By.id("downloadButton");

    public FileUploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(ConfigReader.get("url3.3"));
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadInput).sendKeys(filePath);
    }

    public String getUploadedFilePath() {
        return driver.findElement(uploadedPath).getText();
    }

    public void clickDownloadButton() {
        driver.findElement(downloadButton).click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath + fileName);
        return file.exists() && file.length() > 0;
    }
}
