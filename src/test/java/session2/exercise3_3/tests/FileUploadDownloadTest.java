package session2.exercise3_3.tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import session2.exercise3_3.pages.FileUploadDownloadPage;

import java.io.File;

public class FileUploadDownloadTest extends BaseTest {
    private FileUploadDownloadPage filePage;
    private String downloadPath = System.getProperty("user.home") + "/Downloads/";

    @BeforeClass
    public void initPage() {
        filePage = new FileUploadDownloadPage(driver);
    }

    @Test(priority = 1)
    public void testSingleFileUpload() {
        filePage.openPage();

        String filePath = new File("src/test/resources/files/file1.txt").getAbsolutePath();
        filePage.uploadFile(filePath);

        String uploadedPath = filePage.getUploadedFilePath();
        Assert.assertTrue(uploadedPath.contains("file1.txt"), "Upload failed!");
    }

    @Test(priority = 2)
    public void testMultipleFileUploads() {
        filePage.openPage();

        String file1 = new File("src/test/resources/files/file1.txt").getAbsolutePath();
        String file2 = new File("src/test/resources/files/file2.txt").getAbsolutePath();

        filePage.uploadFile(file1);
        Assert.assertTrue(filePage.getUploadedFilePath().contains("file1.txt"), "Upload file1 failed!");

        filePage.uploadFile(file2);
        Assert.assertTrue(filePage.getUploadedFilePath().contains("file2.txt"), "Upload file2 failed!");
    }

    @Test(priority = 3)
    public void testFileDownload() throws InterruptedException {
        filePage.openPage();
        filePage.clickDownloadButton();

        Thread.sleep(5000);

        boolean isDownloaded = filePage.isFileDownloaded(downloadPath, "sampleFile.jpeg");
        Assert.assertTrue(isDownloaded, "File not downloaded or empty!");
    }
}
