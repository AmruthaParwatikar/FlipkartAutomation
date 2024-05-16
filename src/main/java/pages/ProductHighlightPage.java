package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductHighlightPage extends BasePage {

    @FindBy(className = "_7eSDEz")
    private List<WebElement> laptopHighlights;

    public ProductHighlightPage(WebDriver driver) {
        super(driver);
    }

    public int getProductHighlightCount() {
        return laptopHighlights.size();
    }

    public void printProductHighlight() {
        for (WebElement laptopHighlight : laptopHighlights) {
            System.out.println(laptopHighlight.getText());
        }
    }
}
