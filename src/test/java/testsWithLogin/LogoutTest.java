package testsWithLogin;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTestWithLogin{
    @Test
    public void logoutTest(){
        HomePage homePage = new HomePage(driver);
        homePage.logout();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLogout("Login");
    }

}
