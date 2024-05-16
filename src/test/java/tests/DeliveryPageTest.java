package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DeliveryPage;
;

public class DeliveryPageTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void testViewDetails() {
        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage.searchForProduct("Heels for women");
        // Open the specific product page
        driver.get("https://www.flipkart.com/denill-women-pink-heels/p/itm53341fb0ac8fc?pid=SNDGXHHEQRBJB8QW&lid=LSTSNDGXHHEQRBJB8QWDWHZ6O&marketplace=FLIPKART&q=heels+for+women&store=osp%2Fiko%2F6q1&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=en_zhtJUfL6mpjnI9f7LzmQrAwneLOqjIcyTE98_SStI_uCT4HSc2i2mUW5sPj_31FzNkKCGJSrhPDXxPdjYX4Yjg%3D%3D&ppt=sp&ppn=sp&ssid=6kv2q504zk0000001715756744942&qH=5ae391f7fb8756db");

        // Click on 'View Details'
       
        deliveryPage.clickViewDetails();
        
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
