package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By firstNameFieldBy = By.id("first-name");
    By lastNameFieldBy = By.id("last-name");
    By postalCodeFieldBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By totalPriceBy = By.className("summary_subtotal_label");
    public void fillCheckoutData(String firstName, String lastName, String postalCode){
        writeText(firstNameFieldBy, firstName);
        writeText(lastNameFieldBy, lastName);
        writeText(postalCodeFieldBy, postalCode);
        clickElement(continueButtonBy);


    }
    public Double returnTotalPriceAsNumber(){
        return Double.parseDouble(readTextFromElement(totalPriceBy).substring(13));

    }
}
