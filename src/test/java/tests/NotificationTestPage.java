package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.NotificationPage;

public class NotificationTestPage {

    private WebDriver driver;
    private NotificationPage notificationPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com");
        notificationPage = new NotificationPage(driver);
    }

    @Test
    public void testNotificationPreferences() {
        notificationPage.clickThreeDotsIcon();
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        
        notificationPage.selectNotificationPreferencesOption();
        
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
 
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
