package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartPage extends BasePage {

    @FindBy(xpath = "//img[@class='-dOa_b']")
    private WebElement threeDotsIcon;

    @FindBy(xpath = "//img[@class='SFnind' and @alt='24x7 Customer Care']")
    private WebElement customerCareIcon;

    public FlipkartPage(WebDriver driver) {
        super(driver);
    }

    public void clickThreeDotsIcon() {
        threeDotsIcon.click();
    }

    public void clickCustomerCareIcon() {
        customerCareIcon.click();
    }
}
