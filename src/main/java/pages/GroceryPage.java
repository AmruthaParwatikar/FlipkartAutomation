package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroceryPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Enter delivery location']")
    private WebElement pincodeInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public GroceryPage(WebDriver driver) {
        super(driver);
    }

    public void enterPincode(String pincode) {
        pincodeInput.sendKeys(pincode);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
