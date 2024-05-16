package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ListPage;

import java.util.List;

public class ListPageTest {

    private WebDriver driver;
    private ListPage listPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        listPage = new ListPage(driver);
    }

    @Test
    public void testListPage() {
        // Search for iPhone
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Get product names from the first page
        List<String> productNames = listPage.getProductNames();
        for (String name : productNames) {
            System.out.println("Product Name: " + name);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
