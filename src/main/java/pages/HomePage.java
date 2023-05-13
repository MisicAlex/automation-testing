package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By productsTitleBy = By.xpath("//span[@class='title']");
    By burgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By shoppingCartIconBy = By.className("shopping_cart_link");
    By allAddToCartButtonsBy = By.xpath("//button[contains(@id,'add-to-cart')]");
    By removeItemButtonBy = By.xpath("//button[text()='Remove']");
    By allItemsBy = By.className("inventory_item");
    By priceBy = By.className("inventory_item_price");
    By itemNameBy = By.className("inventory_item_name");


    public void verifyLogin(String expectedText) {
        assertStringEquals(readTextFromElement(productsTitleBy), expectedText);
    }

    public void logout() {
        clickElement(burgerMenuBy);
        clickElement(logoutButtonBy);
    }

    public ShoppingCartPage navigateToShoppingCart()
    {
        clickElement(shoppingCartIconBy);
        return new ShoppingCartPage(driver);
    }

    public HomePage addRandomToCart() {
        clickElement(selectRandomWebElement(allAddToCartButtonsBy));
        return this;

    }


    public HomePage removeItemfromCart() {
        clickElement(removeItemButtonBy);
        return this;

    }


    public String returnRandomItemName(){
        WebElement element = selectRandomWebElement(allItemsBy);
        return element.findElement(itemNameBy).getText();
    }
    public WebElement addItemWithSpecificName(String itemName){
        WebElement element = returnItemWithSpecificName(allItemsBy,itemNameBy, itemName);
        element.findElement(By.tagName("button")).click();
        return element;
    }
}




