package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DetailsPage extends BasePage {
	 private static final Logger logger = LogManager.getLogger(DetailsPage.class);

    @FindBy(xpath = "//div[@class='col col-11-12 rYpYQA' and contains(text(),'Product Details')]")
    private WebElement productDetailsButton;

    @FindBy(xpath = "//div[@class='row _1IK+Dg']")
    private WebElement productDetails;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductDetails() {
    	logger.info("Clicking on Product Details button");
        productDetailsButton.click();
    }

    public String getProductDetails() {
        return productDetails.getText();
    }
}
