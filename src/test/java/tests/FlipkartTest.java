package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.FlipkartPage;
import utils.ScreenshotUtils;

import java.io.IOException;

public class FlipkartTest {

    private WebDriver driver;
    private FlipkartPage flipkartPage;
    private ExtentReports extent;
    private ExtentTest logger;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        flipkartPage = new FlipkartPage(driver);

        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test
    public void testFlipkartPage() {
        logger = extent.createTest("testFlipkartPage");
        driver.get("https://www.flipkart.com");
        flipkartPage.clickThreeDotsIcon(); 
        flipkartPage.clickCustomerCareIcon();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException{
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            try {
                logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test passed");
        }
    }



    @AfterTest
    public void close() {
        driver.quit();
        extent.flush();
    }
}
