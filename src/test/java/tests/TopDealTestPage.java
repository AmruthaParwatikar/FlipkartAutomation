package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TopDealPage;

public class TopDealTestPage {
    private WebDriver driver;
    private TopDealPage topDealPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        topDealPage = new TopDealPage(driver);
    }

    @Test
    public void testTopDeals() {
        // Scroll down to find Top Deals
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        topDealPage.clickTopDealsLink();
       
    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
