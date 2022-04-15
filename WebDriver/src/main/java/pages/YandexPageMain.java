package pages;

import base.BasePageWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class YandexPageMain extends BasePageWebDriver {
    public YandexPageMain(WebDriver webDriver) {
        super(webDriver);

    }
    @Step("openYandexPageMain")
    public void openYandexPageMain() {
        webDriver.get(yandex);
        checkOpenUrl(yandex);
    }
    @Step("goToZenPageFeed")
    public void goToZenPageFeed() {
        click(By.xpath("//a[contains(@class,'services-new__more')]//div[text()='ещё']"));
        click(By.xpath("//a[@data-id='zen']//div[text()='Дзен']"));
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(1));
        checkOpenUrl(zen);
    }
}
