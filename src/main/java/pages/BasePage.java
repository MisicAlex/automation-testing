package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
    }

    public void waitClickability(By elementLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitClickability(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void clickElement(By elementLocator) {
        waitVisibility(elementLocator);
        waitClickability(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void clickElement(WebElement elementToClick) {
        waitClickability(elementToClick);
        elementToClick.click();

    }

    public void writeText(By elementLocator, String text) {
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public String readTextFromElement(By elementLocator) {
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getText();
    }

    public void assertStringEquals(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public String readAttributeValue(By elementLocator, String attributeName) {
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getAttribute(attributeName);

    }

    public WebElement selectRandomWebElement(By elementLocator) {
        List<WebElement> webElementList = driver.findElements(elementLocator);
        if (webElementList.size() == 0) {
            throw new SkipException("There is no available items.");
        } else {

            Random random = new Random();
            int size = webElementList.size();
            int selection = random.nextInt(size - 1);
            return webElementList.get(selection);

        }
    }
        public void isElementDisplayed (By elementLocator){
            Assert.assertTrue(driver.findElement(elementLocator).isDisplayed());
        }
        public boolean isElementNotDisplayed (By elementLocator){
            if (driver.findElements(elementLocator).size() > 0) {
                return false;
            } else {
                return true;
            }
        }
        public WebElement returnItemWithSpecificName(By elementLocator, By itemNameLocator, String itemName){
        List<WebElement> itemsList = driver.findElements(elementLocator);
        WebElement elementWithSpecificName = null;
        for (WebElement element : itemsList){
            String item = element.findElement(itemNameLocator).getText();
            if (item.equals(itemName)){
                elementWithSpecificName = element;
                break;
            }
        }
        return elementWithSpecificName;

        }
    }

