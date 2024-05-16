package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.RatingPage;

public class RatingPageTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void testGetRatings() {
        // Open the specific product page
        driver.get("https://www.flipkart.com/shozie-stylish-shoes-girls-sneakers-women/p/itm0ceae6646b935?pid=SHOGGWVUEUDF5ZWW&lid=LSTSHOGGWVUEUDF5ZWWGVFG8W&marketplace=FLIPKART&store=osp%2Fiko&srno=b_1_1&otracker=hp_rich_navigation_5_1.navigationCard.RICH_NAVIGATION_Fashion~Women%2BFootwear_DN868DQ1FHU3&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_5_L1_view-all&fm=Search&iid=en_u_524qL9F-BRvbRplzJc8ItZEUDfH6SswhKwXSPhDs2rkfzRuFouWZDvZirtz0UDTG75s4nZgpdEKbeugPN0jg%3D%3D&ppt=browse&ppn=browse&ssid=7ilroad6ao0000001715757352216");

        // Get the ratings
        RatingPage ratingPage = new RatingPage(driver);
        String ratings = ratingPage.getRatings();
        System.out.println("Ratings: " + ratings);
    }
    
    @Test
    public void testGetAvailableOffers() {
        // Open the specific product page
        driver.get("https://www.flipkart.com/shozie-stylish-shoes-girls-sneakers-women/p/itm0ceae6646b935?pid=SHOGGWVUEUDF5ZWW&lid=LSTSHOGGWVUEUDF5ZWWGVFG8W&marketplace=FLIPKART&store=osp%2Fiko&srno=b_1_1&otracker=hp_rich_navigation_5_1.navigationCard.RICH_NAVIGATION_Fashion~Women%2BFootwear_DN868DQ1FHU3&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_5_L1_view-all&fm=Search&iid=en_u_524qL9F-BRvbRplzJc8ItZEUDfH6SswhKwXSPhDs2rkfzRuFouWZDvZirtz0UDTG75s4nZgpdEKbeugPN0jg%3D%3D&ppt=browse&ppn=browse&ssid=7ilroad6ao0000001715757352216");

        // Get the available offers
        RatingPage ratingPage = new RatingPage(driver);
        String availableOffers = ratingPage.getAvailableOffers();
        System.out.println("Available Offers: " + availableOffers);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
