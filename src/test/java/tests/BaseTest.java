package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.PropertyManager;

public class BaseTest {
    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("Chrome") String browser) {

        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized").addArguments("--remote-allow-origins=*"));
            driver.get(PropertyManager.getInstance().getUrl());

        } else if (browser.toLowerCase().equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().addArguments("--start-maximized"));
                driver.get(PropertyManager.getInstance().getUrl());
            }
        }

        @AfterMethod
        public void closeBrowser(){
            driver.quit();
        }
        public WebDriver getDriver(){
        return driver;
        }

}


