package testsWithLogin;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartPage;

public class RemoveItemFromCart extends BaseTestWithLogin{
    @Test
    public void removeItem(){
        HomePage homePage = new HomePage(driver);
        homePage.addRandomToCart().navigateToShoppingCart();
        homePage.removeItemfromCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.verifyItemIsNotInCart();

    }
}
