package tests;

import dataGenerator.DataProviders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest{

    @Test(dataProvider = "failedLogin", dataProviderClass = DataProviders.class)
    public void failedLogin(String username, String password, String errorMessage){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(username, password);
        loginPage.verifyFailedLogin(errorMessage);

    }

}
