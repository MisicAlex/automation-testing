package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword());
        HomePage homePage = new HomePage(driver);
        homePage.verifyLogin("Products");
    }
}
