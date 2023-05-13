package testsWithLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class AddRandomItemToCart extends BaseTestWithLogin{
    @Test
    public void addRandomItemToCart()  {
        HomePage homePage = new HomePage(driver);
        homePage.addRandomToCart().navigateToShoppingCart().verifyItemIsInCart();




    }
}
