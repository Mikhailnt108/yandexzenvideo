package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentContent extends BasePage {
    public PaymentContent(WebDriver driver) {
        super(driver);
    }

    public void checkOpenPopUpChoosePaymentMethodEst() {
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
    }


}
