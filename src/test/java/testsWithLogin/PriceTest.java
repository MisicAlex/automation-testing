package testsWithLogin;

import dataGenerator.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;

public class PriceTest extends BaseTestWithLogin{
    @Test
    public void checkPrice(){
        HomePage homePage = new HomePage(driver);
        WebElement inventoryItem = homePage.addItemWithSpecificName("Sauce Labs Onesie");
        String itemPriceAsString = inventoryItem.findElement(By.className("inventory_item_price")).getText();
        Double itemPriceAsNumber = Double.parseDouble(itemPriceAsString.substring(1));
        homePage.navigateToShoppingCart().navigateToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutData(DataCreation.generateFirstName(), DataCreation.generateLastName(), DataCreation.generatePostalCode());
        Assert.assertEquals(checkoutPage.returnTotalPriceAsNumber(), itemPriceAsNumber);




    }
}
