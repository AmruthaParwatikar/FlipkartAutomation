package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import pages.SignupPage;

public class SignupTestPage {

    private WebDriver driver;
    private SignupPage signupPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com");
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testSignup() {
        signupPage.clickLoginButton();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        signupPage.clickCreateAccountLink();
        //wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
     // Wait for the page to load after clicking the "Create Account" link
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Enter mobile number
        String mobileNumber = "9573850210"; 
        signupPage.enterMobileNumber(mobileNumber);
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
