package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroceryTestPage {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    @Test
    public void testGroceryPincode() throws InterruptedException {
        // Click on the grocery icon
        WebElement groceryIcon = driver.findElement(By.cssSelector("img[src='https://rukminim2.flixcart.com/flap/96/96/image/29327f40e9c4d26b.png?q=100']"));
        groceryIcon.click();

        // Wait for the pop-up to appear and then enter the pin code
        Thread.sleep(2000); // Adjust the sleep time as needed
        WebElement pincodeInput = driver.findElement(By.cssSelector("input[name='pincode']"));
        pincodeInput.sendKeys("500044");
        pincodeInput.sendKeys(Keys.ENTER);
        

        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
