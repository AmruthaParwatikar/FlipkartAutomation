package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ReadExcelData;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        driver.get(homePage.getBaseUrl());
    }

    @Test
    public void testSearchProduct() throws Exception {
        String product = ReadExcelData.getTestData("C:\\Users\\amrutaparwatikar\\eclipse-workspace\\FlipkartAutomation\\testdata.xlsx", 0, "searchData", 1);
        homePage.searchForProduct(product);
        
    }

    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
