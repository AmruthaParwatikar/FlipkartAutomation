package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SizePage;

public class SizePageTest {
    private WebDriver driver;

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
    public void testSelectSize() {
        SizePage sizePage = new SizePage(driver);
        sizePage.searchForProduct("Jeans for women");

        // Open the specific jeans product page
        driver.get("https://www.flipkart.com/fashionfibre-regular-women-light-blue-jeans/p/itm74f8e033775d1?pid=JEAGHE9MGJGK2KBR&lid=LSTJEAGHE9MGJGK2KBRRJ7O4R&marketplace=FLIPKART&q=jeans+for+women&store=clo%2Fvua%2Fk58%2F4hp&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=en_TD_md4RWGNu2fWGWG1KgDHe0x_Eot7XxOu-9yeXog7XuMEWkxtKkEm69TsdU0cTP2QPLjwlFFLfOaO_0xFkRkw%3D%3D&ppt=sp&ppn=sp&ssid=dh4d9ot2eo0000001715754522100&qH=1df1dc5bbc4009de");

        // Select size 32
        sizePage.selectSize32();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
