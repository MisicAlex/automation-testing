package testsWithLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import tests.BaseTest;

public class BaseTestWithLogin extends BaseTest{

    @Override
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser){
        super.setup(browser);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("standard_user", "secret_sauce");
    }


}
