import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;

public class CartTestPage {

    private WebDriver driver;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        
        driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com/apple-iphone-15-black-128-gb/p/itm6ac6485515ae4?pid=MOBGTAGPTB3VS24W&lid=LSTMOBGTAGPTB3VS24WVZNSC6&marketplace=FLIPKART&q=iphone&store=tyy%2F4io&spotlightTagId=BestsellerId_tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=3ed6b2e2-c61c-4602-81ae-a91d00e87cfe.MOBGTAGPTB3VS24W.SEARCH&ppt=sp&ppn=sp&ssid=ylyid41yjk0000001715672147721&qH=0b3f45b266a97d70");
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddToCart() throws InterruptedException{
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartPage.addToCartButton);
    	
        cartPage.addToCartButton.click();
        Thread.sleep(2000);
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
