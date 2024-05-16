package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'New to Flipkart? Create an account')]")
    private WebElement createAccountLink;

    @FindBy(css = "input[class='r4vIwl BV+Dqf']")
    private WebElement mobileNumberInput;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickCreateAccountLink() {
        createAccountLink.click();
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }
}
