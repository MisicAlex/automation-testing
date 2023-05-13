package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    By removeButtonBy = By.xpath("//button[text()='Remove']");
    By cartItemBy = By.className("cart_item");
    By itemNameBy = By.className("inventory_item_name");
    By checkoutButtonBy = By.id("checkout");
    public void verifyItemIsInCart(){
        isElementDisplayed(removeButtonBy );
    }
    public void verifyItemIsNotInCart(){
        Assert.assertTrue(isElementNotDisplayed(removeButtonBy));
    }
    public void navigateToCheckout(){
        clickElement(checkoutButtonBy);
    }

}
