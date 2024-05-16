package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FilterPage;

public class FilterPageTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void testSortByPriceLowToHigh() {
        FilterPage filterPage = new FilterPage(driver);
        filterPage.searchForProduct("Shoes for women");

        // Click on Price -- Low to High
        filterPage.sortByPriceLowToHigh();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
