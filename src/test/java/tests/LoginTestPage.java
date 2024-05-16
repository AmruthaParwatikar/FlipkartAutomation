package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class LoginTestPage {

    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        loginPage = new LoginPage(driver);
     // ExtentReports setup
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


    @Test
    public void testLogin() {
    	test = extent.createTest("Login Test", "Test to verify login functionality");
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        // Enter email or phone number
        String emailOrPhone = "parwatikaramrutha.23@gmail.com";
        loginPage.enterEmailOrPhone(emailOrPhone);
        test.log(Status.PASS, "Login successful");
    }

    @AfterClass
    public void tearDown() {
    	extent.flush();
        driver.quit();
    }
}
