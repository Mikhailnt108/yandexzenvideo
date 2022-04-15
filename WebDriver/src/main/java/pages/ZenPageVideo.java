package pages;

import base.BasePageWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenPageVideo extends BasePageWebDriver {
    public ZenPageVideo(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("checkElementsZenPageVideo")
    public void checkElementsZenPageVideo() {
        isElementDisplayed(By.xpath("//div[contains(@class,'sidebar-item-view _active _size')]//div[text()='Видео' or 'Video']"));
        By logoYa = By.xpath("//a[@href='https://yandex.ru']//*[contains(@class,'logo-type_default')]");
        isElementNotDisplayed(logoYa);
        isElementDisplayed(By.xpath("//a[@href='/video']//*[contains(@class,'logo-type_video')]"));
    }
    @Step("inputRequest {request}")
    public void inputRequest(String request) {
        writeText(By.xpath("//input[contains(@class,'input')]"), request);
        click(By.xpath("//button[@type='submit']"));
        checkOpenUrl(zen+"search");
    }
}
