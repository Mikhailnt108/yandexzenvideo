package pages;

import base.BasePageWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentContent extends BasePageWebDriver {
    public PaymentContent(WebDriver driver) {
        super(driver);
    }

    public void checkOpenPopUpChoosePaymentMethodEst() {
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        isElementDisplayed(By.xpath("//h1[text()='Выберите способ оплаты']"));
    }


}
