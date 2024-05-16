package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.DetailsPage;

public class DetailsPageTest {
	
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DetailsPageTest.class);

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
    	//options.setHeadless(true);
    	options.addArguments("--remote-allow-origins=*");
    	driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void testGetProductDetails() {
        // Open the specific product page
        driver.get("https://www.flipkart.com/shozie-sneakers-women/p/itmf3b164ecfa003?pid=SHOGHNEUGJ7GUSPZ&lid=LSTSHOGHNEUGJ7GUSPZ0D7HIV&marketplace=FLIPKART&store=osp%2Fiko&srno=b_1_7&otracker=hp_rich_navigation_5_1.navigationCard.RICH_NAVIGATION_Fashion~Women%2BFootwear_DN868DQ1FHU3&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_5_L1_view-all&fm=Search&iid=en_u_524qL9F-BRvbRplzJc8ItZEUDfH6SswhKwXSPhDs2pp90EbvcCsxBSVCDuc8CkQsO_Rkc1_jy0TuQ90b4SQg%3D%3D&ppt=browse&ppn=browse");

        // Click on product details
        DetailsPage detailsPage = new DetailsPage(driver);
        detailsPage.clickProductDetails();

        // Get and print the product details
        String productDetails = detailsPage.getProductDetails();
        logger.info("Product Details: " + productDetails);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
