package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties prop;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver, this);
    }
    
    public void searchForProduct(String productName) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(productName);
        searchBox.submit();

        // Wait for search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_4rR01T")));
    }

    public String getBaseUrl() {
        return prop.getProperty("url");
    }

    
}
