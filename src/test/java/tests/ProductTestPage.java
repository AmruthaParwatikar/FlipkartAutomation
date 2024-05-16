package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.ProductPage;

public class ProductTestPage {

    private WebDriver driver;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(new BasePage(driver).getBaseUrl());
        productPage = new ProductPage(driver);
    }

    @Test
    public void testSearchProduct() {
        productPage.searchProduct("iphone");
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
