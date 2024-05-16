package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pages.ProductHighlightPage;

public class ProductHighlightTestPage {
    //private static final Logger logger = LogManager.getLogger(ProductHighlightTestPage.class);
	private static final Logger logger = LogManager.getLogger(ProductHighlightTestPage.class);
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/acer-intel-celeron-dual-core-n4500-8-gb-128-gb-emmc-storage-chrome-os-cb314-3h-c5qe-chromebook/p/itmf7e8ce733eb56?pid=COMGSV3G3RYBAHX4&lid=LSTCOMGSV3G3RYBAHX4EEGVFD&marketplace=FLIPKART&q=laptop&store=6bo%2Fb5g&srno=s_1_1&otracker=AS_Query_HistoryAutoSuggest_1_1_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_1_na_na_na&fm=organic&iid=en_qt8Dt7wJufDyBLxNbvDfosPcZBsv2USaTRzdDlACJGE1JUF3CV96iv24bNHDvqxG6u7uWD2efPkkOfVtv0cPAk4IsYyWu-Pj9cxFjFAoaLk%3D&ppt=hp&ppn=homepage&ssid=7aiqsglb1c0000001715664058647&qH=312f91285e048e09");
        logger.info("Browser opened and navigated to the URL");
    }

    @Test
    public void testProductHighlight() {
        ProductHighlightPage productHighlightPage = new ProductHighlightPage(driver);
        logger.info("ProductHighlightPage instance created");
        System.out.println("Number of laptop highlights: " + productHighlightPage.getProductHighlightCount());
        productHighlightPage.printProductHighlight();
        logger.info("Product highlights printed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        logger.info("Browser closed");
    }
}
